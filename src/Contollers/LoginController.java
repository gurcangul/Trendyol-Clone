package Contollers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import FileIO.DataHandler;
import GUI.BeforeLoginView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.MenuViewForAdmin;
import GUI.MenuViewForBuyer;
import GUI.MenuViewForSeller;
import User.Admin;
import User.Buyer;
import User.User;


public class LoginController {
    private LoginView loginView;
    private BeforeLoginView beforeLoginView;
    private MainFrameView mainFrameView;

    MenuViewForSeller menuViewForSeller;
    MenuViewForBuyer menuViewForBuyer;
    MenuViewForAdmin menuViewForAdmin;
    private User user;

    public LoginController(MainFrameView mainFrameView,LoginView loginView) {
        this.loginView = loginView;
        this.mainFrameView=mainFrameView;
        loginView.addLoginActionListener(new LoginButtonListener());
        loginView.addBackActionListener(new backButtonListener());        
    }

    public void login(String userName, String password) {
        DataHandler dataHandler = new DataHandler();
    	user =  dataHandler.checkUserIsExist(userName, password);
    	
        if (user != null) {
        	if(user.getUserType().equalsIgnoreCase("Seller")) {
        		this.menuViewForSeller=new MenuViewForSeller(mainFrameView,user);          
            	MenuForSellerController menuController = new MenuForSellerController(mainFrameView,menuViewForSeller, user);
            	menuViewForSeller.setUserName(user.getUserName());
        		System.out.println("helloo"+user.getUserName());
        	}
        	else if(user.getUserType().equalsIgnoreCase("Buyer")) {
        		this.menuViewForBuyer=new MenuViewForBuyer(mainFrameView,user);          
            	MenuForBuyerController menuController = new MenuForBuyerController(mainFrameView,menuViewForBuyer, user);
            	menuViewForBuyer.setUserName(user.getUserName());
        		System.out.println("helloo"+user.getUserName());
        	}
        	else if(user.getUserType().equalsIgnoreCase("Admin")) {
        		this.menuViewForAdmin=new MenuViewForAdmin(mainFrameView,user);          
            	MenuForAdminController menuController = new MenuForAdminController(mainFrameView,menuViewForAdmin, user);
            	menuViewForAdmin.setUserName(user.getUserName());
        		System.out.println("helloo"+user.getUserName());		
        	}
    		
        } 
        else {
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
    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            	beforeLoginView =  new BeforeLoginView(mainFrameView);
            	BeforeLoginController beforeLoginController = new BeforeLoginController(mainFrameView,beforeLoginView);

        }
    }
    class LoggedInOkButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if(user.getUserType().equalsIgnoreCase("Seller")) {
        		menuViewForSeller=new MenuViewForSeller(mainFrameView,user);          
            	MenuForSellerController menuController = new MenuForSellerController(mainFrameView,menuViewForSeller, user);
        	}
        	else if(user.getUserType().equalsIgnoreCase("Buyer")) {
        		menuViewForBuyer=new MenuViewForBuyer(mainFrameView,user);          
            	MenuForBuyerController menuController = new MenuForBuyerController(mainFrameView,menuViewForBuyer, user);
        	}
        	else if(user.getUserType().equalsIgnoreCase("Admin")) {
        		menuViewForAdmin=new MenuViewForAdmin(mainFrameView,user);          
            	MenuForAdminController menuController = new MenuForAdminController(mainFrameView,menuViewForAdmin, user);
        	}  		
        }
    }   
}
