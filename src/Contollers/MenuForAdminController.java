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
import GUI.MenuViewForAdmin;
import GUI.MenuViewForBuyer;
import GUI.MenuViewForSeller;
import GUI.SellerHomePageView;
import User.User;


public class MenuForAdminController {
    private  LoginView loginView;
    private BeforeLoginView beforeLoginView;
    private MenuViewForAdmin menuView;
    private MainFrameView mainFrameView;
    private User user;
    public MenuForAdminController(MainFrameView mainFrameView,MenuViewForAdmin menuView, User user) {
    	this.mainFrameView=mainFrameView;
        this.menuView = menuView;
        this.user = user;
        menuView.addAddCategoryActionListener(new AddCategoryActionListener());
        menuView.addViewFeedbackActionListener(new ViewFeedbackActionListener());
        menuView.addViewAllProductsActionListener(new ViewAllProductsActionListener());
        menuView.addLogOutActionListener(new LogOutActionListener());
        menuView.addViewAllCategoryActionListener(new ViewAllCategoryActionListener());
        menuView.addHomePageActionListener(new HomePageActionListener());
        menuView.addViewAllUsersActionListener(new ViewAllUsersActionListener());
        menuView.addViewAllSelersActionListener(new ViewAllSelersActionListener());
        menuView.addViewAllBuyersActionListener(new ViewAllBuyersActionListener());

        
    }
    
    private class AddCategoryActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    } 
    
    private class ViewFeedbackActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    } 
    private class ViewAllProductsActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    } 
    private class ViewAllCategoryActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    } 
    private class HomePageActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    } 
    private class ViewAllUsersActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    } 
    private class ViewAllSelersActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }    
    private class ViewAllBuyersActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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