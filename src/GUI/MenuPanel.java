package GUI;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class MenuPanel extends JPanel {
	  private static final long serialVersionUID = 1L;

	  private MainFrame mainFrame;
	  private LoginPanel loginPanel;
	  private JTextField userName;
	  private JPasswordField password;

	public MenuPanel(MainFrame mainFrame) {
				this.setMainFrame(mainFrame);        
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
		        

		        
		        JMenuItem mnıtmNewMenuItem_6 = new JMenuItem("Shopping Cart");
		        myProfile.add(mnıtmNewMenuItem_6);
		        
		        JMenuItem mnıtmNewMenuItem_7 = new JMenuItem("My Favorites");
		        myProfile.add(mnıtmNewMenuItem_7);		        
		        JMenuItem mnıtmNewMenuItem_5 = new JMenuItem("General Account Settings");
		        myProfile.add(mnıtmNewMenuItem_5);
		        
		        JMenu mnNewMenu_5 = new JMenu("Store");
		        mnNewMenu_5.setBackground(Color.WHITE);
		        menuBar.add(mnNewMenu_5);
		        
		        JMenuItem mnıtmNewMenuItem_15 = new JMenuItem("All Categories");
		        mnNewMenu_5.add(mnıtmNewMenuItem_15);
		        //User user = new User();
		        //user.getserName
		        
		        JMenu userName = new JMenu("userName");
		        menuBar.add(userName);
		        JMenuItem mnıtmNewMenuItem_8_1 = new JMenuItem("My Shopping Cart");
		        userName.add(mnıtmNewMenuItem_8_1);
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
		            	   	loginPanel =  new LoginPanel(mainFrame);
		           			mainFrame.addNewPanel(loginPanel);
		                  
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
		        
		        JMenuItem mnıtmNewMenuItem_14 = new JMenuItem("Help Contents");
		        help.add(mnıtmNewMenuItem_14);
		        JMenuItem mnıtmNewMenuItem_12 = new JMenuItem("Send Feedback");
		        mnıtmNewMenuItem_12.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		FeedbackPanel feedbackPanel = new FeedbackPanel(mainFrame);
		        		mainFrame.addMenuPanel(feedbackPanel);
		        		
		        	}
		        });

		        help.add(mnıtmNewMenuItem_12);
		        
		        JMenuItem mnıtmNewMenuItem_13 = new JMenuItem("About");
		        help.add(mnıtmNewMenuItem_13);
		        
		        
		        
		        
		        
		        
		        mnıtmNewMenuItem_13.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		AboutAppPanel aboutPanel = new AboutAppPanel(mainFrame);
		        		mainFrame.addMenuPanel(aboutPanel);
		        		
		        	}
		        });
		       
		       
			}


	public LoginPanel getLoginPanel() {
		return loginPanel;
	}


	public void setLoginPanel(LoginPanel loginPanel) {
		this.loginPanel = loginPanel;
	}


	public JTextField getUserName() {
		return userName;
	}


	public void setUserName(JTextField userName) {
		this.userName = userName;
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
	
}
