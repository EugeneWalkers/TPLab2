package bank.entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAnalyseAndAcceptListener implements ActionListener {

    private final RequestWithReport requestWithReport;

    private class Reporter extends JFrame {
        Reporter() {
            super("Report for " + requestWithReport.getRequest().getClientName());
            final GetRequest request = requestWithReport.getRequest();
            //final Report report = requestWithReport.getReport();

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(250, 150);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(0, 2, 10, 10));

            add(new JLabel("Id:"));
            add(new JLabel(String.valueOf(request.getId())));
            add(new JLabel("Client:"));
            add(new JLabel(request.getClientName()));
            add(new JLabel("Value:"));
            add(new JLabel(String.valueOf(request.getValue())));

            JButton ok = new JButton("Ok");
            add(ok);

            ok.addActionListener(e1 -> {

                this.dispose();
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Reporter().setVisible(true);
    }

    public ButtonAnalyseAndAcceptListener(RequestWithReport requestWithReport) {
        this.requestWithReport = requestWithReport;
    }
}
