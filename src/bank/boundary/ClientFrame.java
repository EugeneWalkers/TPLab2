package bank.boundary;

import bank.entities.User;
import bank.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ClientFrame extends JFrame {

    public JButton getSendRequestForCredit() {
        return sendRequestForCredit;
    }

    private JButton sendRequestForCredit = new JButton("Get Credit");
    private JButton exit = new JButton("Exit");
    private JTextField value = new JTextField();

    ClientFrame(User user) {
        super(user.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        add(new JLabel("Hello, " + user.getName() + "!"), c);
        c.gridy = 1;
        add(new JLabel("How much money do you want? ($)"), c);
        c.gridy = 2;
        add(value, c);
        c.gridy = 3;
        add(sendRequestForCredit, c);
        c.gridy = 4;
        add(exit, c);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("waitingClients.txt"));
            StringBuilder builder = new StringBuilder("");
            while(!builder.append(reader.readLine()).toString().equals("null")){
                if(builder.toString().split(":")[0].equals(user.getName())){
                    sendRequestForCredit.setEnabled(false);
                    break;
                }
                builder.delete(0, builder.length());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        sendRequestForCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter writer = null;
                try {
                    writer = new FileWriter("waitingClients.txt", true);
                    writer.append(user.getName()).append(":").append(value.getText()).append("\n");
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                finally {
                    if (writer != null){
                        try {
                            writer.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                sendRequestForCredit.setEnabled(false);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.loginer.setVisible(true);
                setVisible(false);
            }
        });
    }
}
