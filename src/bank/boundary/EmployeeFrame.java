package bank.boundary;

import bank.Main;
import bank.controllers.EmployeeFrameController;
import bank.entities.User;

import javax.swing.*;
import java.awt.*;

public class EmployeeFrame extends JFrame {

	private EmployeeFrameController mEmployeeFrameController;
    private JPanel panel;

    public EmployeeFrame(User user) {
        super(user.getName());
        mEmployeeFrameController = new EmployeeFrameController();
        setWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setWindow() {
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        JButton callRequest = new JButton("Call Request");
        JButton exit = new JButton("Exit");
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 7, 7));
        JScrollPane requests = getScrollPane();

        callRequest.addActionListener(e -> {
            panel = mEmployeeFrameController.getPanelScrollPane(panel);
            revalidate();
        });

        exit.addActionListener(e -> {
            Main.loginer.setVisible(true);
            setVisible(false);
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        add(callRequest, c);
        c.gridy = 1;
        add(requests, c);
        c.gridy = 4;
        add(exit, c);
    }

    private JScrollPane getScrollPane() {
        JScrollPane pane = new JScrollPane(panel);
        pane.setMinimumSize(new Dimension(100, 100));
        panel.setLayout(new GridLayout(0, 1, 5, 5));
        return pane;
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