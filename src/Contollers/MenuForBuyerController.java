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
        menuView.addMyProfileButton(new MyProfileButtonActionListener());
        menuView.addHomeButton(new HomeButtonActionListener());
        menuView.addStoreButton(new StoreButtonActionListener());
        menuView.addShoppingCartButton(new ShoppingCartButtonActionListener());
        menuView.addHomePageButton(new HomePageButtonActionListener());
        menuView.addMyFavoritesButton(new MyFavoritesButtonActionListener());
        menuView.addHelpButton(new HelpButtonActionListener());
        menuView.addSendFeedbackButton(new SendFeedbackButtonActionListener());
        menuView.addLogOutButton(new LogOutButtonActionListener());
        menuView.addAboutButton(new AboutButtonActionListener());
        
    }
    
    private class MyProfileButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    } 
    private class AboutButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	AboutAppView homePageView = new AboutAppView(mainFrameView,menuView);
        	AboutAppController AboutAppController = new AboutAppController(mainFrameView,homePageView);

        }
    }
    private class HomeButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	BuyerHomePageView homePageView = new BuyerHomePageView(mainFrameView,menuView);
    		BuyerHomePageController homePageController = new BuyerHomePageController(mainFrameView,homePageView);

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
        	BuyerHomePageView homePageView = new BuyerHomePageView(mainFrameView,menuView);
    		BuyerHomePageController homePageController = new BuyerHomePageController(mainFrameView,homePageView);
        }
    }     
   
    private class MyFavoritesButtonActionListener implements ActionListener {
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
    		FeedbackView feedbackView = new FeedbackView(mainFrameView,menuView);
    		FeedbackController feedbackController = new FeedbackController(mainFrameView,feedbackView);

        }
    }

    private class LogOutButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(mainFrameView,"Sure? You want to exit?", "Swing Tester",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
            	beforeLoginView =  new BeforeLoginView(mainFrameView);
              	BeforeLoginController beforeLoginController = new BeforeLoginController(mainFrameView,beforeLoginView);

                 }else if (result == JOptionPane.NO_OPTION){
              	   //mainFrame.setTitle("Outfit Rating Platform");
                 }else {
              	   //mainFrame.setTitle("None selected");
                 }
        	
        }
    }
}
