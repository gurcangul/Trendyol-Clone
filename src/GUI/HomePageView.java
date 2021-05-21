package GUI;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Observer.Observer;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import FileIO.DataHandler;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.Box;
import javax.swing.JTextPane;

public class HomePageView extends JPanel implements Observer{

	private static final long serialVersionUID = -5277901207402632648L;
	private MainFrameView mainFrameView;
	private MenuView menuView;
	private HomePageView homePageView;
	JButton viewAllUsersButton;
	JButton createCollectionButton;
	JButton myProfileButton; JButton seeAllCollectionButton; JButton trendsButton;
	private JTextField textField;
	public HomePageView(MainFrameView mainFrameView,MenuView menuView) {
		this.menuView=menuView;
		this.setMainFrame(mainFrameView);        
		new JPanel(new GridLayout(3, 1));
        setLayout(null);
        showPanel();		
	}

	public void showPanel(){
        createCollectionButton = new JButton("Create Collection");
        createCollectionButton.setBounds(27, 63, 202, 21);
        add(createCollectionButton);
        
        seeAllCollectionButton = new JButton("See All Collections");
        seeAllCollectionButton.setBounds(239, 63, 207, 21);
        add(seeAllCollectionButton);
        
        myProfileButton = new JButton("My Profile");
        /*myProfileButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MyProfileView myProfileView = new MyProfileView(mainFrameView);
        		mainFrameView.addMenuPanel(myProfileView);
        	}
        });*/
        myProfileButton.setBounds(456, 63, 195, 21);
        add(myProfileButton);
        
       
        trendsButton = new JButton("Trends");
        trendsButton.setIcon(new ImageIcon("C:\\Users\\Gurcan\\eclipse-workspace\\G12_CENG431_HW3-v1\\src\\trends.png"));
        trendsButton.setBounds(285, 148, 109, 21);
        add(trendsButton);
        
        viewAllUsersButton = new JButton("View All Users");
        /*viewAllUsersButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });*/
        viewAllUsersButton.setBounds(239, 111, 207, 21);
        add(viewAllUsersButton);
		this.setMainFrame(mainFrameView);  
        //getMainFrame().addNewPanel2(this);
        getMainFrame().addNewPanel2(menuView);
        getMainFrame().addMenuPanel3(this);
        DataHandler.getProductAndCategories().get(0).getChild();
        String s="";
        //for(int i = 0;i<2;i++) {
        	s=DataHandler.getProductAndCategories().get(0).getChild().get(0).getName()+"  " +DataHandler.getProductAndCategories().get(0).getChild().get(1).getName();
        	/*s+=DataHandler.getProductAndCategories().get(0).getChild().get(0).getName()+"\n";
        	s+=DataHandler.getProductAndCategories().get(0).getChild().get(1).getName();*/
        	/*+"\n \n" +DataHandler.getProductAndCategories().get(0).getChild().get(1).getName())*/

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
