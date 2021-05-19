package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        menuView.addBrowseUsersActionListener(new BrowseUsersActionListener());
        menuView.addBrowseWatchlistsActionListener(new BrowseWatchlistsActionListener());
        menuView.addLogoutActionListener(new LogoutActionListener());
    }
    
    private class BrowseUsersActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            IDataHandler dataHandler = new DataHandler();
            BrowseUsersView browseUsersView = new BrowseUsersView(menuView.getFrame(), dataHandler.getUsernames(), user);
            BrowseUsersController browseUsersController = new BrowseUsersController(browseUsersView, user);
        }
    } 
    
    
    
    
}
