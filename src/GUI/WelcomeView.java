package GUI;

import javax.swing.*;

import Contollers.LoginController;
import Observer.Observer;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeView extends JPanel implements Observer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private MainFrameView mainFrameView;
    private JButton enterButton;
    private JLabel lblNewLabel;
    private BeforeLoginView beforeLoginView;
    private JButton btnNewButton_1;

    public WelcomeView(MainFrameView mainFrameView) {
        this.setMainFrame(mainFrameView);

        new JPanel(new GridLayout(3, 1));       
        setSize(760, 460);
        setLayout(null);

        mainFrameView.addNewPanel(this);
        
        enterButton = new JButton("ENTER");
        enterButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

        enterButton.setBounds(293, 263, 110, 21);
        add(enterButton);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Gurcan\\eclipse-workspace\\G12_CENG431_HW3-v1\\src\\logo.png"));
        lblNewLabel.setBounds(292, 143, 110, 113);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Welcome to the Outfit Rating Platform");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBounds(212, 84, 303, 36);
        add(lblNewLabel_1);
        
        btnNewButton_1 = new JButton("About");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        /*btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null, "Copyright© 2021 All rights reserved. ");        		
        	}
        });*/
        btnNewButton_1.setForeground(Color.BLACK);
        btnNewButton_1.setBackground(Color.LIGHT_GRAY);
        btnNewButton_1.setBounds(317, 392, 59, 21);
        add(btnNewButton_1);
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

	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void addEnterButton(ActionListener actionListener) {
        enterButton.addActionListener(actionListener);
		
	}
}
