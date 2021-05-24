package GUI;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import User.User;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JMenu;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;

public class MenuViewForBuyer extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	  
	MainFrameView mainFrameView;
	BeforeLoginView beforeLoginView;
	private JPasswordField password;
	private String userName;
	private User user;

	JMenu myProfileMenu, homeMenu, storeMenu, helpMenu;
	JMenuBar menuBar;
	JMenuItem sendFeedbackMenuItem, logOutMenuItem, aboutMenuItem, shoppingCartMenuItem, homePageMenuItem, myFavoritesMenuItem;
	
	public MenuViewForBuyer(MainFrameView mainFrameView,User user ) {
		this.mainFrameView=mainFrameView;                
		this.setUser(user); 
        showPanel();
       // user.addObserver(this);
	}
	public void showPanel(){
	    menuBar = new JMenuBar();
	    menuBar.setBackground(Color.WHITE);
	    menuBar.setBounds(10, 10, 424, 22);
	    add(menuBar);
	
	    homeMenu = new JMenu("Home");
	    menuBar.add(homeMenu);
	    homePageMenuItem = new JMenuItem("Home Page");
	    homeMenu.add(homePageMenuItem);
	    

	    myProfileMenu = new JMenu("My Profile");
	    menuBar.add(myProfileMenu);
	           
	    shoppingCartMenuItem = new JMenuItem("Shopping Cart");
	    myProfileMenu.add(shoppingCartMenuItem);
	    
	    myFavoritesMenuItem = new JMenuItem("My Favorites");
	    myProfileMenu.add(myFavoritesMenuItem);		        
	    JMenuItem generalAccountSettings = new JMenuItem("General Account Settings");
	    myProfileMenu.add(generalAccountSettings);
	    
	    storeMenu = new JMenu("Store");
	    storeMenu.setBackground(Color.WHITE);
	    menuBar.add(storeMenu);
	    
	    JMenuItem allCategories = new JMenuItem("All Categories");
	    storeMenu.add(allCategories);
	    //User user = new User();
	    //user.getserName
	    String name="";
	    //if(!user.getUserName().equals(null))
	    	 try {
	    		 name=user.getUserName();
	    	 }
	    	 catch (Exception e) {
				// TODO: handle exception
		}
    JMenu userName = new JMenu(name);
    menuBar.add(userName);
    
    logOutMenuItem = new JMenuItem("Log Out");
    logOutMenuItem.setIcon(new ImageIcon(MenuViewForBuyer.class.getResource("/back.png")));
    userName.add(logOutMenuItem);
    helpMenu = new JMenu("Help");
    menuBar.add(helpMenu);
  
    sendFeedbackMenuItem = new JMenuItem("Send Feedback");    
    helpMenu.add(sendFeedbackMenuItem);
 
    aboutMenuItem = new JMenuItem("About");
    helpMenu.add(aboutMenuItem);
  
    mainFrameView.addNewPanel(this);
	}
	
	public void setVisible() {
	        mainFrameView.setVisible(true);
	}

	public BeforeLoginView getBeforeLoginPanel() {
		return beforeLoginView;
	}

	public void setBeforeLoginPanel(BeforeLoginView beforeLoginView) {
		this.beforeLoginView = beforeLoginView;
	}

	public MainFrameView getMainFrame() {
		return mainFrameView;
	}

	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public void addOkButtonListener(ActionListener actionListener){
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

//	ActionListener actionListener
	public void addSendFeedbackActionListener(ActionListener actionListener) {
		sendFeedbackMenuItem.addActionListener(actionListener);		
	}	
	public void addAboutActionListener(ActionListener actionListener) {
		aboutMenuItem.addActionListener(actionListener);		
	}	
	public void addLogOutActionListener(ActionListener actionListener) {
		logOutMenuItem.addActionListener(actionListener);		
	}
	public void addShoppingCartActionListener(ActionListener actionListener) {
		shoppingCartMenuItem.addActionListener(actionListener);		
	}
	public void addHomePageActionListener(ActionListener actionListener) {
		homePageMenuItem.addActionListener(actionListener);		
	}	
	public void addMyFavoritesActionListener(ActionListener actionListener) {
		myFavoritesMenuItem.addActionListener(actionListener);		
	}	
	
}