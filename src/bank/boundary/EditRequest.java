package bank.boundary;

import bank.Main;
import bank.controllers.EditRequestController;
import bank.entities.User;

import javax.swing.*;
import java.awt.*;

public class EditRequest extends JFrame {

    private EditRequestController mEditRequestController;
    private JPanel panel;
    private JScrollPane scrollPane;

    EditRequest(User user) {
        super(user.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        panel = new JPanel();
        scrollPane = getScrollPane();
        setButtons();
        mEditRequestController = new EditRequestController();
    }

    private void setButtons() {
        JButton newRequest = new JButton("Create new Request");
        JButton editRequest = new JButton("Edit Request");
        JButton exit = new JButton("Exit");

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        add(newRequest, c);
        c.gridy = 1;
        add(editRequest, c);
        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        add(scrollPane, c);
        c.gridy = 3;
        add(exit, c);

        newRequest.addActionListener(e -> {

        });

        editRequest.addActionListener(e -> {
            panel = mEditRequestController.getPanelScrollPane(panel);
            revalidate();
        });


        exit.addActionListener(e -> {
            Main.loginer.setVisible(true);
            setVisible(false);
        });


    }

    private JScrollPane getScrollPane() {
        JScrollPane pane = new JScrollPane(panel);
        pane.setMinimumSize(new Dimension(100, 100));
        panel.setLayout(new GridLayout(0, 1, 5, 5));
        return pane;
    }

    public void showRequestsForReview() {

    }

    public void saveRequest() {

    }

    public void selectRequest() {

    }

    public void showRequest() {

    }
}//end EditRequest