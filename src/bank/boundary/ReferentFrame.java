package bank.boundary;

import bank.Main;
import bank.controllers.ReferentFrameController;
import bank.entities.User;

import javax.swing.*;
import java.awt.*;

public class ReferentFrame extends JFrame {

    private ReferentFrameController mReferentFrameController;
    private JPanel panelAnalyseAndAccept, panelCallRequest, panelCheckFinances ;

    ReferentFrame(User user) {
        super(user.getName());
        mReferentFrameController = new ReferentFrameController();
        setWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        panelAnalyseAndAccept = new JPanel();
        panelAnalyseAndAccept.setLayout(new GridLayout(0, 1, 7, 7));
        panelCallRequest = new JPanel();
        panelCallRequest.setLayout(new GridLayout(0, 1, 7, 7));
        panelCheckFinances = new JPanel();
        panelCheckFinances.setLayout(new GridLayout(0, 1, 7, 7));

        JScrollPane scrollPaneForAnalyseAndAccept = getScrollPane(panelAnalyseAndAccept);
        JScrollPane scrollPaneForCallRequest = getScrollPane(panelCallRequest);
        JScrollPane scrollPaneForCheckFinances = getScrollPane(panelCheckFinances);

        JButton analyseAndAccept = new JButton("Analyse and Accept");
        JButton callRequest = new JButton("Call Request");
        JButton checkFinances = new JButton("Check Finances");


        JButton exit = new JButton("Exit");

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        add(analyseAndAccept, c);
        c.gridy = 1;
        add(scrollPaneForAnalyseAndAccept, c);
        c.gridy = 2;
        add(callRequest, c);
        c.gridy = 3;
        //c.fill = GridBagConstraints.BOTH;
        add(scrollPaneForCallRequest, c);
        c.gridy = 4;
        add(checkFinances, c);
        c.gridy = 5;
        add(scrollPaneForCheckFinances, c);
        c.gridy = 6;
        add(exit, c);

        analyseAndAccept.addActionListener(e -> {
            panelAnalyseAndAccept = mReferentFrameController.getPanelScrollPaneForAnalyseAndAccept(panelAnalyseAndAccept);

            revalidate();
        });

        callRequest.addActionListener(e -> {
            panelCallRequest = mReferentFrameController.getPanelScrollPaneForCallRequest(panelCallRequest);
            revalidate();
        });

        checkFinances.addActionListener(e -> {
            panelCheckFinances = mReferentFrameController.getPanelScrollPaneForCheckFinances(panelCheckFinances);
            revalidate();
        });

        exit.addActionListener(e -> {
            Main.loginer.setVisible(true);
            setVisible(false);
        });


    }

    private JScrollPane getScrollPane(JPanel panel) {
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