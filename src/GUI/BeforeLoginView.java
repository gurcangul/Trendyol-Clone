package GUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Contollers.LoginController;
import Models.UserModel;
import Observer.Observer;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class BeforeLoginView extends JPanel implements Observer  {
    private MainFrameView mainFrameView;
    private JButton btnNewButton;
    private JLabel lblNewLabel;
    private WelcomePanel welcomePanel;
    private LoginView loginView;
    BeforeLoginView beforeLoginView;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public BeforeLoginView(MainFrameView mainFrameView) {
		this.setMainFrame(mainFrameView);        
		setSize(760, 460);
        new JPanel(new GridLayout(3, 1));
        setLayout(null);
        
        JButton btnNewButton_1 = new JButton("Log In");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {//it goes to login page
        		//do
        		loginView =  new LoginView(mainFrameView);
        		mainFrameView.addNewPanel(loginView);
        		UserModel userModel = new UserModel();
                LoginController loginController = new LoginController(loginView, beforeLoginView, userModel,mainFrameView);//panel checker
                loginController.showLoginPanel();

        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(286, 115, 154, 35);
        add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Sign In");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null, "This is not avaible for now! ");

        		
        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2.setBounds(286, 176, 154, 35);
        add(btnNewButton_2);
        
        JButton btnNewButton_2_1 = new JButton("");
        btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\Gurcan\\eclipse-workspace\\G12_CENG431_HW3-v1\\src\\back.png"));
        btnNewButton_2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		welcomePanel =  new WelcomePanel(mainFrameView);
        		mainFrameView.addNewPanel(welcomePanel);
        		
        	}
        });
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2_1.setBounds(286, 235, 154, 35);
        add(btnNewButton_2_1);
	}

	public MainFrameView getMainFrame() {
		return mainFrameView;
	}

	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}

}
