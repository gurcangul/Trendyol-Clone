package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Observer.Observer;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class LoginView extends JPanel implements Observer{
    private MainFrameView mainFrameView;
    private BeforeLoginView beforeLoginView;
	private static final long serialVersionUID = 1L;
	private JTextField userName;
	private JPasswordField password;
	private MenuPanel menuPanel;
	JButton login;
	/**
	 * Create the panel.
	 */
	
	
	public LoginView(MainFrameView mainFrameView) {
		this.setMainFrame(mainFrameView);        
        new JPanel(new GridLayout(3, 1));
        setLayout(null);
        
        userName = new JTextField();
        userName.setBounds(222, 182, 96, 19);
        add(userName);
        userName.setColumns(10);
        

        
        JLabel userName = new JLabel("User Name:");
        userName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        userName.setBounds(149, 184, 63, 13);
        add(userName);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passwordLabel.setBounds(356, 184, 63, 13);
        add(passwordLabel);
        
        password = new JPasswordField();
        password.setBounds(424, 182, 108, 19);
        add(password);

        
        JButton back = new JButton("BACK");//this is go back button
        back.setIcon(new ImageIcon("\src\\back.png"));
        back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		beforeLoginView =  new BeforeLoginView(mainFrameView);
        		mainFrameView.addNewPanel(beforeLoginView);
        		
        	}
        });
        back.setFont(new Font("Tahoma", Font.PLAIN, 14));
        back.setBounds(273, 301, 154, 35);
        add(back);
        
        login = new JButton("Login");
        /*Login.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		menuPanel =  new MenuPanel(mainFrame);
        		mainFrame.addNewPanel(menuPanel);
        	}
        });*/
        login.setBounds(295, 233, 85, 21);
        add(login);               
	}
	public void setVisible() {
		mainFrameView.setVisible(true);
	}
	  
	public MainFrameView getMainFrame() {
		return mainFrameView;
	}

	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}

	public BeforeLoginView getBeforeLoginPanel() {
		return beforeLoginView;
	}

	public void setBeforeLoginPanel(BeforeLoginView beforeLoginView) {
		this.beforeLoginView = beforeLoginView;
	}
	
	
	/*public void passwordCheck(){
		JLabel lblNewLabel2 = new JLabel("Wrong! Please try again!");
    }*/
	
	public void allActionPerformed(ActionListener actionListener, JButton button ){
        if(button.getText().equals("login"))
        	button.addActionListener(actionListener);
    }
	public void allActionListener(ActionListener actionListener ){

    }
	
    public void addLoginActionListener(ActionListener actionListener){
    	login.addActionListener(actionListener);

    }
    
    public JTextField getUserName() {
        return userName;
    }

    public JPasswordField getPassword() {
        return password;
    }

	@Override
	public void update(Object arg) {//for update the panel 
		// TODO Auto-generated method stub
		
	}
    

}    
