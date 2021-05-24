package GUI;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import FileIO.DataHandler;
import Product.IProduct;
import User.User;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionEvent;

public class SellerHomePageView extends JPanel implements Observer {

	private static final long serialVersionUID = -5277901207402632648L;
	private MainFrameView mainFrameView;
	private MenuViewForSeller menuView;
	private SellerHomePageView homePageView;
	private User user;
	
	JMenuBar menuBar;
	JButton updateStok;
	JButton addProduct;
	JButton myProfileButton; JButton seeAllProductsButton; JButton saleProducts;JButton btn;
	List<JButton> buttonList;
	ArrayList<JMenu> menuList = new ArrayList<JMenu>();;
	ArrayList<JMenuItem> menuItemList = new ArrayList<JMenuItem>();
	JMenu category2,category1,category3;JMenuItem category2Child1, category1Child1 ;JMenuItem category2Child2;
	JMenuItem helpContents;  JMenu help;  JMenuItem sendFeedback; 
    JPanel addProductPanel;
    JPanel seeAllProductsPanel;
    JTextField productNameTextField;
    JTextField productPriceTextField;
    JMenuItem lastCategory;
    private JMenuBar menuBar_1;
	
	public SellerHomePageView(MainFrameView mainFrameView,MenuViewForSeller menuView) {
		this.menuView=menuView;
		this.setMainFrame(mainFrameView);        
		new JPanel(new GridLayout(3, 1));
        setLayout(null);
        showPanel();
        
        addProductPanel = new JPanel();
        addProductPanel.setBounds(83, 196, 550, 150);
        addProductPanel.setLayout(null);
	 
        lastCategory = new JMenuItem();
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
			/*else if("class Product.Product".equalsIgnoreCase(prd.getClass().toString())) {
				JMenuItem product1 = new JMenuItem(prd.getName());
				//category.add(product1);
				menuItemList.add(category);
			}*/

		}
	}
	public void showAddProductPanel() {
			addProductPanel.setVisible(true);
	        add(addProductPanel);
	        //addProductPanel.set
	        
	        menuBar.setVisible(true);
	        
	        JLabel productNameLabel = new JLabel("Product Name");
	        productNameLabel.setBounds(10, 20, 82, 13);
	        addProductPanel.add(productNameLabel);
	        
	        productNameTextField = new JTextField();
	        productNameTextField.setBounds(95, 17, 96, 19);
	        addProductPanel.add(productNameTextField);
	        productNameTextField.setColumns(10);
	        
	        JLabel productPriceLabel = new JLabel("Product Price");
	        productPriceLabel.setBounds(10, 49, 82, 13);
	        addProductPanel.add(productPriceLabel);
	        
	        productPriceTextField = new JTextField();
	        productPriceTextField.setColumns(10);
	        productPriceTextField.setBounds(95, 46, 96, 19);
	        addProductPanel.add(productPriceTextField);
	        
	        JComboBox categoriesComboBox = new JComboBox();
	        categoriesComboBox.setModel(new DefaultComboBoxModel(new String[] {"Electronic", "Clothing"}));
	        categoriesComboBox.setBounds(95, 72, 96, 21);
	        addProductPanel.add(categoriesComboBox);
	        
	        JLabel categoriesLabel = new JLabel("Categories");
	        categoriesLabel.setBounds(10, 76, 82, 13);
	        addProductPanel.add(categoriesLabel);
	        
	        JButton addProductButton = new JButton("Add Product");
	        addProductButton.setBounds(57, 125, 104, 21);
	        addProductPanel.add(addProductButton);
	        
	        addProductButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		System.out.println("Umarım artık beni üzmezsin Gürcan Gül");
	        	}
	        });
	        
	        
	        
	        JLabel productStokLabel = new JLabel("Product Stok");
	        productStokLabel.setBounds(10, 102, 82, 13);
	        addProductPanel.add(productStokLabel);
	        
	        JSpinner stokSpinner = new JSpinner();
	        stokSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
	        stokSpinner.setBounds(95, 95, 52, 20);
	        addProductPanel.add(stokSpinner);
	        
	        
	        getMainFrame().addNewPanel2(menuView);
	        getMainFrame().addMenuPanel3(this);
	}
	public void showPanel(){

        
    	// combobox a ekle
       /* for(IProduct prd: products) {
   		 	category1 = new JMenu(prd.getName());
            menuBar.add(category1);
            menuList.add(category1);
            if(prd.getChild()!= null) {	
            	getCategories(prd.getChild(), category1);
            }
            
		}*/
     /*   for(JMenu jm : menuList) {
        	System.out.println(jm);
        }
        
     
*/
		menuBar = new JMenuBar();
	    menuBar.setBackground(Color.WHITE);
	    menuBar.setBounds(85, 185, 550, 22);
	    menuBar.setVisible(false);
	    add(menuBar);
        
		ArrayList<IProduct> products = DataHandler.getProductAndCategoriesAsAObject();
        for(IProduct prd: products) {
   		 	category1 = new JMenu(prd.getName());
            menuBar.add(category1);
            menuList.add(category1);
            if(prd.getChild()!= null) {	
            	getCategories(prd.getChild(), category1);
            }
            
		}
		
	    mainFrameView.addNewPanel(this);

        addProduct = new JButton("Add Product");
 
        addProduct.setBounds(42, 41, 202, 21);
        add(addProduct);
        
        seeAllProductsButton = new JButton("See All Products");
        seeAllProductsButton.setBounds(254, 41, 207, 21);
        add(seeAllProductsButton);
        
        myProfileButton = new JButton("My Profile");
        myProfileButton.setBounds(264, 95, 195, 21);
        add(myProfileButton);
        
       
        saleProducts = new JButton("Sale Products");
        saleProducts.setIcon(new ImageIcon("C:\\Users\\Gurcan\\eclipse-workspace\\G12_CENG431_HW3-v1\\src\\trends.png"));
        saleProducts.setBounds(309, 152, 120, 21);
        add(saleProducts);
        
        updateStok = new JButton("Update Stok");
        updateStok.setBounds(472, 41, 207, 21);
        add(updateStok);
        
		this.setMainFrame(mainFrameView);  
        getMainFrame().addNewPanel2(menuView);
        getMainFrame().addMenuPanel3(this);
        

        
 
        /*
        JMenuBar menuBar = new VerticalMenuBar();
        menuBar.setBounds(94, 250, 101, 22);
        add(menuBar);
        
       */
        
      /*  seeAllProductsPanel = new JPanel();
        seeAllProductsPanel.setBounds(83, 196, 550, 150);
        add(seeAllProductsPanel);
*/
	}

	
	public JPanel getAddProductPanel() {
		return addProductPanel;
	}

	public void setAddProductPanel(JPanel addProductPanel) {
		this.addProductPanel = addProductPanel;
	}

	public JPanel getSeeAllProductsPanel() {
		return seeAllProductsPanel;
	}

	public void setSeeAllProductsPanel(JPanel seeAllProductsPanel) {
		this.seeAllProductsPanel = seeAllProductsPanel;
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

	public void addMenuItemListener(ActionListener actionListener){
    	for(JMenuItem jm : menuItemList)
    		jm.addActionListener(actionListener);
    }
	
    public void addMouseListener(MouseAdapter mouseEvent){
    	for(JMenu jm : menuList)
    		jm.addMouseListener(mouseEvent);
    }
	
	
    public void addUpdateStokButtonActionListener(ActionListener actionListener){
    	updateStok.addActionListener(actionListener);
    }
    public void addProductButtonActionListener(ActionListener actionListener){
    	addProduct.addActionListener(actionListener);  	
    }
    public void addMyProfileButtonActionListener(ActionListener actionListener){
    	myProfileButton.addActionListener(actionListener);
    }
    public void addSeeAllProductsButtonActionListener(ActionListener actionListener){
    	seeAllProductsButton.addActionListener(actionListener);
    }
    public void addSaleProductsButtonActionListener(ActionListener actionListener){
    	saleProducts.addActionListener(actionListener);
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
