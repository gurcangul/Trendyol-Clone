package GUI;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Observer.Observer;
import User.User;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MenuPanel extends JPanel implements Observer {
	  private static final long serialVersionUID = 1L;

	  private MainFrame mainFrame;
	  private BeforeLoginPanel beforeLoginPanel;
	  private JPasswordField password;
	  private String userName;
	  public MenuPanel(MainFrame mainFrame ) {
			setMainFrame(mainFrame);        
			JPanel jP=  new JPanel(new GridLayout(3, 1));
	        
	        JMenuBar menuBar = new JMenuBar();
	        menuBar.setBackground(Color.WHITE);
	        menuBar.setBounds(10, 10, 424, 22);
	        add(menuBar);
	
	        JMenu home = new JMenu("Home");
	        menuBar.add(home);
	        JMenuItem homePage = new JMenuItem("Home Page");
	        home.add(homePage);
	        
	        homePage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HomePage homePage = new HomePage(mainFrame);
        		mainFrame.addMenuPanel(homePage);
        	}
        });

        JMenu myProfile = new JMenu("My Profile");
        menuBar.add(myProfile);
               
        JMenuItem shoppingCart = new JMenuItem("Shopping Cart");
        myProfile.add(shoppingCart);
        
        JMenuItem myFavorites = new JMenuItem("My Favorites");
        myProfile.add(myFavorites);		        
        JMenuItem generalAccountSettings = new JMenuItem("General Account Settings");
        myProfile.add(generalAccountSettings);
        
        JMenu store = new JMenu("Store");
        store.setBackground(Color.WHITE);
        menuBar.add(store);
        
        JMenuItem allCategories = new JMenuItem("All Categories");
        store.add(allCategories);
        //User user = new User();
        //user.getserName
        String name=getUserName();
        System.out.println(" asadasfdafsaf"+getUserName());
        JMenu userName = new JMenu("sadfsdf");
        menuBar.add(userName);
        JMenuItem myShoppingCart = new JMenuItem(name);
        userName.add(myShoppingCart);
        JMenuItem logOut = new JMenuItem("Log Out");
        logOut.setIcon(new ImageIcon("C:\\Users\\Gurcan\\eclipse-workspace\\G12_CENG431_HW3-v1\\src\\logout.png"));
        logOut.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
               int result = JOptionPane.showConfirmDialog(mainFrame,"Sure? You want to exit?", "Swing Tester",
                  JOptionPane.YES_NO_OPTION,
                  JOptionPane.QUESTION_MESSAGE);
               if(result == JOptionPane.YES_OPTION){
                  //mainFrame.setTitle("You selected: Yes");
            	   beforeLoginPanel =  new BeforeLoginPanel(mainFrame);
           			mainFrame.addNewPanel(beforeLoginPanel);
                  
               }else if (result == JOptionPane.NO_OPTION){
            	   //mainFrame.setTitle("Outfit Rating Platform");
               }else {
            	   //mainFrame.setTitle("None selected");
               }
            }
      
        });
        userName.add(logOut);
        
       
        
        JMenu help = new JMenu("Help");
        menuBar.add(help);
        
        JMenuItem helpContents = new JMenuItem("Help Contents");
        help.add(helpContents);
        JMenuItem sendFeedback = new JMenuItem("Send Feedback");
        sendFeedback.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FeedbackPanel feedbackPanel = new FeedbackPanel(mainFrame);
        		mainFrame.addMenuPanel(feedbackPanel);
        		
        	}
        });

        help.add(sendFeedback);
        
        JMenuItem about = new JMenuItem("About");
        help.add(about);
        
        
        
        
        
        
        about.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AboutAppPanel aboutPanel = new AboutAppPanel(mainFrame);
        		mainFrame.addMenuPanel(aboutPanel);
        		
        	}
        });
       
       
	}
	public void setVisible() {
	        mainFrame.setVisible(true);
	}


	public BeforeLoginPanel getBeforeLoginPanel() {
		return beforeLoginPanel;
	}


	public void setBeforeLoginPanel(BeforeLoginPanel beforeLoginPanel) {
		this.beforeLoginPanel = beforeLoginPanel;
	}


 

	public MainFrame getMainFrame() {
		return mainFrame;
	}


	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}


	public JPasswordField getPassword() {
		return password;
	}


	public void setPassword(JPasswordField password) {
		this.password = password;
	}


	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}
	public void addOkButtonListener(ActionListener actionListener){
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


}
