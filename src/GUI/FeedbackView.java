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
    private MainFrameView mainFrameView;
    private JButton btnNewButton;
    private BeforeLoginView beforeLoginView;
    private JButton btnNewButton_1;
    private JTextField textField;
    private JTextField textField_1;

    public FeedbackView(MainFrameView mainFrameView) {
        this.setMainFrame(mainFrameView);

        new JPanel(new GridLayout(3, 1));       
        setSize(760, 460);

        mainFrameView.addNewPanel(this);
		setLayout(null);
        
		Label label = new Label("User Name");
		label.setBounds(79, 71, 66, 21);
		add(label);
		
		TextField textField = new TextField();
		textField.setBounds(172, 71, 96, 21);
		add(textField);
		textField.setText("name");
		textField.setEditable(false);
		textField.setEnabled(false);
		
		Label label_1 = new Label("Message");
		label_1.setBounds(79, 153, 56, 21);
		add(label_1);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(172, 171, 440, 150);
		add(textArea);
		
		Label label_1_1 = new Label("Subject");
		label_1_1.setBounds(79, 108, 49, 21);
		add(label_1_1);
		
		final Choice choice = new Choice();
		choice.setBounds(172, 111, 96, 18);
		add(choice);
		
		choice.add("Item 1");  
		choice.add("Item 2");  
		choice.add("Item 3");
        
        JButton btnNewButton = new JButton("Send");
        btnNewButton.setBounds(346, 344, 55, 21);
        add(btnNewButton, "cell 0 3");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(check(textArea))
        		{
	        		String toBewrite = label.getText() + "," + textArea.getText();
		            try {
						writeToFile(toBewrite);
					} catch (IOException e1) {
					}
		            JOptionPane.showMessageDialog(null, "Your message is submitted. Thank you! ");
		            textArea.setText("");
        		}
        		
        	}
        });
        add(btnNewButton);
		
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
