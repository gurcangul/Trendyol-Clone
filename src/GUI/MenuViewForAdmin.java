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


public class MenuViewForAdmin extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	  
	MainFrameView mainFrameView;
	BeforeLoginView beforeLoginView;
	private JPasswordField password;
	private String userName;
	private User user;

	JMenu categoriesMenu,homeMenu,feedbacksMenu,productsMenu,usersMenu;
	JMenuBar menuBar;
	JMenuItem addCategoryMenuItem,viewFeedbackMenuItem,viewAllProductsMenuItem, logOutMenuItem,viewAllCategoryMenuItem, homePageMenuItem,viewAllUsersMenuItem, viewAllSelersMenuItem,viewAllBuyersMenuItem;


	
	public MenuViewForAdmin(MainFrameView mainFrameView,User user ) {
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
	        
	
	    categoriesMenu = new JMenu("Categories");
	    menuBar.add(categoriesMenu);
	           
	    viewAllCategoryMenuItem = new JMenuItem("View All Category");
	    categoriesMenu.add(viewAllCategoryMenuItem);
	    
	    addCategoryMenuItem = new JMenuItem("Add Category");
	    categoriesMenu.add(addCategoryMenuItem);
	    
	    productsMenu = new JMenu("Products");
	    menuBar.add(productsMenu);
	    
	    viewAllProductsMenuItem = new JMenuItem("View All Products");
	    productsMenu.add(viewAllProductsMenuItem);
	    
	    String name="";
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
	    feedbacksMenu = new JMenu("Feedbacks");
	    menuBar.add(feedbacksMenu);
	    
	    viewFeedbackMenuItem = new JMenuItem("View Feedbacks");
	    feedbacksMenu.add(viewFeedbackMenuItem);
	    
	    usersMenu = new JMenu("Users");
	    menuBar.add(usersMenu);
	    
	    viewAllUsersMenuItem = new JMenuItem("View All Users");
	    usersMenu.add(viewAllUsersMenuItem);
	    
	    viewAllBuyersMenuItem = new JMenuItem("View All Buyers");
	    usersMenu.add(viewAllBuyersMenuItem);
	    
	    viewAllSelersMenuItem = new JMenuItem("View All Sellers");
	    usersMenu.add(viewAllSelersMenuItem);
 
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public JPasswordField getPassword() {
		return password;
	}
	public void setPassword(JPasswordField password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	//	ActionListener actionListener
	public void addAddCategoryActionListener(ActionListener actionListener) {
		addCategoryMenuItem.addActionListener(actionListener);		
	}
	public void addViewFeedbackActionListener(ActionListener actionListener) {
		viewFeedbackMenuItem.addActionListener(actionListener);		
	}	
	public void addViewAllProductsActionListener(ActionListener actionListener) {
		viewAllProductsMenuItem.addActionListener(actionListener);		
	}	
	public void addLogOutActionListener(ActionListener actionListener) {
		logOutMenuItem.addActionListener(actionListener);		
	}
	public void addViewAllCategoryActionListener(ActionListener actionListener) {
		viewAllCategoryMenuItem.addActionListener(actionListener);		
	}
	public void addHomePageActionListener(ActionListener actionListener) {
		homePageMenuItem.addActionListener(actionListener);		
	}	
	public void addViewAllUsersActionListener(ActionListener actionListener) {
		viewAllUsersMenuItem.addActionListener(actionListener);		
	}	
	public void addViewAllSelersActionListener(ActionListener actionListener) {
		viewAllSelersMenuItem.addActionListener(actionListener);		
	}
	public void addViewAllBuyersActionListener(ActionListener actionListener) {
		viewAllBuyersMenuItem.addActionListener(actionListener);		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub		
	}
}