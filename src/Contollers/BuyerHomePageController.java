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
import Product.IProduct;
import User.User;

public class BuyerHomePageController {
	private final  MainFrameView mainFrameView;
	private final  BuyerHomePageView homePageView;
	
    public BuyerHomePageController(MainFrameView mainFrameView, BuyerHomePageView homePageView ) {
    	this.mainFrameView=mainFrameView;
        this.homePageView = homePageView;
        homePageView.addMouseListener2(new addMouseListener2());
    }

    public BuyerHomePageView getHomePageView() {
		return homePageView;
	}
    public void getCategories(ArrayList<IProduct> product, String productName) {
		for(IProduct prd: product) {
			if(prd.getName().equalsIgnoreCase(productName)) {
	   			 if(prd.getChild()!= null) {	
	   				 int size = prd.getChild().size();
	   				 homePageView.ViewProductPanel(size, productName);
	   			 }
			}
	   		else {
		            if(prd.getChild()!= null) {	
		            	getCategories(prd.getChild(), productName);
		            }
	   		}
		}
	}      
    private class addMouseListener2 implements ActionListener {
 
		@Override
		public void actionPerformed(ActionEvent e) {
	    	String splitLine[] = e.getSource().toString().split("=");
	    	int length = splitLine.length;
	    	String productName = splitLine[length-1].replace("]", "");
	    	//System.out.println(productName);
	    	ArrayList<IProduct> products = DataHandler.getProductAndCategoriesAsAObject();
	    	for(IProduct prd: products) {
	    		if(prd.getName().equalsIgnoreCase(productName)) {
	    			 if(prd.getChild()!= null) {	
	    				 int size = prd.getChild().size();
	    				 homePageView.ViewProductPanel(size, productName);
	    				 
	    			 }
	    		}
	    		else {
		            if(prd.getChild()!= null) {	
		            	getCategories(prd.getChild(), productName);
		            }
	    		}
			}
		}
    }
    private class viewAllUsersButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	LoginView loginView =  new LoginView(mainFrameView);
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    private class createCollectionButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {          
        	LoginView loginView =  new LoginView(mainFrameView);
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    private class myProfileButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	LoginView loginView =  new LoginView(mainFrameView);
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    private class seeAllCollectionButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {         
        	LoginView loginView =  new LoginView(mainFrameView);
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    } 
    private class addTrendsButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {         
        	LoginView loginView =  new LoginView(mainFrameView);
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    }     
}
