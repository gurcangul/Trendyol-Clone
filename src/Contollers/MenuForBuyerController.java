package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

import GUI.AboutAppView;
import GUI.BeforeLoginView;
import GUI.FeedbackView;
import GUI.BuyerHomePageView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.MenuViewForBuyer;
import GUI.MyProfileView;
import User.User;


public class MenuForBuyerController {
    private  LoginView loginView;
    private BeforeLoginView beforeLoginView;
    private MenuViewForBuyer menuView;
    private MainFrameView mainFrameView;
    private User user;
    public MenuForBuyerController(MainFrameView mainFrameView,MenuViewForBuyer menuView, User user) {
    	this.mainFrameView=mainFrameView;
        this.menuView = menuView;
        this.user = user;
        menuView.addSendFeedbackActionListener(new SendFeedbackActionListener());
        menuView.addAboutActionListener(new AboutActionListener());
        menuView.addLogOutActionListener(new LogOutActionListener());
        menuView.addShoppingCartActionListener(new ShoppingCartActionListener());
        menuView.addHomePageActionListener(new HomePageActionListener()); 
        menuView.addMyFavoritesActionListener(new MyFavoritesActionListener());

    }
    
    private class HomePageActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	BuyerHomePageView homePageView = new BuyerHomePageView(mainFrameView,menuView);
    		BuyerHomePageController homePageController = new BuyerHomePageController(mainFrameView,homePageView);

        }
    }  
    
    private class AboutActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	AboutAppView homePageView = new AboutAppView(mainFrameView,menuView);
        	AboutAppController AboutAppController = new AboutAppController(mainFrameView,homePageView);
        }
    }
    
    private class MyFavoritesActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	MyProfileView myProfileView = new MyProfileView(mainFrameView,menuView);
        	MyProfileController myProfileController = new MyProfileController(mainFrameView, myProfileView);
        	myProfileView.viewMyFavories(); 
        	
        }
    }    
    
    private class ShoppingCartActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	MyProfileView myProfileView = new MyProfileView(mainFrameView,menuView);
        	MyProfileController myProfileController = new MyProfileController(mainFrameView, myProfileView);
        	myProfileView.viewMyFavories(); 
        }
    } 
   
    private class SendFeedbackActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
    		FeedbackView feedbackView = new FeedbackView(mainFrameView,menuView);
    		FeedbackController feedbackController = new FeedbackController(mainFrameView,feedbackView);
        }
    }

    private class LogOutActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(mainFrameView,"Sure? You want to exit?", "Swing Tester", 
            		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        	if(result == JOptionPane.YES_OPTION){
          	   	beforeLoginView =  new BeforeLoginView(mainFrameView);
          	   	BeforeLoginController beforeLoginController = new BeforeLoginController(mainFrameView,beforeLoginView);
        	}     	
        }
    }
}