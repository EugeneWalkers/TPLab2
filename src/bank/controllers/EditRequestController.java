package bank.controllers;

import bank.boundary.ButtonEditListener;
import bank.boundary.DataAccessor;
import bank.boundary.EditRequest;
import bank.entities.GetRequest;
import bank.entities.RequestList;

import javax.swing.*;
import java.util.ArrayList;

public class EditRequestController {

	public DataAccessor mDataAccessor;
	public EditRequest mEditRequest;

	public EditRequestController(){

	}

	public JPanel getPanelScrollPane(JPanel panel){
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

	public void saveLoanRequest(){

	}

	public void selectRequest(){

	}
}//end EditRequestController