package bank.controllers;

import bank.boundary.DataAccessor;
import bank.entities.ButtonEditListener;
import bank.entities.GetRequest;
import bank.entities.RequestList;

import javax.swing.*;
import java.util.ArrayList;

public class ClerkFrameController {

    public ClerkFrameController() {

    }

    public JPanel getPanelScrollPaneForEdit(JPanel panel) {
        panel.removeAll();
        RequestList requests = DataAccessor.getRequestsForReview();
        ArrayList<GetRequest> rs = requests.getmGetRequest();
        for (GetRequest r : rs) {
            JButton button = new JButton(r.toString());
            button.addActionListener(new ButtonEditListener(button, r));
            panel.add(button);
        }
        return panel;
    }

    public JPanel getPanelScrollPaneForCreate(JPanel panel) {
        panel.removeAll();
        RequestList requests = DataAccessor.getRequestsForReview();
        ArrayList<GetRequest> rs = requests.getmGetRequest();
        for (GetRequest r : rs) {
            JButton button = new JButton(r.toString());
            button.addActionListener(e -> {
                DataAccessor.saveRequest(r);
                button.setEnabled(false);
            });
            panel.add(button);
        }
        return panel;
    }

    public void saveLoanRequest() {

    }

    public void selectRequest() {

    }
}//end ClerkFrameController