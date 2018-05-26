package bank.boundary;

import bank.controllers.EmployeeFrameController;
import bank.entities.User;

import javax.swing.*;

public class EmployeeFrame extends JFrame {

	public EmployeeFrameController mEmployeeFrameController;

	public EmployeeFrame(User user){
		super(user.getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}//end EmployeeFrame