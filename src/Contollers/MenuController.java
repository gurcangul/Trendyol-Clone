package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.AncestorListener;

import GUI.BeforeLoginView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.MenuView;
import User.User;
import tube.BrowseUsersController;
import tube.BrowseUsersView;
import tube.DataHandler;
import tube.IDataHandler;

public class MenuController {
    private LoginView loginView;
    private BeforeLoginView beforeLoginView;
    private MenuView menuView;
    private MainFrameView mainFrameView;
    private User user;
    public MenuController(MenuView menuView, User user) {
        this.menuView = menuView;
        this.user = user;
        menuView.addMyProfileButton(new BrowseUsersActionListener());
        menuView.addHomeButton(new BrowseUsersActionListener());
        menuView.addStoreButton(new BrowseUsersActionListener());
        menuView.addShoppingCartButton(new BrowseUsersActionListener());
        menuView.addHomePageButton(new BrowseUsersActionListener());
        menuView.addMenuBarButton(new BrowseUsersActionListener());
        menuView.addMyFavoritesButton(new BrowseUsersActionListener());
        menuView.addHelpContentsButton(new BrowseUsersActionListener());
        menuView.addHelpButton(new BrowseUsersActionListener());
        menuView.addSendFeedbackButton(new BrowseUsersActionListener());
        menuView.addSendFeedbackButton(new BrowseUsersActionListener());

        
    }
    
    private class BrowseUsersActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            IDataHandler dataHandler = new DataHandler();
            BrowseUsersView browseUsersView = new BrowseUsersView(menuView.getFrame(), dataHandler.getUsernames(), user);
            BrowseUsersController browseUsersController = new BrowseUsersController(browseUsersView, user);
        }
    } 
	/*public void addMyProfileButton(ActionListener actionListener) {
		myProfile.addActionListener(actionListener);
		
	}	
	public void addHomeButton(ActionListener actionListener) {
		home.addActionListener(actionListener);
		
	}
	public void addStoreButton(ActionListener actionListener) {
		store.addActionListener(actionListener);		
	}
	public void addShoppingCartButton(ActionListener actionListener) {
		shoppingCart.addActionListener(actionListener);		
	}
	public void (ActionListener actionListener) {
		homePage.addActionListener(actionListener);		
	}
	public void (ActionListener actionListener) {
		menuBar.addAncestorListener((AncestorListener) actionListener);		
	}
	public void (ActionListener actionListener) {
		myFavorites.addActionListener(actionListener);		
	}
	public void (ActionListener actionListener) {
		helpContents.addActionListener(actionListener);		
	}
	public void (ActionListener actionListener) {
		help.addActionListener(actionListener);		
	}//sendFeedback
	public void addSendFeedbackButton(ActionListener actionListener) {
		sendFeedback.addActionListener(actionListener);		
	}*/
    
    
    
}
