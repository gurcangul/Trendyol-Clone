package GUI;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MyProfile extends JPanel {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	public MyProfile(MainFrame mainFrame) {
		this.setMainFrame(mainFrame);        
		JPanel jP=  new JPanel(new GridLayout(3, 1));
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

}
