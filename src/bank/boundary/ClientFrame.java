package bank.boundary;

import bank.Main;
import bank.entities.User;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ClientFrame extends JFrame {

    private JButton sendRequestForCredit = new JButton("Get Credit");
    private JButton exit = new JButton("Exit");
    private JTextField value = new JTextField();
    private DataAccessor dataAccessor;
    private User user;

    ClientFrame(User user) {
        super(user.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        this.user = user;
        setButtons();
        dataAccessor = new DataAccessor();
        sendRequestForCredit.setEnabled(!dataAccessor.isUserInQueue(user));
        sendRequestForCredit.addActionListener(e -> {
            if (!value.getText().equals("")
                    && dataAccessor.writeToQueue(user, Integer.parseInt(value.getText()))){
                sendRequestForCredit.setEnabled(false);
            }
        });

        exit.addActionListener(e -> {
            Main.loginer.setVisible(true);
            setVisible(false);
        });
    }

    private void setButtons(){
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
    }

}
