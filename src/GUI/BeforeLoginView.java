package GUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Contollers.LoginController;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class BeforeLoginView extends JPanel    {
    MainFrameView mainFrameView;
    JButton btnNewButton;
    JLabel lblNewLabel;
    WelcomeView welcomeView;
    LoginView loginView;
    JButton loginButton;
    BeforeLoginView beforeLoginView;
    JButton signInButton;
    JButton back;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public BeforeLoginView(MainFrameView mainFrameView) {
		this.mainFrameView=mainFrameView;        
        showPanel();
	}
    public void showPanel(){
		setSize(760, 460);
        new JPanel(new GridLayout(3, 1));
        setLayout(null);
        
        loginButton = new JButton("Log In");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        loginButton.setIcon(new ImageIcon(BeforeLoginView.class.getResource("/login.png")));
        loginButton.setBounds(286, 115, 154, 35);
        add(loginButton);
        
        signInButton = new JButton("Sign In");
        signInButton.setIcon(new ImageIcon(BeforeLoginView.class.getResource("/signin.png")));
        signInButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        signInButton.setBounds(286, 176, 154, 35);
        add(signInButton);
        
        back = new JButton("Back");
        back.setIcon(new ImageIcon(BeforeLoginView.class.getResource("/back.png")));
        back.setFont(new Font("Tahoma", Font.PLAIN, 14));
        back.setBounds(286, 235, 154, 35);
        add(back);
        mainFrameView.addNewPanel(this);
    
    }
    
    
	public MainFrameView getMainFrame() {
		return mainFrameView;
	}

	
		
	
	public void addBackButton(ActionListener actionListener) {
		back.addActionListener(actionListener);
		
	}	
	public void addSignInButton(ActionListener actionListener) {
		signInButton.addActionListener(actionListener);
		
	}
	public void addLoginButton(ActionListener actionListener) {
		loginButton.addActionListener(actionListener);
		
	}

}
