package bank.entities;

import bank.boundary.DataAccessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeAcceptListener implements ActionListener {

    private final RequestWithReport requestWithReport;

    private class Reporter extends JFrame {
        Reporter() {
            super("Report for " + requestWithReport.getRequest().getClientName());
            final GetRequest request = requestWithReport.getRequest();
            final Report report = requestWithReport.getReport();
            final String reportLabelText;
            if (report == null) {
                reportLabelText = "Report hasn't been attached yet :( ";
            } else {
                reportLabelText = report.toString();
            }

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(250, 150);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(0, 2, 10, 10));

            add(new JLabel("Id:"));
            add(new JLabel(String.valueOf(request.getId())));
            add(new JLabel("Client:"));
            add(new JLabel(request.getClientName()));
            add(new JLabel("Report:"));
            add(new JLabel(reportLabelText));

            JButton ok = new JButton("Accept");
            add(ok);
            ok.addActionListener(e1 -> {
                DataAccessor.acceptCopyOfTheReport(request);
                this.dispose();
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Reporter().setVisible(true);
    }

    public EmployeeAcceptListener(RequestWithReport requestWithReport) {
        this.requestWithReport = requestWithReport;
    }
}
