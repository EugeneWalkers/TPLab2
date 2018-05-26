package bank.entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCallRequestListener implements ActionListener {

    private JButton button;
    private GetRequest r;

    private class Reporter extends JFrame {
        Reporter() {
            super("Report for " + button.getText().split(":")[1]);
            int id = Integer.parseInt(button.getText().split(":")[0]);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(250, 150);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(0, 2, 10, 10));

            JButton ok = new JButton("Save");
            add(ok);
            ok.addActionListener(e1 -> {

                this.dispose();
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Reporter().setVisible(true);
    }

    public ButtonCallRequestListener(JButton button, GetRequest r) {
        this.button = button;
        this.r = r;
    }

}
