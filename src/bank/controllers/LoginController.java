package bank.controllers;

import bank.boundary.DataAccessor;
import bank.boundary.LoginForm;
import bank.entities.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginController {

    private LoginForm mLoginForm;
    private DataAccessor mDataAccessor;

    public LoginController(LoginForm mLoginForm) {
        this.mLoginForm = mLoginForm;
        mDataAccessor = new DataAccessor();
    }

    public User doLogin() {
        String login = mLoginForm.getLogin().getText();
        String password = mLoginForm.getPassword().getText();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("logins.txt"));
            StringBuilder buffer = new StringBuilder("");
            while(!buffer.append(reader.readLine()).toString().equals("null")){
                String[] temp = buffer.toString().split(":");
                if(temp[0].equals(login) && temp[1].equals(password)){
                    return new User(login, password, temp[2]);
                }
                buffer.delete(0, buffer.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}//end LoginController