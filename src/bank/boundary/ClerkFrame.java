package bank.boundary;

import bank.Main;
import bank.controllers.ClerkFrameController;
import bank.entities.User;

import javax.swing.*;
import java.awt.*;

public class ClerkFrame extends JFrame {

    private ClerkFrameController mClerkFrameController;
    private JPanel panelEdit, panelCreate;


    ClerkFrame(User user) {
        super(user.getName());
        setWindow();
        mClerkFrameController = new ClerkFrameController();
    }

    private void setWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        panelEdit = new JPanel();
        panelEdit.setLayout(new GridLayout(0, 1, 7, 7));
        panelCreate = new JPanel();
        panelCreate.setLayout(new GridLayout(0, 1, 7, 7));
        JScrollPane scrollPaneForEdit = getScrollPane(panelEdit);
        JScrollPane scrollPaneForCreate = getScrollPane(panelCreate);

        JButton newRequest = new JButton("Create Credit Request");
        JButton editRequest = new JButton("Edit Request");
        JButton exit = new JButton("Exit");

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        add(newRequest, c);
        c.gridy = 1;
        add(scrollPaneForCreate, c);
        c.gridy = 2;
        add(editRequest, c);
        c.gridy = 3;
        c.fill = GridBagConstraints.BOTH;
        add(scrollPaneForEdit, c);
        c.gridy = 4;
        add(exit, c);

        newRequest.addActionListener(e -> {
            panelCreate = mClerkFrameController.getPanelScrollPaneForCreate(panelCreate);
            revalidate();
        });

        editRequest.addActionListener(e -> {
            panelEdit = mClerkFrameController.getPanelScrollPaneForEdit(panelEdit);
            revalidate();
        });


        exit.addActionListener(e -> {
            Main.loginer.setVisible(true);
            setVisible(false);
        });


    }

    private JScrollPane getScrollPane(JPanel panel) {
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
}//end ClerkFrame