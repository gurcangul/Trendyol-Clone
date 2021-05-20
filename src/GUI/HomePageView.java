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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class HomePageView extends JPanel implements Observer{

	private static final long serialVersionUID = -5277901207402632648L;
	MainFrameView mainFrameView;

	  
	public HomePageView(MainFrameView mainFrameView) {
		JPanel jP=  new JPanel(new GridLayout(3, 1));
        setLayout(null);
        
        JButton createCollectionButton = new JButton("Create Collection");
        createCollectionButton.setBounds(27, 63, 202, 21);
        add(createCollectionButton);
        
        JButton seeAllCollectionButton = new JButton("See All Collections");
        seeAllCollectionButton.setBounds(239, 63, 207, 21);
        add(seeAllCollectionButton);
        
        JButton myProfileButton = new JButton("My Profile");
        myProfileButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MyProfileView myProfileView = new MyProfileView(mainFrameView);
        		mainFrameView.addMenuPanel(myProfileView);
        	}
        });
        myProfileButton.setBounds(456, 63, 195, 21);
        add(myProfileButton);
        
        JButton trendsButton = new JButton("Trends");
        trendsButton.setIcon(new ImageIcon("C:\\Users\\Gurcan\\eclipse-workspace\\G12_CENG431_HW3-v1\\src\\trends.png"));
        trendsButton.setBounds(285, 148, 109, 21);
        add(trendsButton);
        
        JButton viewAllUsersButton = new JButton("View All Users");
        viewAllUsersButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        viewAllUsersButton.setBounds(239, 111, 207, 21);
        add(viewAllUsersButton);
		this.setMainFrame(mainFrameView);        	
		
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


	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}
}
