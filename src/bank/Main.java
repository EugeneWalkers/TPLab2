package bank;

import bank.boundary.*;

public class Main {

    public static LoginForm loginer;
    public static CallRequest caller;
    public static ClientFrame client;
    public static EditRequest editer;
    public static InspectorFrame inspector;

    public static void main(String[] args) {
        loginer = new LoginForm();
        loginer.setVisible(true);
    }
}