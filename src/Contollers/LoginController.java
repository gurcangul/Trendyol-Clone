package Contollers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import FileIO.DataHandler;
import GUI.BeforeLoginView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.MenuView;
import User.Admin;
import User.Buyer;
import User.User;


public class LoginController {
    private LoginView loginView;
    private BeforeLoginView beforeLoginView;
    private MenuView menuView;
    private MainFrameView mainFrameView;


    public LoginController(MainFrameView mainFrameView,LoginView loginView) {
        this.loginView = loginView;
        this.mainFrameView=mainFrameView;
        loginView.addLoginActionListener(new LoginButtonListener());
    }

    public void login(String userName, String password) {
        DataHandler dataHandler = new DataHandler();
    	User user =  dataHandler.checkUserIsExist(userName, password);
        if (user != null) {
            this.menuView=new MenuView(mainFrameView);
            System.out.println("giriş yapıldı...."+userName+ password);
            //this.menuPanel.addOkButtonListener(new LoggedInOkButtonListener());
           // MenuController menuController = new MenuController(menuView, user);
          
            menuView =  new MenuView(mainFrameView);
    		mainFrameView.addNewPanel(menuView);
            //this.menuPanel.addCancelButtonListener(new LoggedInCancelButtonListener());
    		menuView.setUserName(user.getUserName());
    		System.out.println("helloo"+user.getUserName());
           // this.userModel.setLoggedInUser(user);//*****
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
        	menuView =  new MenuView(mainFrameView);
    		mainFrameView.addNewPanel(menuView);
        }
    }
    
}
