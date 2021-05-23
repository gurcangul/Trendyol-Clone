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
import GUI.MenuViewForBuyer;
import GUI.SellerHomePageView;
import Product.IProduct;
import User.User;

public class SellerHomePageController {
	private final  MainFrameView mainFrameView;
	private final  SellerHomePageView homePageView;
	
    public SellerHomePageController(MainFrameView mainFrameView, SellerHomePageView homePageView ) {
    	this.mainFrameView=mainFrameView;
        this.homePageView = homePageView;
        homePageView.addUpdateStokButtonActionListener(new updateStokButtonActionListener());
        homePageView.addProductButtonActionListener(new productButtonActionListener());
        homePageView.addMyProfileButtonActionListener(new myProfileButtonActionListener());
        homePageView.addSeeAllProductsButtonActionListener(new seeAllProductsButtonActionListener());
        homePageView.addSaleProductsButtonActionListener(new saleProductsButtonActionListener());
       // homePageView.addMouseListener2(new addMouseListener2());
    }
    
    public SellerHomePageView getHomePageView() {
		return homePageView;
	}
    
    
   /* public void getCategories(ArrayList<IProduct> product, ArrayList<IProduct> allProducts) {
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

    }*/
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
    
	private class updateStokButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*String title = browseWatchlistView.getUserInput("Watch List title:");
            currentUser.addWatchlist(new Watchlist(new ArrayList<>(),title));*/ 
        	LoginView loginView =  new LoginView(mainFrameView);
    		//mainFrameView.addNewPanel(loginView);	
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    private class productButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	//homePageView.getAddProductPanel().show();
        	System.out.println("ben calistim");
        	homePageView.showAddProductPanel();
        	
            /*String title = browseWatchlistView.getUserInput("Watch List title:");
            currentUser.addWatchlist(new Watchlist(new ArrayList<>(),title));*/ 
        	//LoginView loginView =  new LoginView(mainFrameView);
    		//mainFrameView.addNewPanel(loginView);	
    		//LoginController loginController = new LoginController(mainFrameView,loginView);
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
    private class seeAllProductsButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*String title = browseWatchlistView.getUserInput("Watch List title:");
            currentUser.addWatchlist(new Watchlist(new ArrayList<>(),title));*/ 
        	LoginView loginView =  new LoginView(mainFrameView);
    		//mainFrameView.addNewPanel(loginView);	
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    private class saleProductsButtonActionListener implements ActionListener {
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
