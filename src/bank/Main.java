package bank;

import bank.boundary.*;

public class Main {

    public static LoginForm loginer;
    public static ReferentFrame caller;
    public static ClientFrame client;
    public static ClerkFrame editer;
    public static InspectorFrame inspector;

    public static void main(String[] args) {
        loginer = new LoginForm();
        loginer.setVisible(true);
    }
}