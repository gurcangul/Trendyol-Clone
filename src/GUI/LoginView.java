package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;

public class LoginView extends JPanel implements Observer{
    private MainFrameView mainFrameView;
    private BeforeLoginView beforeLoginView;
	private static final long serialVersionUID = 1L;
	private JTextField userName;
	private JPasswordField password;
	private MenuViewForBuyer menuView;
	JButton login, back;

	
	public LoginView(MainFrameView mainFrameView) {
		this.setMainFrame(mainFrameView);        
        new JPanel(new GridLayout(3, 1));
        setLayout(null);
        showPanel();
	}	
    public void showPanel(){  
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

        
        back = new JButton("BACK");
        back.setIcon(new ImageIcon(BeforeLoginView.class.getResource("/back.png")));

        back.setFont(new Font("Tahoma", Font.PLAIN, 14));
        back.setBounds(273, 301, 154, 35);
        add(back);
        
        login = new JButton("Login");
        login.setBounds(295, 233, 85, 21);
        add(login);           
        mainFrameView.addNewPanel(this);
    
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
	
	public void allActionPerformed(ActionListener actionListener, JButton button ){
        if(button.getText().equals("login"))
        	button.addActionListener(actionListener);
    }
	public void allActionListener(ActionListener actionListener ){

    }
	
    public void addLoginActionListener(ActionListener actionListener){
    	login.addActionListener(actionListener);
    }
    public void addBackActionListener(ActionListener actionListener){
    	back.addActionListener(actionListener);
    }
    public JTextField getUserName() {
        return userName;
    }

    public JPasswordField getPassword() {
        return password;
    }


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
    

}    
