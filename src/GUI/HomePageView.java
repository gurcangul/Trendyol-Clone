package GUI;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Observer.Observer;
import Product.IProduct;
import User.User;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import FileIO.DataHandler;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.Box;
import javax.swing.JTextPane;
import javax.swing.JCheckBoxMenuItem;

public class HomePageView extends JPanel implements Observer{

	private static final long serialVersionUID = -5277901207402632648L;
	private MainFrameView mainFrameView;
	private MenuView menuView;
	private HomePageView homePageView;
	private User user;

	JButton viewAllUsersButton;
	JButton createCollectionButton;
	JButton myProfileButton; JButton seeAllCollectionButton; JButton trendsButton;JButton btn;
	List<JButton> buttonList;
	JMenu category2,category1,category3;JMenuItem category2Child1, category1Child1 ;
	JMenuBar menuBar;JMenuItem category2Child2;
	JMenuItem helpContents;  JMenu help;  JMenuItem sendFeedback; 
	private JTextField textField;
	private JMenuItem category1Child2;
	private JMenuItem category1Child3;
	private JMenu mnNewMenu;
	public HomePageView(MainFrameView mainFrameView,MenuView menuView) {
		this.menuView=menuView;
		this.setMainFrame(mainFrameView);        
		new JPanel(new GridLayout(3, 1));
        setLayout(null);
        showPanel();		
	}

	public void showPanel(){
		ArrayList<IProduct> products = DataHandler.getProductAndCategoriesAsAObject();

	    menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        menuBar.setBounds(0, 31, 694, 22);
        add(menuBar);

        //DataHandler.getProductAndCategories().get(0).getChild().get(0).getName()
        /*for(int i=0;i<10;i++) {           
        	if(DataHandler.getProductAndCategories().get(i).getClass().getName().equals("category")) {
        		System.out.println(" : : : : "+  DataHandler.getProductAndCategories().get(i).getName());
        		 //category1 = new JMenu(DataHandler.getProductAndCategories().get(i).getName());
                //menuBar.add(category1);
        	}
        }*/
    	System.out.println(products.size());

        for(int i=0;i<products.size();i++) {
			System.out.println("olustuuu"+products.get(i).getName());
   		 	category1 = new JMenu(products.get(i).getName());
            menuBar.add(category1);
            if(products.get(i).getChild()!= null) {
            	  for(int j=0;j<products.get(i).getChild().size();j++) {
            		  category1Child1 = new JMenuItem(products.get(i).getChild().get(j).getName());
            		  category1.add((category1Child1) );
            	  }
            }
            
		}
       // for(menuBar.getComponent().)
        
        
        
        
        category1 = new JMenu("category1");
        menuBar.add(category1);
        category1Child1 = new JMenuItem("category1Child1");
        category1.add(category1Child1);
        
        mnNewMenu = new JMenu("New menu");
        category1.add(mnNewMenu);
        category1Child2 = new JMenuItem("category1Child1");
        category1.add(category1Child2);
        category1Child3 = new JMenuItem("category1Child3");
        category1.add(category1Child3);
        
        /*
	    category2 = new JMenu("category2");
	    menuBar.add(category2);	           
	    category2Child1 = new JMenuItem("category2Child1");
	    category2.add(category2Child1);	    
	    category2Child2 = new JMenuItem("category2Child2");
	    category2.add(category2Child2);		        
	    JMenuItem category2Child3 = new JMenuItem("category2Child3");
	    category2.add(category2Child3);
	    
	    category3 = new JMenu("category3");
	    category3.setBackground(Color.WHITE);
	    menuBar.add(category3);
	    
	    JMenuItem category3Child1 = new JMenuItem("category3Child1");
	    category3.add(category3Child1);
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
	    help = new JMenu("Help");
	    menuBar.add(help);
	    
	    helpContents = new JMenuItem("Help Contents");
	    help.add(helpContents);
	    sendFeedback = new JMenuItem("Send Feedback");

	    help.add(sendFeedback);
	    
	    JMenuItem about = new JMenuItem("About");
	    help.add(about);
	   
	    */
	    mainFrameView.addNewPanel(this);
	    
	   /* 
	    while (iterator.hasNext()) {
	    	  MenuComponent menuComponent = iterator.next();
	    	  JMenuItem item = new JMenuItem(menuComponent.getName());
	    	  popupMenu.add(item);
	    	}
		*/
		
	    
	    
	    
	    
		//-----------------
        createCollectionButton = new JButton("Create Collection");
        createCollectionButton.setBounds(31, 93, 202, 21);
        add(createCollectionButton);
        
        seeAllCollectionButton = new JButton("See All Collections");
        seeAllCollectionButton.setBounds(243, 93, 207, 21);
        add(seeAllCollectionButton);
        
        myProfileButton = new JButton("My Profile");
        myProfileButton.setBounds(460, 93, 195, 21);
        add(myProfileButton);
        
       
        trendsButton = new JButton("Trends");
        trendsButton.setIcon(new ImageIcon("C:\\Users\\Gurcan\\eclipse-workspace\\G12_CENG431_HW3-v1\\src\\trends.png"));
        trendsButton.setBounds(289, 178, 109, 21);
        add(trendsButton);
        
        viewAllUsersButton = new JButton("View All Users");
        viewAllUsersButton.setBounds(243, 141, 207, 21);
        add(viewAllUsersButton);
        
		this.setMainFrame(mainFrameView);  
        //getMainFrame().addNewPanel2(this);
        getMainFrame().addNewPanel2(menuView);
        getMainFrame().addMenuPanel3(this);
       // DataHandler.getProductAndCategories().get(0).getChild();
        String s="";
        //for(int i = 0;i<2;i++) {
        //	s=DataHandler.getProductAndCategories().get(0).getChild().get(0).getName()+"  " +DataHandler.getProductAndCategories().get(0).getChild().get(1).getName();
        	/*s+=DataHandler.getProductAndCategories().get(0).getChild().get(0).getName()+"\n";
        	s+=DataHandler.getProductAndCategories().get(0).getChild().get(1).getName();*/
        	/*+"\n \n" +DataHandler.getProductAndCategories().get(0).getChild().get(1).getName())*/
        /*
        	for(int i=0;i<5;i++) {
        	JButton btn2 = new JButton("New Button");
            btn2.setBounds(139+i, 43, 207, 21);
            add(btn2);        
            }   */       
/*
        textField = new JTextField(s);
        textField.setBounds(102, 191, 245, 59);
        add(textField);
        textField.setColumns(10);
        
        JTree tree = new JTree();
        tree.setBounds(471, 133, 140, 108);
        add(tree);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(403, 251, 114, 32);
        add(textArea);
        
        JTextPane textPane = new JTextPane();
        textPane.setBounds(67, 111, 124, 56);
        add(textPane);
		//mainFrame.addMenuPanel(myProfile);
        */

	}

	public MainFrameView getMainFrame() {
		return mainFrameView;
	}


	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	/*JButton viewAllUsersButton;
	JButton createCollectionButton;
	JButton myProfileButton; JButton seeAllCollectionButton; JButton trendsButton;*/
    public void addViewAllUsersButtonActionListener(ActionListener actionListener){
    	viewAllUsersButton.addActionListener(actionListener);
    }
    public void addCreateCollectionButtonActionListener(ActionListener actionListener){
    	createCollectionButton.addActionListener(actionListener);
    }
    public void addMyProfileButtonActionListener(ActionListener actionListener){
    	myProfileButton.addActionListener(actionListener);
    }
    public void addSeeAllCollectionButtonActionListener(ActionListener actionListener){
    	seeAllCollectionButton.addActionListener(actionListener);
    }
    public void addTrendsButtonActionListener(ActionListener actionListener){
    	trendsButton.addActionListener(actionListener);
    }
	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}
}
