package bank.controllers;

import bank.boundary.ReferentFrame;
import bank.entities.*;
import bank.boundary.DataAccessor;

import javax.swing.*;

public class ReferentFrameController {

	public DataAccessor mDataAccessor;
	public ReferentFrame mReferentFrame;

	public ReferentFrameController(){

	}

	public void save(){

	}

	public JPanel getPanelScrollPaneForCallRequest(JPanel panel){
		panel.removeAll();
		for (final RequestWithReport request : DataAccessor.getRequestsForReferent()) {
			final JButton button = new JButton(request.getRequest().toString());
			button.addActionListener(new ButtonCallRequestListener(request));
			panel.add(button);
		}
		return panel;
	}

    public JPanel getPanelScrollPaneForAnalyseAndAccept(JPanel panel) {
        panel.removeAll();
        for (final RequestWithReport request : DataAccessor.getRequestsForReferent()) {
            final JButton button = new JButton(request.getRequest().toString());
            button.addActionListener(new ButtonAnalyseAndAcceptListener(request));
            panel.add(button);
        }
        return panel;
    }

    public JPanel getPanelScrollPaneForCheckFinances(JPanel panel) {
        panel.removeAll();
        for (final RequestWithReport request : DataAccessor.getRequestsForReferent()) {
            final JButton button = new JButton(request.getRequest().toString());
            panel.add(button);
        }
        return panel;
    }

    public void selectLoanRequest(){

	}
}//end ReferentFrameController