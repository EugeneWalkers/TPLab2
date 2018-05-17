package bank.boundary;

import bank.Main;
import bank.controllers.EditRequestController;
import bank.entities.GetRequest;
import bank.entities.RequestList;
import bank.entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditRequest extends JFrame {

    public EditRequestController mEditRequestController;
    private DataAccessor dataAccessor;
    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(panel);

    EditRequest(User user) {
        super(user.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        dataAccessor = new DataAccessor();
        setButtons();
    }

    private void setButtons() {
        JButton newRequest = new JButton("Create new Request");
        JButton editRequest = new JButton("Edit Request");
        JButton exit = new JButton("Exit");
        scrollPane = getScrollPane();
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
            panel = new JPanel();
            JScrollPane pane = new JScrollPane(panel);
            pane.setMinimumSize(new Dimension(100, 100));
            panel.setLayout(new GridLayout(0, 1, 5, 5));
            RequestList requests = dataAccessor.getRequestsForReview();
            ArrayList<GetRequest> rs = requests.getmGetRequest();
            for (GetRequest r : rs) {
                JButton button = new JButton(r.toString());
                button.addActionListener(new ActionListener() {
                    class Editor extends JFrame {
                        Editor() {
                            super(button.getText().split(":")[1]);
                            int id = Integer.parseInt(button.getText().split(":")[0]);
                            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            setSize(250, 150);
                            setLocationRelativeTo(null);
                            setLayout(new GridLayout(0, 2, 10, 10));
                            GetRequest request = dataAccessor.getRequest(id);
                            JLabel idConst = new JLabel("Id:");
                            JLabel clientConst = new JLabel("Client:");
                            JLabel idChanged = new JLabel(String.valueOf(id));
                            JLabel clientChanged = new JLabel(request.getClientName());
                            JLabel valueConst = new JLabel("Value:");
                            JTextField valueChanged = new JTextField();
                            valueChanged.setText(String.valueOf(request.getValue()));
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
                                //TODO: change db
                                this.dispose();
                            });
                        }
                    }

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Editor().setVisible(true);
                    }
                });
                panel.add(button);
            }
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