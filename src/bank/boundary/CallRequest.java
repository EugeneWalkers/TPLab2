package bank.boundary;

import bank.controllers.CallRequestController;
import bank.entities.User;

import javax.swing.*;

public class CallRequest extends JFrame {

	public CallRequestController mCallRequestController;

	public CallRequest(User user){
		super(user.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void getAnswerFromCreditDepartment(){

	}

	public void getListOfCurrentRequests(){

	}

	public void save(){

	}

	public void selectRequest(){

	}

	public void sendAnswer(){

	}

	public void sendToCreditDepartment(){

	}

	public void showListOfRequest(){

	}

	public void updateRequest(){

	}
}//end CallRequest