package bank.boundary;

import bank.controllers.AcceptCopyOfTheRequestController;
import bank.entities.User;

import javax.swing.*;

public class AcceptCopyOfTheRequest extends JFrame {

	public AcceptCopyOfTheRequestController mAcceptCopyOfTheRequestController;

	public AcceptCopyOfTheRequest(User user){
		super(user.getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void EstimateRequest(){

	}

	public void setDocumentsOfCurrentRequest(){

	}

	public void save(){

	}

	public void showRequest(){

	}

	public void showRequestList(){

	}

	public void estimateRequest(){

	}

	public void getDocumentsOfCurrentRequest(){

	}
}//end AcceptCopyOfTheRequest