package Contollers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import GUI.BeforeLoginView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.MenuPanel;
import Models.UserModel;
import User.Admin;
import User.Buyer;
import User.User;


public class LoginController {
    private UserModel userModel;
    private LoginView loginView;
    private BeforeLoginView beforeLoginView;
    private MenuPanel menuPanel;
    private MainFrameView mainFrameView;


    public LoginController(LoginView loginView, BeforeLoginView beforeLoginView, UserModel userModel,MainFrameView mainFrameView) {
        this.loginView = loginView;
        this.mainFrameView=mainFrameView;
        this.userModel=userModel;
        //mainView.addProfileButtonListener(new MainProfileButtonListener());
    }

    public void login(String userName, String password) {
    	User user =  userModel.checkUserIsExist(userName, password);
        if (user != null) {
            this.menuPanel=new MenuPanel(mainFrameView);
            System.out.println("selam...."+userName+ password);
            //this.menuPanel.addOkButtonListener(new LoggedInOkButtonListener());
            menuPanel =  new MenuPanel(mainFrameView);
    		mainFrameView.addNewPanel(menuPanel);
            //this.menuPanel.addCancelButtonListener(new LoggedInCancelButtonListener());
    		menuPanel.setUserName(user.getUserName());
    		System.out.println("helloo"+user.getUserName());
            this.userModel.setLoggedInUser(user);//*****
        } else {
            //loginPanel.passwordCheck();
    		//JLabel lblNewLabel2 = new JLabel("Wrong! Please try again!");
    		loginView.getPassword().setBackground(Color.RED);
    		loginView.getUserName().setBackground(Color.RED);
    		JOptionPane.showMessageDialog(null, "Wrong! Please try again! ");        		
            this.showLoginPanel();

            
        }
    }

 
    public void showLoginPanel() {
		loginView.getPassword().setBackground(Color.white);
		loginView.getUserName().setBackground(Color.white);
        loginView.setVisible();
        loginView.addLoginActionListener(new LoginButtonListener());
    }
    
    class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginView.getUserName().getText();
            String password = loginView.getPassword().getText();
            login(username, password);
        }
    }
    class LoggedInOkButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	menuPanel =  new MenuPanel(mainFrameView);
    		mainFrameView.addNewPanel(menuPanel);
        }
    }
    
}
