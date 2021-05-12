package GUI;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridLayout;

import java.awt.BorderLayout;
import java.awt.Label;

public class AboutAppPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3847238445785672779L;
	private MainFrame mainFrame ;
	//MenuPanel menuPanel;
	/**
	 * Create the panel.
	 * @param jP 
	 */
	public AboutAppPanel(MainFrame mainFrame ) {
		this.setMainFrame(mainFrame);        
		JPanel jP=  new JPanel(new GridLayout(3, 1));
		String info="This Application created by \nAynur Atış  and \nGürcan Gül";
		setLayout(new BorderLayout(0, 0));Label label = new Label(info);
		label.setAlignment(Label.CENTER);
		add(label, BorderLayout.NORTH);
		JLabel lblNewLabel2 = new JLabel("Copyright© 2021 All rights reserved.");

		info="Copyright© 2021 All rights reserved.";
		add(lblNewLabel2);

	}
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	

}
