package GUI;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import User.User;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.SystemColor;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MenuViewForSeller extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	  
	MainFrameView mainFrameView;
	BeforeLoginView beforeLoginView;
	private JPasswordField password;
	private String userName;
	JMenu myProfile,home;JMenuItem homePage ;
	JMenuBar menuBar;JMenuItem myProducts;
	JMenuItem helpContents;  JMenu help;  JMenuItem sendFeedback; JMenuItem logOut;
	private User user;
	
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
	    JMenuItem myShoppingCart = new JMenuItem(name);
	    userName.add(myShoppingCart);
	    logOut = new JMenuItem("Log Out");
	    logOut.setIcon(new ImageIcon("C:\\Users\\Gurcan\\eclipse-workspace\\G12_CENG431_HW3-v1\\src\\logout.png"));
  
	    userName.add(logOut);
	    help = new JMenu("Help");
	    menuBar.add(help);
	    
	    helpContents = new JMenuItem("Help Contents");
	    help.add(helpContents);
	    sendFeedback = new JMenuItem("Send Feedback");
	    
	    help.add(sendFeedback);
	    
	    JMenuItem about = new JMenuItem("About");
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
	public void addHelpContentsButton(ActionListener actionListener) {
		helpContents.addActionListener(actionListener);		
	}
	public void addHelpButton(ActionListener actionListener) {
		help.addActionListener(actionListener);		
	}//sendFeedback logOut
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
