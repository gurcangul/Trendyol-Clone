package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import GUI.BeforeLoginPanel;
import GUI.LoginPanel;
import GUI.MainFrame;
import GUI.MenuPanel;
import Models.UserModel;
import User.Admin;
import User.Buyer;
import User.User;


public class LoginController {
    private UserModel userModel;
    private LoginPanel loginPanel;
    private BeforeLoginPanel beforeLoginPanel;
    private MenuPanel menuPanel;
    private MainFrame mainFrame;


    public LoginController(LoginPanel loginPanel, BeforeLoginPanel beforeLoginPanel, UserModel userModel,MainFrame mainFrame) {
        this.loginPanel = loginPanel;
        this.mainFrame=mainFrame;
        this.userModel=userModel;
        //mainView.addProfileButtonListener(new MainProfileButtonListener());
    }

    public void login(String userName, String password) {
    	User user =  userModel.checkUserIsExist(userName, password);
        if (user != null) {
            this.menuPanel=new MenuPanel(mainFrame);
            System.out.println("selam...."+userName+ password);
            this.menuPanel.addOkButtonListener(new LoggedInOkButtonListener());
            menuPanel =  new MenuPanel(mainFrame);
    		mainFrame.addNewPanel(menuPanel);
            //this.menuPanel.addCancelButtonListener(new LoggedInCancelButtonListener());
            this.userModel.setLoggedInUser(user);
        } else {
            this.showLoginPanel();
        }
    }

 
    public void showLoginPanel() {
        loginPanel.setVisible();
        loginPanel.addLoginActionListener(new LoginButtonListener());
    }
    
    class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginPanel.getUserName().getText();
            String password = loginPanel.getPassword().getText();
            login(username, password);
            /*menuPanel =  new MenuPanel(mainFrame);
    		mainFrame.addNewPanel(menuPanel);*/
        }
    }
    class LoggedInOkButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	menuPanel =  new MenuPanel(mainFrame);
    		mainFrame.addNewPanel(menuPanel);
        }
        /*
        /*Login.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });*/
    }
    
}
