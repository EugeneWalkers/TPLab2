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
            final String userReportLabelText;
            if (!requestWithReport.isRedirectedToBankEmployee() && !requestWithReport.isAcceptedFromBankEmployee()) {
                reportLabelText = "Report hasn't been attached yet";
                userReportLabelText="Report hasn't been attached yet";
            } else {
                final String r = DataAccessor.getReport(request.getClientName());
                final String r1 = DataAccessor.getUserReport(request.getClientName());
                if (r != null) {
                    reportLabelText = r.toString();
                    userReportLabelText=r1.toString();
                } else {
                    reportLabelText = "Report doesn't exist";
                    userReportLabelText=r1.toString();
                }
            }

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(350, 150);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(0, 2, 10, 10));

            JLabel reportLabel = new JLabel(reportLabelText);
            JLabel reportLabel1 = new JLabel(userReportLabelText);
            add(new JLabel("Report:"));
            add(reportLabel);
            add(new JLabel("User report:"));
            add(reportLabel1);

            JButton getReport = new JButton("Send for verification");

            getReport.addActionListener(e -> {
                requestWithReport.setReports(
                        DataAccessor.getReport(request.getClientName()),
                        DataAccessor.getUserReport(request.getClientName())
                );

                getReport.setEnabled(false);
                if (requestWithReport.getReport() != null) {
                    reportLabel.setText(requestWithReport.getReport());
                    reportLabel1.setText(requestWithReport.getUserReport());
                    DataAccessor.sendCopyOfTheReportToBankEmployee(request);
                    requestWithReport.setRedirectedToBankEmployee(true);
                }
            });

            add(getReport);
            if (requestWithReport.isRedirectedToBankEmployee() || requestWithReport.isAcceptedFromBankEmployee()) {
                getReport.setEnabled(false);
            }
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

    public ButtonCallRequestListener(RequestWithReport requestWithReport) {
        this.requestWithReport = requestWithReport;
    }
}
