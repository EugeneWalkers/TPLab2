package bank.boundary;

import bank.entities.User;

import javax.swing.*;

public class InspectorFrame extends JFrame {

    InspectorFrame(User user){
        super(user.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
