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
        JButton getInformationAboutFinances = new JButton("Get Finances Info");
        JButton callRequest = new JButton("Call Request");
        JButton acceptCopyOfTheRequest = new JButton("Accept Copy of the Request");
        JButton issueReport = new JButton("Issue Report");
        JButton exit = new JButton("Exit");
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 7, 7));
        JScrollPane requests = getScrollPane();

        acceptCopyOfTheRequest.addActionListener(e -> {
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
        add(getInformationAboutFinances, c);
        c.gridy = 1;
        add(callRequest, c);
        c.gridy = 2;
        add(acceptCopyOfTheRequest, c);
        c.gridy = 3;
        add(requests, c);
        c.gridy = 4;
        add(issueReport, c);
        c.gridy = 5;
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