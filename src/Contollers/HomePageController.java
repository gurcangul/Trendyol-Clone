package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import GUI.BeforeLoginView;
import GUI.HomePageView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.MenuView;
import User.User;

public class HomePageController {
	private final  MainFrameView mainFrameView;
	private final  HomePageView homePageView;
	
    public HomePageController(MainFrameView mainFrameView, HomePageView homePageView ) {
    	this.mainFrameView=mainFrameView;
        this.homePageView = homePageView;
        homePageView.addViewAllUsersButtonActionListener(new viewAllUsersButtonActionListener());
        homePageView.addCreateCollectionButtonActionListener(new createCollectionButtonActionListener());
        homePageView.addMyProfileButtonActionListener(new myProfileButtonActionListener());
        homePageView.addSeeAllCollectionButtonActionListener(new seeAllCollectionButtonActionListener());
        homePageView.addTrendsButtonActionListener(new addTrendsButtonActionListener());
        homePageView.addMouseListener(new addMouseListener());
    }

    public HomePageView getHomePageView() {
		return homePageView;
	}
    private class addMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
        	//System.out.println("Bu e.getsource " + ((JButton) e.getSource()).getText());
	    	//Object o = e.getSource();
	    	//System.out.println(e.getSource().toString());
	    	String s = e.getSource().toString();
	    	String splitLine[] = s.split("=");
	    	int length = splitLine.length;
	    	splitLine[length-1] = splitLine[length-1].replace("]", "");
	    	System.out.println(splitLine[length-1]);
	    	
	
        	JOptionPane.showMessageDialog(null, "Menu Action Listener ");
            /*String title = browseWatchlistView.getUserInput("Watch List title:");
            currentUser.addWatchlist(new Watchlist(new ArrayList<>(),title));*/ 
        	LoginView loginView =  new LoginView(mainFrameView);
    		//mainFrameView.addNewPanel(loginView);	
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    
	private class viewAllUsersButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*String title = browseWatchlistView.getUserInput("Watch List title:");
            currentUser.addWatchlist(new Watchlist(new ArrayList<>(),title));*/ 
        	LoginView loginView =  new LoginView(mainFrameView);
    		//mainFrameView.addNewPanel(loginView);	
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    private class createCollectionButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*String title = browseWatchlistView.getUserInput("Watch List title:");
            currentUser.addWatchlist(new Watchlist(new ArrayList<>(),title));*/ 
        	LoginView loginView =  new LoginView(mainFrameView);
    		//mainFrameView.addNewPanel(loginView);	
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    private class myProfileButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*String title = browseWatchlistView.getUserInput("Watch List title:");
            currentUser.addWatchlist(new Watchlist(new ArrayList<>(),title));*/ 
        	LoginView loginView =  new LoginView(mainFrameView);
    		//mainFrameView.addNewPanel(loginView);	
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    private class seeAllCollectionButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*String title = browseWatchlistView.getUserInput("Watch List title:");
            currentUser.addWatchlist(new Watchlist(new ArrayList<>(),title));*/ 
        	LoginView loginView =  new LoginView(mainFrameView);
    		//mainFrameView.addNewPanel(loginView);	
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    private class addTrendsButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*String title = browseWatchlistView.getUserInput("Watch List title:");
            currentUser.addWatchlist(new Watchlist(new ArrayList<>(),title));*/ 
        	LoginView loginView =  new LoginView(mainFrameView);
    		//mainFrameView.addNewPanel(loginView);	
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    
}
