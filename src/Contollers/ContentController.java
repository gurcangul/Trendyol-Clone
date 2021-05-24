package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import FileIO.DataHandler;
import GUI.BuyerHomePageView;
import GUI.MainFrameView;
import GUI.MenuViewForBuyer;
import Product.IProduct;
import User.User;

public class ContentController {
    private MenuViewForBuyer menuView;
    private MainFrameView mainFrameView;
    private User user;
    public ContentController(MainFrameView mainFrameView,MenuViewForBuyer menuView, User user) {
    	this.mainFrameView=mainFrameView;
        this.menuView = menuView;
        this.user = user;
        ArrayList<IProduct> productAndCategories = new ArrayList<IProduct>();
      //  menuView.addMyProfileButton(new MyProfileButtonActionListener());
        //menuView.addHomeButton(new HomeButtonActionListener());
       /* DataHandler dataHandler = new DataHandler();
        productAndCategories=dataHandler.getProductAndCategories();
        DataHandler.getProductAndCategories();*/        
    } 
    private class MyProfileButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        }
    }    
    private class HomeButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	BuyerHomePageView homePageView = new BuyerHomePageView(mainFrameView,menuView);
    		BuyerHomePageController homePageController = new BuyerHomePageController(mainFrameView,homePageView);
        }
    } 
}
