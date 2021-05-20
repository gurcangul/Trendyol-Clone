package GUI;

import javax.swing.*;

import Observer.Observer;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FeedbackView extends JPanel implements Observer{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    MainFrameView mainFrameView;
    JButton btnNewButton;
    BeforeLoginView beforeLoginView;
    JButton btnNewButton_1;
    JTextField textField;
    JTextField textField_1;

    public FeedbackView(MainFrameView mainFrameView) {
        this.setMainFrame(mainFrameView);

        new JPanel(new GridLayout(3, 1));       
        setSize(760, 460);

        mainFrameView.addNewPanel(this);
		setLayout(null);
        
		Label userNameLabel = new Label("User Name");
		userNameLabel.setBounds(79, 71, 66, 21);
		add(userNameLabel);
		
		TextField textField = new TextField();
		textField.setBounds(172, 71, 96, 21);
		add(textField);
		textField.setText("name");
		textField.setEditable(false);
		textField.setEnabled(false);
		
		Label messageLabel = new Label("Message");
		messageLabel.setBounds(79, 153, 56, 21);
		add(messageLabel);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(172, 171, 440, 150);
		add(textArea);
		
		Label subjectLabel = new Label("Subject");
		subjectLabel.setBounds(79, 108, 49, 21);
		add(subjectLabel);
		
		final Choice choice = new Choice();
		choice.setBounds(172, 111, 96, 18);
		add(choice);
		
		choice.add("Item 1");  
		choice.add("Item 2");  
		choice.add("Item 3");
        
        JButton sendButton = new JButton("Send");
        sendButton.setBounds(346, 344, 55, 21);
        add(sendButton, "cell 0 3");
        sendButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(check(textArea))
        		{
	        		String toBewrite = userNameLabel.getText() + "," + textArea.getText();
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
	        	//You cannot send messages of this length
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
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}
}
