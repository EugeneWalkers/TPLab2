package bank.controllers;

import bank.boundary.DataAccessor;
import bank.boundary.LoginForm;
import bank.entities.User;

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
        User user = new User(login, password);
        if (mDataAccessor.userExists(user)){
            return user;
        }
        else{
            return null;
        }
    }
}//end LoginController