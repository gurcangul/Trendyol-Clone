package GUI;

import Product.IProduct;
import User.User;
import FileIO.DataHandler;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.JPanel;


public class BuyerHomePageView extends JPanel implements Observer{

	private static final long serialVersionUID = -5277901207402632648L;
	private MainFrameView mainFrameView;
	private MenuViewForBuyer menuView;
	private BuyerHomePageView homePageView;
	private User user;

	JButton viewAllUsersButton;
	JButton viewCategoriesButton;
	JButton myProfileButton; JButton seeAllCollectionButton; JButton trendsButton;JButton btn;
	List<JButton> buttonList;
	ArrayList<JMenu> menuList = new ArrayList<JMenu>(); 
	ArrayList<JMenuItem> menuItemList = new ArrayList<JMenuItem>();
	//static ArrayList<IProduct> favoriesList = new ArrayList<IProduct>();
	JMenu category2,category1,category3;JMenuItem category2Child1, category1Child1 ;
	JMenuBar menuBar;JMenuItem category2Child2;
	JMenuItem helpContents;  JMenu help;  JMenuItem sendFeedback; 
	JPanel addProductPanel;
	JButton addFavoriButton;
	JButton addShoppingCartButton;
    JMenuItem lastCategory;
	
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BuyerHomePageView(MainFrameView mainFrameView,MenuViewForBuyer menuView) {
		this.menuView=menuView;
		this.setMainFrame(mainFrameView);        
		new JPanel(new GridLayout(3, 1));
        setLayout(null);
        showPanel();	
        setUser(menuView.getUser());
        addProductPanel = new JPanel();
        addProductPanel.setBounds(83, 196, 550, 150);
        addProductPanel.setLayout(null);
	}

	public void getCategories(ArrayList<IProduct> product, JMenu category) {
		for(IProduct prd: product) {
			if("class Product.Category".equalsIgnoreCase(prd.getClass().toString())) {
				if(prd.getChild().size() != 0) {
					if(prd.getChild().get(0).getClass().toString().equalsIgnoreCase("class Product.Product")) {
						lastCategory = new JMenuItem(prd.getName());
						category.add(lastCategory);
						menuItemList.add(lastCategory);
						break;
					}
					else {
						JMenu childCategory = new JMenu(prd.getName());
						category.add(childCategory);
						menuList.add(childCategory);
						getCategories(prd.getChild(), childCategory);
					}
				}
				else {
					lastCategory = new JMenuItem(prd.getName());
					category.add(lastCategory);
					menuItemList.add(lastCategory);
				}
			}
		}		
	}
	public void helperFinfProducts(ArrayList<IProduct> products, String productName, ArrayList<IProduct> productList) {
		for(IProduct prd: products) {
			if(prd.getName().equalsIgnoreCase(productName))
			{
				if(prd.getChild().size() != 0) {
					for(IProduct product: prd.getChild())
					{
						productList.add(product);
					}
				}
			}
			else {
				if(prd.getChild()!= null) {	
					helperFinfProducts(prd.getChild(), productName, productList);
	            }
			}
		}
	}
	public ArrayList<IProduct> findProducts(String productName) {
		ArrayList<IProduct> products = DataHandler.getProductAndCategoriesAsAObject();
		ArrayList<IProduct> productList  =new ArrayList<IProduct>();
		for(IProduct prd: products) {
			if(prd.getName().equalsIgnoreCase(productName))
			{
				if(prd.getChild().size() != 0) {
					for(IProduct product: prd.getChild())
					{
						productList.add(product);
					}
				}
			}
			else {
				if(prd.getChild()!= null) {	
					helperFinfProducts(prd.getChild(), productName, productList);
	            }
			}    
		}
		return productList;
	}
		
    static int i;
    static ArrayList<IProduct> productList;
	public void ViewProductPanel(int size, String productName) {     
		productList = findProducts(productName);
		//System.out.println(productList);
        JPanel panel = new JPanel();
        panel.setBounds(20, 58, 694, 385);
        add(panel);
        panel.setLayout(null);

        int x = 24; 
        int y = 63;
        int width = 220;
        int height = 100;
        int buttonY = y+height;
        int buttonHeight = 21;
        for(i=0; i<size; i++) {
        	if(x < (694 - width)) {
		        JTextPane textPane = new JTextPane();
		        textPane.setBounds(x, y, width, height);
		        textPane.setText(productList.get(i).viewProductByBuyer());
		        add(textPane);
		        addFavoriButton = new JButton("Add Favories");
		        addFavoriButton.setBounds(x, buttonY, 220, buttonHeight);
		        panel.add(addFavoriButton);
		        addFavoriButton.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//System.out.println("calistim" + i + " user = " + getUser().getUserName());
        				boolean flag = false;
        				productList = findProducts(productName);
        				if(getUser().getFavoriteList().size() != 0) {
	        				for(IProduct product : getUser().getFavoriteList()) {
	        					if(product.getName().equalsIgnoreCase(productList.get(i).getName())) {
	        						flag = true;
	        					}
	        				}
	        				
        				}
        				if(!flag) {
        					getUser().addProductToFavoriteList(productList.get(i));
        					System.out.println("ben aynur " + productList.get(i));
        				}
        				
        			}
		        });
		       // System.out.println(getUser().getFavoriList().toString());
		        addShoppingCartButton = new JButton("Add Shopping Cart");
		        addShoppingCartButton.setBounds(x, buttonY+buttonHeight+5 , 220, buttonHeight);
		        panel.add(addShoppingCartButton);
		        addShoppingCartButton.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				//System.out.println("calistim" + i + " user = " + getUser().getUserName());
        				boolean flag = false;
        				productList = findProducts(productName);
        				if(getUser().getFavoriteList().size() != 0) {
	        				for(IProduct product : getUser().getFavoriteList()) {
	        					if(product.getName().equalsIgnoreCase(productList.get(i).getName())) {
	        						flag = true;
	        					}
	        				}
	        				
        				}
        				if(!flag) {
        					getUser().addProductToShoppingCart(productList.get(i), 1);
        					//System.out.println("ben aynur " + productList.get(i));
        				}
        				
        			}
		        });
		        x = width + x + 15;
        	}
        	else {
        		y = buttonY * 3 + 15;
        		JTextPane textPane = new JTextPane();
		        textPane.setBounds(x, y, width, height);
		        add(textPane);
        	}
        }
        i = 0;
        menuBar.setVisible(true);        
        getMainFrame().addNewPanel2(menuView);
        getMainFrame().addMenuPanel3(this);
}
	
	public void showPanel(){
		ArrayList<IProduct> products = DataHandler.getProductAndCategoriesAsAObject();

	    menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        menuBar.setBounds(20, 31, 694, 22);
        menuBar.setVisible(true);
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

      /*  viewCategoriesButton = new JButton("View Categories");
        viewCategoriesButton.setBounds(31, 93, 202, 21);
        add(viewCategoriesButton);
        
        seeAllCollectionButton = new JButton("See All Collections");
        seeAllCollectionButton.setBounds(243, 93, 207, 21);
        add(seeAllCollectionButton);
        
        myProfileButton = new JButton("My Profile");
        myProfileButton.setBounds(460, 93, 195, 21);
        add(myProfileButton);
        
       
        trendsButton = new JButton("Sale Products");
        trendsButton.setIcon(new ImageIcon("C:\\Users\\Gurcan\\eclipse-workspace\\G12_CENG431_HW3-v1\\src\\trends.png"));
        trendsButton.setBounds(289, 178, 202, 21);
        add(trendsButton);
        
        viewAllUsersButton = new JButton("View All Users");
        viewAllUsersButton.setBounds(243, 141, 207, 21);
        add(viewAllUsersButton);
        */
		this.setMainFrame(mainFrameView);  
        getMainFrame().addNewPanel2(menuView);
        getMainFrame().addMenuPanel3(this);
        
       
        
    /*    JTextPane txtpnKjslkhjk = new JTextPane();
        txtpnKjslkhjk.setBounds(203, 233, 159, 158);
        add(txtpnKjslkhjk);
*/


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
	
	
  /*  public void addViewAllUsersButtonActionListener(ActionListener actionListener){
    	viewAllUsersButton.addActionListener(actionListener);
    }
    public void addCreateCollectionButtonActionListener(ActionListener actionListener){
    	viewCategoriesButton.addActionListener(actionListener);
    }
    public void addMyProfileButtonActionListener(ActionListener actionListener){
    	myProfileButton.addActionListener(actionListener);
    }
    public void addSeeAllCollectionButtonActionListener(ActionListener actionListener){
    	seeAllCollectionButton.addActionListener(actionListener);
    }
    public void addTrendsButtonActionListener(ActionListener actionListener){
    	trendsButton.addActionListener(actionListener);
    }*/

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}