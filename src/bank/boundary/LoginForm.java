package bank.boundary;

import bank.controllers.LoginController;
import bank.entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    public static CallRequest caller;
    public static EditRequest editor;
    public static AcceptCopyOfTheRequest accepter;
    public static ClientFrame client;
    public static InspectorFrame inspector;

	public JTextField getLogin() {
		return login;
	}

	public JTextField getPassword() {
		return password;
	}

	private JTextField login, password;
	private JButton send;
	private JPanel inputs, sends;

	private LoginController mLoginController;

	public LoginForm(){
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 130);
		setLocationRelativeTo(null);
		mLoginController = new LoginController(this);
		login = new JTextField();
		password = new JTextField();
		send = new JButton("Send");
		inputs = new JPanel();
		sends = new JPanel();
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		this.setLayout(new BorderLayout());
		inputs.setLayout(new GridLayout(2, 2, 5, 5));
		inputs.add(new JLabel("Login:"));
		inputs.add(login);
		inputs.add(new JLabel("Password:"));
		inputs.add(password);
		sends = new JPanel();
		sends.add(send);
		add(inputs, BorderLayout.PAGE_START);
		add(sends, BorderLayout.PAGE_END);
	}

	public void doLogin(){
		User user = mLoginController.doLogin();
		if (user != null){
            switch(user.getType()){
                case "client":
                    client = new ClientFrame(user);
                    client.setVisible(true);
                    this.setVisible(false);
                    break;

                case "clerk":
                    editor = new EditRequest(user);
                    editor.setVisible(true);
					this.setVisible(false);
                    break;

                case "referent":
                    caller = new CallRequest(user);
                    caller.setVisible(true);
					this.setVisible(false);
                    break;

                case "employee":
                    accepter = new AcceptCopyOfTheRequest(user);
                    accepter.setVisible(true);
					this.setVisible(false);
                    break;

                case "inspector":
                    inspector = new InspectorFrame(user);
                    inspector.setVisible(true);
					this.setVisible(false);
                    break;

                default:

                    break;
            }
        }
	}
}//end LoginForm