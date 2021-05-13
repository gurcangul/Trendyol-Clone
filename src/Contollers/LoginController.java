package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.LoginPanel;
import User.User;



public class LoginController {
	private final LoginPanel loginPanel;

    public LoginController(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
        loginPanel.addLoginActionListener(new LoginActionListener());
    }

    public void login(String userName, String password) {
        User user = userModel.checkUserIsExist(userName, password);
        if (user != null) {
            this.loginPanel.close();
            this.loggedIn.setVisible();
            this.loggedIn.addOkButtonListener(new LoggedInOkButtonListener());
            this.loggedIn.addCancelButtonListener(new LoggedInCancelButtonListener());
            this.userModel.setLoggedInUser(user);
        } else {
            this.showLoginPanel();
        }
    }

    public void showLoginPanel() {
        loginPanel.setVisible();
        loginPanel.addLoginButtonListener(new LoginButtonListener());
    }
}
