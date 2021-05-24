package GUI;
import User.User;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;

public class MenuViewForSeller extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	  
	MainFrameView mainFrameView;
	BeforeLoginView beforeLoginView;
	private JPasswordField password;
	private String userName;	
	private User user; 

	JMenu myProfile,home,help;
	JMenuBar menuBar;
	JMenuItem sendFeedback,logOut,about,homePage,myProducts,helpContents;

	public MenuViewForSeller(MainFrameView mainFrameView,User user ) {
		this.mainFrameView=mainFrameView;                
		this.setUser(user);
        showPanel();

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
	    
	    myProducts = new JMenuItem("My Products");
	    myProfile.add(myProducts);		        
	    JMenuItem generalAccountSettings = new JMenuItem("General Account Settings");
	    myProfile.add(generalAccountSettings);
	    String name="";
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
	public void addHomePageButton(ActionListener actionListener) {
		homePage.addActionListener(actionListener);		
	}
	public void addMyFavoritesButton(ActionListener actionListener) {
		myProducts.addActionListener(actionListener);		
	}
	public void addAboutButton(ActionListener actionListener) {
		about.addActionListener(actionListener);		
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