package bank.entities;

import bank.boundary.DataAccessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCallRequestListener implements ActionListener {

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
            setSize(450, 350);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(0, 2, 10, 10));

            add(new JLabel("Id:"));
            add(new JLabel(String.valueOf(request.getId())));
            add(new JLabel("Client:"));
            add(new JLabel(request.getClientName()));
            add(new JLabel("Value:"));
            JTextField valueChanged = new JTextField();
            valueChanged.setText(String.valueOf(request.getValue()));
            add(valueChanged);
            JLabel reportLabel = new JLabel(reportLabelText);
            add(new JLabel("Report:"));
            add(reportLabel);
            add(new JLabel("Accepted:"));
            add(new JLabel(String.valueOf(requestWithReport.isAcceptedFromBankEmployee())));
            JButton checkFinances = new JButton("Check finances");
            add(checkFinances);
            JButton ok = new JButton("Save");
            add(ok);
            if (requestWithReport.isAcceptedFromBankEmployee()&&requestWithReport.getReport()!=null) {
                ok.setEnabled(true);
            } else {
                ok.setEnabled(false);
            }

            ok.addActionListener(e1 -> {

                this.dispose();
            });

            checkFinances.addActionListener(e-> {
                requestWithReport.setReport(
                        DataAccessor.getReport(request.getClientName())
                );
                if (requestWithReport.getReport()!=null) {
                    reportLabel.setText(requestWithReport.getReport().toString());
                    if (requestWithReport.isAcceptedFromBankEmployee()) {
                        ok.setEnabled(true);
                    }
                }
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Reporter().setVisible(true);
    }

    public ButtonCallRequestListener(RequestWithReport requestWithReport) {
        this.requestWithReport = requestWithReport;
    }
}
