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
import java.awt.event.MouseListener;
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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Box;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;

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
	ArrayList<JMenu> menuList = new ArrayList<JMenu>();;
	JMenu category2,category1,category3;JMenuItem category2Child1, category1Child1 ;
	JMenuBar menuBar;JMenuItem category2Child2;
	JMenuItem helpContents;  JMenu help;  JMenuItem sendFeedback; 
	private JTextField textField;
	private JMenuItem category1Child2;
	private JMenuItem category1Child3;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mnNewMenu_2;
	private JMenu mnNewMenu_3;
	public HomePageView(MainFrameView mainFrameView,MenuView menuView) {
		this.menuView=menuView;
		this.setMainFrame(mainFrameView);        
		new JPanel(new GridLayout(3, 1));
        setLayout(null);
        showPanel();		
	}

	public void getCategories(ArrayList<IProduct> product, JMenu category) {
		for(IProduct prd: product) {
			if("class Product.Category".equalsIgnoreCase(prd.getClass().toString())) {
				//System.out.println(prd.getClass().toString());
				JMenu childCategory = new JMenu(prd.getName());
				System.out.println(prd.getName());
				category.add(childCategory);
				menuList.add(category);
				if(prd.getChild() != null) {
					getCategories(prd.getChild(), childCategory);
				}
			}
			/*else if("class Product.Product".equalsIgnoreCase(prd.getClass().toString())) {
				JMenuItem product1 = new JMenuItem(prd.getName());
				category.add(product1);
			}*/

		}
	}
	
	public void showPanel(){
		ArrayList<IProduct> products = DataHandler.getProductAndCategoriesAsAObject();

	    menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        menuBar.setBounds(0, 31, 694, 22);
        add(menuBar);
        
      


    	System.out.println(products.size());
    	
        for(IProduct prd: products) {
			System.out.println("olustuuu "+ prd.getName());
   		 	category1 = new JMenu(prd.getName());
            menuBar.add(category1);
            menuList.add(category1);
            System.out.println(menuList.get(0).getText());
            if(prd.getChild()!= null) {	
            	getCategories(prd.getChild(), category1);
            }
            
		}

       /* mnNewMenu_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		for(JMenu jm : menuList) {
        			//if()
        		}
        	}
        });*/
        mnNewMenu_1 = new JMenu("aynur");
        /*mnNewMenu_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });*/
       /* mnNewMenu_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        	}
        });*/
        menuBar.add(mnNewMenu_1);
        
        mnNewMenu_2 = new JMenuItem("New menu Item");
        mnNewMenu_1.add(mnNewMenu_2);
        
        mnNewMenu_3 = new JMenu("New menu");
       /* mnNewMenu_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null, "Menu Action Listener ");  
        	}
        });*/
        menuBar.add(mnNewMenu_3);
        
       /* for(JMenu jm : menuList) {
        	 System.out.println("Ben çalıştım " + jm.getText());
             jm.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
             		System.out.println("Ben çalıştım2 " + jm.getText());
             	}
             });
             //menuBar.add(mnNewMenu);
        }*/
       

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
        //getMainFrame().addNewPanel2(this);
        getMainFrame().addNewPanel2(menuView);
        getMainFrame().addMenuPanel3(this);
       // DataHandler.getProductAndCategories().get(0).getChild();
        String s="";
        

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
