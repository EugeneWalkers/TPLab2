package bank.boundary;

import bank.Main;
import bank.controllers.ReferentFrameController;
import bank.entities.User;

import javax.swing.*;
import java.awt.*;

public class ReferentFrame extends JFrame {

    private ReferentFrameController mReferentFrameController;
    private JPanel panel = new JPanel();

    ReferentFrame(User user) {
        super(user.getName());
        mReferentFrameController = new ReferentFrameController();
        setWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setWindow() {
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        JButton callRequest = new JButton("Call Request");
        JButton analyseAndAccept = new JButton("Analyse And Accept");
        JButton checkFinances = new JButton("Check finances");
        JButton exit = new JButton("Exit");
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 7, 7));
        JScrollPane requests = getScrollPane();

        callRequest.addActionListener(e -> {
            panel = mReferentFrameController.getPanelScrollPane(panel);
            revalidate();
        });

        analyseAndAccept.addActionListener(e -> {

        });

        checkFinances.addActionListener(e -> {

        });

        exit.addActionListener(e -> {
            Main.loginer.setVisible(true);
            setVisible(false);
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        add(callRequest, c);
        c.gridy = 1;
        add(requests, c);
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        add(analyseAndAccept, c);
        c.gridy = 3;
        add(checkFinances, c);
        c.gridy = 4;
        add(exit, c);
    }

    private JScrollPane getScrollPane() {
        JScrollPane pane = new JScrollPane(panel);
        pane.setMinimumSize(new Dimension(100, 100));
        panel.setLayout(new GridLayout(0, 1, 5, 5));
        return pane;
    }

    public void getAnswerFromCreditDepartment() {

    }

    public void getListOfCurrentRequests() {

    }

    public void save() {

    }

    public void selectRequest() {

    }

    public void sendAnswer() {

    }

    public void sendToCreditDepartment() {

    }

    public void showListOfRequest() {

    }

    public void updateRequest() {

    }
}//end ReferentFrame