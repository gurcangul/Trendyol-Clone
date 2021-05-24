package GUI;

import javax.swing.*;

import Product.IProduct;
import User.User;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MyProfileView extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
    MainFrameView mainFrameView;
    JButton btnNewButton;
    BeforeLoginView beforeLoginView;
    JButton btnNewButton_1;
    JTextField textField;
    JTextField textField_1;
    JPanel menuView;
    MenuViewForBuyer menuViewForBuyer;
    MenuViewForSeller menuViewForSeller;
    MenuViewForAdmin menuViewForAdmin;
    private User user;


    public void viewMyFavories() {
		
		// favorilist olacak
		
		JPanel panel = new JPanel();
        panel.setBounds(20, 31, 694, 398);
        add(panel);
        panel.setLayout(null);
        int x = 45;
        int y = 40;
        int width = 220;
        int height = 100;
        int buttonY = y+height+5;
        int buttonHeight = 21;
       // getUser().addProductToFavoriteList(null);
        if(getUser().getFavoriteList().size() != 0) {
	        for(IProduct prd: getUser().getFavoriteList()) {
	        	if(x < (694 - width)) {
			        JTextPane textPane = new JTextPane();
			        textPane.setBounds(x, y, width, height);
			        textPane.setText(prd.viewProductByBuyer());
			        panel.add(textPane);
			        
			        JButton addShoppingCart2Button = new JButton("Add Shopping Cart");
			        addShoppingCart2Button.setBounds(x, buttonY, 189, 21);
			        panel.add(addShoppingCart2Button);
			        
			        JButton discardFromFavoriesButton = new JButton("Discard From Favories");
			        discardFromFavoriesButton.setBounds(x, buttonY+buttonHeight+5, 189, 21);
			        panel.add(discardFromFavoriesButton);
			        x = width + x + 15;
	        	}
	        	else {
	        		y = buttonY * 3 + 15;
	        		JTextPane textPane = new JTextPane();
			        textPane.setBounds(x, y, width, height);
			        add(textPane);
	        	}
	        }
		}
	}
    
    public MyProfileView(MainFrameView mainFrameView, JPanel menuView) {
        this.setMainFrame(mainFrameView);
        this.menuView=menuView;
        this.setMainFrame(mainFrameView);  
        getMainFrame().addNewPanel2(menuView);
        getMainFrame().addMenuPanel3(this);
        setUser(null);
        
        new JPanel(new GridLayout(3, 1));       
        setSize(760, 460);
		setLayout(null);

		if(menuView instanceof MenuViewForBuyer) {
        	this.menuViewForBuyer=(MenuViewForBuyer) this.menuView;
        	user = menuViewForBuyer.getUser();       	
		}
        else if(menuView instanceof MenuViewForSeller) {
        	this.menuViewForSeller=(MenuViewForSeller) this.menuView;
        	user = menuViewForSeller.getUser();
        	}
        else if(menuView instanceof MenuViewForAdmin) {
        	this.menuViewForAdmin=(MenuViewForAdmin) this.menuView;
        	user = menuViewForAdmin.getUser();
        }		
        this.setMainFrame(mainFrameView);  
	}

	public MainFrameView getMainFrame() {
		return mainFrameView;
	}
	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}  
    public User getUser() {
			return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub		
	}
}