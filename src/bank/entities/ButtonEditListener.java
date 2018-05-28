package bank.entities;

import bank.boundary.DataAccessor;
import bank.entities.GetRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEditListener implements ActionListener {

    private GetRequest r;
    private JButton button;

    private class Editor extends JFrame {
        Editor() {
            super(button.getText().split(":")[1]);
            int id = Integer.parseInt(button.getText().split(":")[0]);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(250, 150);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(0, 2, 10, 10));
            JLabel idConst = new JLabel("Id:");
            JLabel clientConst = new JLabel("Client:");
            JLabel idChanged = new JLabel(String.valueOf(id));
            JLabel clientChanged = new JLabel(r.getClientName());
            JLabel valueConst = new JLabel("Value:");
            JTextField valueChanged = new JTextField();
            valueChanged.setText(String.valueOf(r.getValue()));
            add(idConst);
            add(idChanged);
            add(clientConst);
            add(clientChanged);
            add(valueConst);
            add(valueChanged);
            add(new JLabel());
            JButton ok = new JButton("Save");
            add(ok);
            ok.addActionListener(e1 -> {
                DataAccessor.setRequest(
                        r.getClientName(),
                        Integer.parseInt(valueChanged.getText()));
                button.setText(r.getId()
                        + ":"
                        + r.getClientName()
                        + ":"
                        + valueChanged.getText());
                this.dispose();
            });
        }
    }

    public ButtonEditListener(JButton button, GetRequest r){
        this.button = button;
        this.r = r;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Editor().setVisible(true);
    }
}
