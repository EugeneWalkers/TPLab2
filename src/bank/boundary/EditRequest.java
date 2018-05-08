package bank.boundary;

import bank.controllers.EditRequestController;
import bank.entities.User;

import javax.swing.*;

public class EditRequest extends JFrame {

	public EditRequestController mEditRequestController;


	public EditRequest(User user){
		super(user.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void showRequestsForReview(){

	}

	public void saveRequest(){

	}

	public void selectRequest(){

	}

	public void showRequest(){

	}
}//end EditRequest