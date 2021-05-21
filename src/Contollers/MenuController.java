package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

import GUI.BeforeLoginView;
import GUI.FeedbackView;
import GUI.HomePageView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.MenuView;
import User.User;


public class MenuController {
    private  LoginView loginView;
    private BeforeLoginView beforeLoginView;
    private MenuView menuView;
    private MainFrameView mainFrameView;
    private User user;
    public MenuController(MainFrameView mainFrameView,MenuView menuView, User user) {
    	this.mainFrameView=mainFrameView;
        this.menuView = menuView;
        this.user = user;
        menuView.addMyProfileButton(new MyProfileButtonActionListener());
        menuView.addHomeButton(new HomeButtonActionListener());
        menuView.addStoreButton(new StoreButtonActionListener());
        menuView.addShoppingCartButton(new ShoppingCartButtonActionListener());
        menuView.addHomePageButton(new HomePageButtonActionListener());
        menuView.addMyFavoritesButton(new MyFavoritesButtonActionListener());
        menuView.addHelpContentsButton(new HelpContentsButtonActionListener());
        menuView.addHelpButton(new HelpButtonActionListener());
        menuView.addSendFeedbackButton(new SendFeedbackButtonActionListener());
        menuView.addLogOutButton(new LogOutButtonActionListener());

        
    }
    
    private class MyProfileButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    } 
    
    private class HomeButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	HomePageView homePageView = new HomePageView(mainFrameView,menuView);
    		//mainFrameView.addMenuPanel(homePageView);
    		HomePageController homePageController = new HomePageController(mainFrameView,homePageView);

        }
    } 
    private class StoreButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }    
    
    private class ShoppingCartButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    } 
    private class HomePageButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	HomePageView homePageView = new HomePageView(mainFrameView,menuView);
    		//mainFrameView.addMenuPanel(homePageView);
    		HomePageController homePageController = new HomePageController(mainFrameView,homePageView);

    		/*
        	LoginView loginView =  new LoginView(mainFrameView);
    		mainFrameView.addNewPanel(loginView);	
    		LoginController loginController = new LoginController(mainFrameView,loginView);
    		System.out.println("login");
    		 * */
        }
    }     
   
    private class MyFavoritesButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }    
    private class HelpContentsButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }  
    
    private class HelpButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    private class SendFeedbackButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
    		FeedbackView feedbackView = new FeedbackView(mainFrameView);
    		//mainFrameView.addMenuPanel(feedbackView);
    		FeedbackController feedbackController = new FeedbackController(mainFrameView,feedbackView);

        }
    }
/*    	public void actionPerformed(ActionEvent e) {
    		HomePageView homePageView = new HomePageView(mainFrameView);
    		mainFrameView.addMenuPanel(homePageView);*/
    private class LogOutButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(mainFrameView,"Sure? You want to exit?", "Swing Tester",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                 if(result == JOptionPane.YES_OPTION){
                    //mainFrame.setTitle("You selected: Yes");
              	   beforeLoginView =  new BeforeLoginView(mainFrameView);
              	  // mainFrameView.addNewPanel(beforeLoginView);
              	 BeforeLoginController beforeLoginController = new BeforeLoginController(mainFrameView,beforeLoginView);

                 }else if (result == JOptionPane.NO_OPTION){
              	   //mainFrame.setTitle("Outfit Rating Platform");
                 }else {
              	   //mainFrame.setTitle("None selected");
                 }
        	
        }
    }
}
