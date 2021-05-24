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

	JMenu myProfile,home,store,help;
	JMenuBar menuBar;
	JMenuItem helpContents, sendFeedback, logOut, about,shoppingCart, homePage, myFavorites;
	
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
	
	    home = new JMenu("Home");
	    menuBar.add(home);
	    homePage = new JMenuItem("Home Page");
	    home.add(homePage);
	    

	    myProfile = new JMenu("My Profile");
	    menuBar.add(myProfile);
	           
	    shoppingCart = new JMenuItem("Shopping Cart");
	    myProfile.add(shoppingCart);
	    
	    myFavorites = new JMenuItem("My Favorites");
	    myProfile.add(myFavorites);		        
	    JMenuItem generalAccountSettings = new JMenuItem("General Account Settings");
	    myProfile.add(generalAccountSettings);
	    
	    store = new JMenu("Store");
	    store.setBackground(Color.WHITE);
	    menuBar.add(store);
	    
	    JMenuItem allCategories = new JMenuItem("All Categories");
	    store.add(allCategories);
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
    
    logOut = new JMenuItem("Log Out");
    logOut.setIcon(new ImageIcon(MenuViewForBuyer.class.getResource("/back.png")));
    userName.add(logOut);
    help = new JMenu("Help");
    menuBar.add(help);
  
    sendFeedback = new JMenuItem("Send Feedback");    
    help.add(sendFeedback);
 
    about = new JMenuItem("About");
    help.add(about);
  
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
	public void addMyProfileButton(ActionListener actionListener) {
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
	public void addHomePageButton(ActionListener actionListener) {
		homePage.addActionListener(actionListener);		
	}
	public void addMyFavoritesButton(ActionListener actionListener) {
		myFavorites.addActionListener(actionListener);		
	}
	public void addHelpButton(ActionListener actionListener) {
		help.addActionListener(actionListener);		
	}
	public void addSendFeedbackButton(ActionListener actionListener) {
		sendFeedback.addActionListener(actionListener);		
	}	
	public void addLogOutButton(ActionListener actionListener) {
		logOut.addActionListener(actionListener);		
	}
	public void addAboutButton(ActionListener actionListener) {
		about.addActionListener(actionListener);		
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
}