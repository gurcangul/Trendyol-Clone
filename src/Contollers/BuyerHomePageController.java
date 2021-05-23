package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import FileIO.DataHandler;
import GUI.BeforeLoginView;
import GUI.BuyerHomePageView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.MenuView;
import Product.IProduct;
import User.User;

public class BuyerHomePageController {
	private final  MainFrameView mainFrameView;
	private final  BuyerHomePageView homePageView;
	
    public BuyerHomePageController(MainFrameView mainFrameView, BuyerHomePageView homePageView ) {
    	this.mainFrameView=mainFrameView;
        this.homePageView = homePageView;
        homePageView.addViewAllUsersButtonActionListener(new viewAllUsersButtonActionListener());
        homePageView.addCreateCollectionButtonActionListener(new createCollectionButtonActionListener());
        homePageView.addMyProfileButtonActionListener(new myProfileButtonActionListener());
        homePageView.addSeeAllCollectionButtonActionListener(new seeAllCollectionButtonActionListener());
        homePageView.addTrendsButtonActionListener(new addTrendsButtonActionListener());
        homePageView.addMouseListener2(new addMouseListener2());
    }

    public BuyerHomePageView getHomePageView() {
		return homePageView;
	}
    public void getCategories(ArrayList<IProduct> product, ArrayList<IProduct> allProducts) {
		for(IProduct prd: product) {
			if("class Product.Category".equalsIgnoreCase(prd.getClass().toString())) {
				allProducts.add(prd);
				if(prd.getChild() != null) {
					getCategories(prd.getChild(), allProducts);
				}
			}
			else if("class Product.Product".equalsIgnoreCase(prd.getClass().toString())) {
				allProducts.add(prd);
			}
		}
	}
    private class addMouseListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
	    	String splitLine[] = e.getSource().toString().split("=");
	    	int length = splitLine.length;
	    	String productName = splitLine[length-1].replace("]", "");
	    	System.out.println(productName);
		}

    }
    /*
    private class addMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
	    	String splitLine[] = e.getSource().toString().split("=");
	    	int length = splitLine.length;
	    	String categoryName = splitLine[length-1].replace("]", "");
	    	//System.out.println(categoryName);
	    	ArrayList<IProduct> productList = DataHandler.getProductAndCategoriesAsAObject();
	    	ArrayList<IProduct> allProducts = new ArrayList<IProduct>();
	    	for(IProduct prd: productList) {
	    		if(prd.getName().equalsIgnoreCase(categoryName)) {
	    			if(prd.getChild() != null) {
	    				getCategories(prd.getChild(), allProducts);
	    			}
	    		}
	    	}
	    	for(IProduct prd: allProducts) {
	    		System.out.println(prd.getName());
	    	}
        	/*JOptionPane.showMessageDialog(null, "Menu Action Listener ");
        	LoginView loginView =  new LoginView(mainFrameView);
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } */
    
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
