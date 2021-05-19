package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.AncestorListener;

import GUI.BeforeLoginView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.MenuView;
import User.User;


public class MenuController {
    private LoginView loginView;
    private BeforeLoginView beforeLoginView;
    private MenuView menuView;
    private MainFrameView mainFrameView;
    private User user;
    public MenuController(MenuView menuView, User user) {
        this.menuView = menuView;
        this.user = user;
        menuView.addMyProfileButton(new MyProfileButtonActionListener());
        menuView.addHomeButton(new HomeButtonActionListener());
        menuView.addStoreButton(new StoreButtonActionListener());
        menuView.addShoppingCartButton(new ShoppingCartButtonActionListener());
        menuView.addHomePageButton(new HomePageButtonActionListener());
        menuView.addMenuBarButton(new MenuBarButtonActionListener());
        menuView.addMyFavoritesButton(new MyFavoritesButtonActionListener());
        menuView.addHelpContentsButton(new HelpContentsButtonActionListener());
        menuView.addHelpButton(new HelpButtonActionListener());
        menuView.addSendFeedbackButton(new SendFeedbackButtonActionListener());

        
    }
    
    private class MyProfileButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    } 
    
    private class HomeButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
        }
    }     
    private class MenuBarButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
        }
    }

    
}
