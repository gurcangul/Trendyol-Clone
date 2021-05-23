package GUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SignUpView extends JPanel implements Observer {
	
	
    private MainFrameView mainFrameView;
    private BeforeLoginView beforeLoginView;
	private static final long serialVersionUID = 1L;
	private JTextField userName;
	private JTextField email;
	private JComboBox comboBox;
	private JPasswordField password;
	private MenuViewForBuyer menuView;
	JButton signIn, back;
	
	
	public SignUpView(MainFrameView mainFrameView) {
		this.setMainFrame(mainFrameView);        
        new JPanel(new GridLayout(3, 1));
        setLayout(null);

        showPanel();
	}
	
	public void showPanel(){
	    
    	userName = new JTextField();
        userName.setBounds(222, 52, 158, 19);
        add(userName);
        userName.setColumns(10);
        email = new JTextField();
        email.setBounds(222, 90, 158, 19);
        add(email);
        email.setColumns(10);
        
        
        JLabel userName = new JLabel("User Name:");
        userName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        userName.setBounds(149, 54, 63, 13);
        add(userName);
        JLabel email = new JLabel("E-mail:");
        email.setFont(new Font("Tahoma", Font.PLAIN, 12));
        email.setBounds(149, 92, 63, 13);
        add(email);
        JLabel userType = new JLabel("User Type:");
        userType.setFont(new Font("Tahoma", Font.PLAIN, 12));
        userType.setBounds(149, 173, 63, 13);
        add(userType);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passwordLabel.setBounds(149, 132, 63, 13);
        add(passwordLabel);
        
        password = new JPasswordField();
        password.setBounds(222, 130, 158, 19);
        add(password);

        
        back = new JButton("BACK");//this is go back button
        back.setIcon(new ImageIcon(SignUpView.class.getResource("/back.png")));

        back.setFont(new Font("Tahoma", Font.PLAIN, 14));
        back.setBounds(561, 10, 113, 35);
        add(back);
        
        signIn = new JButton("Sign In");

        signIn.setBounds(222, 230, 107, 35);
        add(signIn);           
        mainFrameView.addNewPanel(this);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seller", "Buyer"}));
        comboBox.setToolTipText("");
        comboBox.setBounds(222, 171, 79, 19);
        add(comboBox);
    
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
        if(button.getText().equals("signIn"))
        	button.addActionListener(actionListener);
    }
	public void allActionListener(ActionListener actionListener ){

    }
	
    public void addSignInActionListener(ActionListener actionListener){
    	signIn.addActionListener(actionListener);
    }
    public void addBackActionListener(ActionListener actionListener){
    	back.addActionListener(actionListener);
    }
    public JTextField getUserName() {
        return userName;
    }
    
    public JComboBox getUserType() {
        return comboBox;
    }

    public JTextField getEmail() {
        return email;
    }
    public JPasswordField getPassword() {
        return password;
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
    
    
}
