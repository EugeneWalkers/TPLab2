package bank.controllers;

import bank.boundary.ReferentFrame;
import bank.entities.ButtonCallRequestListener;
import bank.entities.ButtonEditListener;
import bank.boundary.DataAccessor;
import bank.entities.GetRequest;
import bank.entities.RequestList;

import javax.swing.*;
import java.util.ArrayList;

public class ReferentFrameController {

	public DataAccessor mDataAccessor;
	public ReferentFrame mReferentFrame;

	public ReferentFrameController(){

	}

	public void save(){

	}

	public JPanel getPanelScrollPane(JPanel panel){
		panel.removeAll();
		RequestList requests = DataAccessor.getRequestsForReview();
		ArrayList<GetRequest> rs = requests.getmGetRequest();
		for (GetRequest r : rs) {
			JButton button = new JButton(r.toString());
			button.addActionListener(new ButtonCallRequestListener(button, r));
			panel.add(button);
		}
		return panel;
	}

	public void selectLoanRequest(){

	}
}//end ReferentFrameController