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
import GUI.MenuViewForSeller;
import GUI.SellerHomePageView;
import User.User;


public class MenuForSellerController {
    private  LoginView loginView;
    private BeforeLoginView beforeLoginView;
    private MenuViewForSeller menuView;
    private MainFrameView mainFrameView;
    private User user;
    public MenuForSellerController(MainFrameView mainFrameView,MenuViewForSeller menuView, User user) {
    	this.mainFrameView=mainFrameView;
        this.menuView = menuView;
        this.user = user;
        menuView.addHomePageActionListener(new HomePageActionListener());
        menuView.addMyProductsActionListener(new MyProductsActionListener());
        menuView.addSendFeedbackActionListener(new SendFeedbackActionListener());
        menuView.addLogOutActionListener(new LogOutActionListener());
        menuView.addAboutActionListener(new AboutActionListener());

        
    }
    private class HomePageActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	SellerHomePageView homePageView = new SellerHomePageView(mainFrameView,menuView);
    		//mainFrameView.addMenuPanel(homePageView);
    		SellerHomePageController homePageController = new SellerHomePageController(mainFrameView,homePageView);

        }
    } 

    private class AboutActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	AboutAppView homePageView = new AboutAppView(mainFrameView,menuView);
        	AboutAppController AboutAppController = new AboutAppController(mainFrameView,homePageView);
        }
    } 
   
    private class MyProductsActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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