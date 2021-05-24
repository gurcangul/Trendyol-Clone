package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;

public class FeedbackView extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
    MainFrameView mainFrameView;
    JButton btnNewButton;
    BeforeLoginView beforeLoginView;
    JButton btnNewButton_1;
    JTextField textField;
    JTextField textField_1;
    JPanel menuView;
    MenuViewForBuyer menuViewForBuyer;
    MenuViewForSeller menuViewForSeller;
    MenuViewForAdmin menuViewForAdmin;
    private String email;

    public FeedbackView(MainFrameView mainFrameView, JPanel menuView) {
        this.setMainFrame(mainFrameView);
        this.menuView=menuView;
        this.setMainFrame(mainFrameView);  

		setSize(760, 460);
        new JPanel(new GridLayout(3, 1));
        setLayout(null);
        
		Label userNameLabel = new Label("User Name");
		userNameLabel.setBounds(79, 61, 86, 21);
		add(userNameLabel);
		
		Label email = new Label("E-Mail");
		email.setBounds(79, 93, 86, 21);
		add(email);
		
		TextField textField = new TextField();
		textField.setBounds(199, 61, 96, 21);
		add(textField);
		String name="";
		

		if(menuView instanceof MenuViewForBuyer) {
        	this.menuViewForBuyer=(MenuViewForBuyer) this.menuView;
        	name=menuViewForBuyer.getUser().getUserName();
        	setEmail(menuViewForBuyer.getUser().getEmail());
		}
        else if(menuView instanceof MenuViewForSeller) {
        	this.menuViewForSeller=(MenuViewForSeller) this.menuView;
        	name=menuViewForSeller.getUser().getUserName();

        	}
        else if(menuView instanceof MenuViewForAdmin) {
        	this.menuViewForAdmin=(MenuViewForAdmin) this.menuView;
        	name=menuViewForAdmin.getUser().getUserName();
        	setEmail(menuViewForBuyer.getUser().getEmail());

        }
        this.setMainFrame(mainFrameView);  
		
		
		textField.setText(name);
		textField.setEditable(false);
		textField.setEnabled(false);
		
		Label messageLabel = new Label("Message");
		messageLabel.setBounds(79, 153, 86, 21);
		add(messageLabel);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(199, 170, 440, 150);
		add(textArea);
		
		Label subjectLabel = new Label("Subject");
		subjectLabel.setBounds(79, 126, 73, 21);
		add(subjectLabel);
		
		final Choice choice = new Choice();
		choice.setBounds(199, 129, 96, 18);
		add(choice);
		
		choice.add("claim");  	  
		choice.add("complaint");  
		choice.add("proposal");
        
        JButton sendButton = new JButton("Send");
        sendButton.setBounds(346, 344, 65, 21);
        add(sendButton, "cell 0 3");
        sendButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(check(textArea)){
	        		String toBewrite = textField.getText() + ","+getEmail()+","+choice.getSelectedItem()+","+  textArea.getText();
		            try {
						writeToFile(toBewrite);
					} catch (IOException e1) {
					}
		            JOptionPane.showMessageDialog(null, "Your message is submitted. Thank you! ");
		            textArea.setText("");
        		}
        		
        	}
        });
        add(sendButton);
        
        TextField emailField = new TextField();
        emailField.setText(getEmail());
        emailField.setEnabled(false);
        emailField.setEditable(false);
        emailField.setBounds(199, 93, 269, 21);
        add(emailField);
        getMainFrame().addNewPanel2(this.menuView);
        getMainFrame().addMenuPanel3(this);    
        
		
	}

	public MainFrameView getMainFrame() {
		return mainFrameView;
	}

	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}  
	
	private boolean check(TextArea textArea) {
	        if (textArea.getText().length() <4 ) {
	        	JOptionPane.showMessageDialog(null, "You cannot send messages of this length ");
				return false;
	        }
	        else return true;
	 }	
	private void writeToFile(String list) throws IOException{
		File f = new File("feedback.txt");
		FileWriter fw = new FileWriter(f,true);
		try
		{
			BufferedWriter bw = new BufferedWriter(fw);
		    bw.newLine();
		    bw.write(list);
		    bw.flush();
		    bw.close();
        }
        catch(Exception e){
        }
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}