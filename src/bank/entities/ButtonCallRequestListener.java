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
            final String reportLabelText;
            if (!requestWithReport.isRedirectedToBankEmployee()&&!requestWithReport.isAcceptedFromBankEmployee()) {
                reportLabelText = "Report hasn't been attached yet :( ";
            } else {
                final Report r = DataAccessor.getReport(request.getClientName());
                if (r!=null) {
                    reportLabelText = r.toString();
                } else {
                    reportLabelText = "Report doesn't exist";
                }
            }

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(350, 150);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(0, 2, 10, 10));

            JLabel reportLabel = new JLabel(reportLabelText);
            add(new JLabel("Report:"));
            add(reportLabel);
            add(new JLabel("Accepted from Employee:"));
            add(new JLabel(String.valueOf(requestWithReport.isAcceptedFromBankEmployee())));
            JButton getReport = new JButton("Get report");
            add(getReport);
            if (requestWithReport.isRedirectedToBankEmployee()||requestWithReport.isAcceptedFromBankEmployee()) {
                getReport.setEnabled(false);
            }
            JButton ok = new JButton("Ok");
            add(ok);
            ok.addActionListener(e1 -> {

                this.dispose();
            });

            getReport.addActionListener(e-> {
                requestWithReport.setReport(
                        DataAccessor.getReport(request.getClientName())
                );
                if (requestWithReport.getReport()!=null) {
                    reportLabel.setText(requestWithReport.getReport().toString());
                    DataAccessor.sendCopyOfTheReportToBankEmployee(request);
                    getReport.setEnabled(false);
                    requestWithReport.setRedirectedToBankEmployee(true);
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
