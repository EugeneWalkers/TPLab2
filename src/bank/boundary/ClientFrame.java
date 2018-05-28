package bank.boundary;

import bank.Main;
import bank.entities.User;

import javax.swing.*;
import java.awt.*;

public class ClientFrame extends JFrame {

    private JButton sendRequestForCredit;
    private JTextArea reportWriter;
    private JButton exit = new JButton("Exit");
    private JTextField value = new JTextField();
    private User user;

    ClientFrame(User user) {
        super(user.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        this.user = user;
        sendRequestForCredit = new JButton("Get Credit");
        reportWriter = new JTextArea();
        reportWriter.setToolTipText("Write you report here");
        reportWriter.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1)));
        reportWriter.setMinimumSize(new Dimension(100, 400));
        setButtons();
        sendRequestForCredit.setEnabled(!DataAccessor.isUserInQueue(user));
        sendRequestForCredit.addActionListener(e -> {
            if (!value.getText().equals("")
                    && DataAccessor.writeToQueue(user, Integer.parseInt(value.getText()))
                    //&& DataAccessor.writeReport(DataAccessor.getIdByUsername(user.getName()), reportWriter.getText())
                    && DataAccessor.incrementId()) {
                sendRequestForCredit.setEnabled(false);
                String st =reportWriter.getText();
                DataAccessor.createUserReport(st, user.getName());
            }
        });

        exit.addActionListener(e -> {
            Main.loginer.setVisible(true);
            setVisible(false);
        });
    }

    private void setButtons() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weighty = 1;
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
        add(new JLabel("Write your report:"), c);
        c.gridy = 4;
        c.weighty = 3;
        c.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(reportWriter), c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1;
        c.gridy = 5;
        add(sendRequestForCredit, c);
        c.gridy = 6;
        add(exit, c);
    }

}
