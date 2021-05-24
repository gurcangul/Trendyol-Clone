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
import javax.swing.JList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class BuyerHomePageView extends JPanel implements Observer{

	private static final long serialVersionUID = -5277901207402632648L;
	private MainFrameView mainFrameView;
	private MenuViewForBuyer menuView;
	private BuyerHomePageView homePageView;
	private User user;
    JScrollPane scrollPane;
    JList<String> jFavoriteList;
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

        //scrollPane = new JScrollPane();
       // scrollPane.setBounds(10, 76, 740, 214);
        //add(scrollPane);

        //jFavoriteList = new JList<>();
        //scrollPane.setViewportView(jFavoriteList);
        //showLists();
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

	    mainFrameView.addNewPanel(this);

		this.setMainFrame(mainFrameView);  
        getMainFrame().addNewPanel2(menuView);
        getMainFrame().addMenuPanel3(this);

	}
	
   /* private void showLists() {
		ArrayList<IProduct> products = DataHandler.getProductAndCategoriesAsAObject();
		//ArrayList<IProduct> productList  =new ArrayList<IProduct>();
        List<IProduct> productList = new ArrayList();
        productList.addAll(user.getFavoriteList());
        productList.addAll(products);
        String[]productListsArr = new String[productList.size()];
        int i = 0;
        for(IProduct wl: productList){
        	productListsArr[i] = "<html><body>" + wl.getName() + "<br>" + " " + "<br>" + "</span></body></html>}";
            i++;
        }
        jFavoriteList.setListData(productListsArr);
    }*/
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
	
	
    @Override
    public void update(Observable o, Object arg) {
        user = (User) o;
       // showLists();
    }
}