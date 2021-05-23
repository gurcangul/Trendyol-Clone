package GUI;

import java.awt.GridLayout;

import javax.swing.JPanel;

import Observer.Observer;
import Product.IProduct;
import User.User;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;


import FileIO.DataHandler;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class BuyerHomePageView extends JPanel implements Observer{

	private static final long serialVersionUID = -5277901207402632648L;
	private MainFrameView mainFrameView;
	private MenuView menuView;
	private BuyerHomePageView homePageView;
	private User user;

	JButton viewAllUsersButton;
	JButton createCollectionButton;
	JButton myProfileButton; JButton seeAllCollectionButton; JButton trendsButton;JButton btn;
	List<JButton> buttonList;
	ArrayList<JMenu> menuList = new ArrayList<JMenu>();;
	ArrayList<JMenuItem> menuItemList = new ArrayList<JMenuItem>();
	JMenu category2,category1,category3;JMenuItem category2Child1, category1Child1 ;
	JMenuBar menuBar;JMenuItem category2Child2;
	JMenuItem helpContents;  JMenu help;  JMenuItem sendFeedback; 
	
	public BuyerHomePageView(MainFrameView mainFrameView,MenuView menuView) {
		this.menuView=menuView;
		this.setMainFrame(mainFrameView);        
		new JPanel(new GridLayout(3, 1));
        setLayout(null);
        showPanel();		
	}

	public void getCategories(ArrayList<IProduct> product, JMenu category) {
		for(IProduct prd: product) {
			if("class Product.Category".equalsIgnoreCase(prd.getClass().toString())) {
				JMenu childCategory = new JMenu(prd.getName());
				category.add(childCategory);
				menuList.add(childCategory);
				if(prd.getChild() != null) {
					getCategories(prd.getChild(), childCategory);
				}
			}
			else if("class Product.Product".equalsIgnoreCase(prd.getClass().toString())) {
				JMenuItem product1 = new JMenuItem(prd.getName());
				category.add(product1);
				menuItemList.add(product1);
			}

		}
	}
	
	public void showPanel(){
		ArrayList<IProduct> products = DataHandler.getProductAndCategoriesAsAObject();

	    menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        menuBar.setBounds(0, 31, 694, 22);
        add(menuBar);
        
    	
        for(IProduct prd: products) {
   		 	category1 = new JMenu(prd.getName());
            menuBar.add(category1);
            menuList.add(category1);
            if(prd.getChild()!= null) {	
            	getCategories(prd.getChild(), category1);
            }
            
		}
     /*   for(JMenu jm : menuList) {
        	System.out.println(jm);
        }
*/
	    mainFrameView.addNewPanel(this);

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
        getMainFrame().addNewPanel2(menuView);
        getMainFrame().addMenuPanel3(this);

	}

	public MainFrameView getMainFrame() {
		return mainFrameView;
	}


	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}
	
    public ArrayList<JMenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(ArrayList<JMenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public void addMouseListener2(ActionListener actionListener){
    	for(JMenuItem jm : menuItemList)
    		jm.addActionListener(actionListener);
    }
	
    public void addMouseListener(MouseAdapter mouseEvent){
    	for(JMenu jm : menuList)
    		jm.addMouseListener(mouseEvent);
    }
	
	
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
