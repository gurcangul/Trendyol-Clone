package GUI;

import javax.swing.*;

import Contollers.LoginController;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;

public class WelcomeView extends JPanel implements Observer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    MainFrameView mainFrameView;
    JButton enterButton;
    JLabel logo;
    JButton aboutButton;

    public WelcomeView(MainFrameView mainFrameView) {
        this.mainFrameView=mainFrameView;

        showPanel();
    }
    public void showPanel(){

        new JPanel(new GridLayout(3, 1));       
        setSize(760, 460);
        setLayout(null);

        mainFrameView.addNewPanel(this);
        
        enterButton = new JButton("ENTER");
        enterButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

        enterButton.setBounds(293, 263, 110, 21);
        add(enterButton);
        
        logo = new JLabel("");
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        
        logo.setIcon(new ImageIcon("C:\\Users\\Gurcan\\eclipse-workspace\\G12_CENG431_HW3-v1\\src\\logo.png"));
        logo.setBounds(292, 143, 110, 113);
        add(logo);
        
        JLabel lblNewLabel_1 = new JLabel("Welcome to the Outfit Rating Platform");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(212, 84, 303, 36);
        add(lblNewLabel_1);
        
        aboutButton = new JButton("About");
        aboutButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        /*btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null, "Copyright© 2021 All rights reserved. ");        		
        	}
        });*/
        aboutButton.setForeground(Color.BLACK);
        aboutButton.setBackground(Color.LIGHT_GRAY);
        aboutButton.setBounds(317, 392, 59, 21);
        add(aboutButton);
        mainFrameView.addNewPanel(this);
    	
    }
    public MainFrameView getFrame() {
        return mainFrameView;
    }


	public MainFrameView getMainFrame() {
		return mainFrameView;
	}

	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}


	public void addEnterButton(ActionListener actionListener) {
        enterButton.addActionListener(actionListener);
		
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
