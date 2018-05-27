package bank.controllers;

import bank.boundary.DataAccessor;
import bank.entities.EmployeeAcceptListener;
import bank.entities.RequestWithReport;

import javax.swing.*;

public class EmployeeFrameController {

	public EmployeeFrameController(){

	}

    public JPanel getPanelScrollPane(JPanel panel){
        panel.removeAll();
        for (final RequestWithReport request : DataAccessor.getRequestsForReferent()) {
            if (!request.isAcceptedFromBankEmployee()) {
                final JButton button = new JButton(request.getRequest().toString());
                button.addActionListener(new EmployeeAcceptListener(request));
                panel.add(button);
            }
        }
        return panel;
    }

	public void selectLoanRequest(){

	}

	public void save(){

	}
}//end EmployeeFrameController