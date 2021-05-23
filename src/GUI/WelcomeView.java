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

        enterButton.setBounds(294, 301, 110, 21);
        add(enterButton);
        
        logo = new JLabel("");
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        
        logo.setIcon(new ImageIcon(WelcomeView.class.getResource("/gaga.png")));
        logo.setBounds(263, 112, 176, 167);
        add(logo);
        
        JLabel welcomeLabel1 = new JLabel("Welcome to the GAGA!");
        welcomeLabel1.setFont(new Font("Tahoma", Font.BOLD, 15));
        welcomeLabel1.setBounds(256, 66, 193, 36);
        add(welcomeLabel1);
        
        JLabel welcomeLabel2 = new JLabel("GAGA is the best Online Shopping application in Turkey!");
        welcomeLabel2.setFont(new Font("Tahoma", Font.ITALIC, 11));
        welcomeLabel2.setBounds(223, 361, 314, 21);
        add(welcomeLabel2);
        
        aboutButton = new JButton("About");
        aboutButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
        aboutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null, "Copyright© 2021 All rights reserved. ");        		
        	}
        });
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
