package GUI;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MyProfileView extends JPanel {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrameView mainFrameView;

	/**
	 * Create the panel.
	 */
	public MyProfileView(MainFrameView mainFrameView) {
		this.setMainFrame(mainFrameView);        
		JPanel jP=  new JPanel(new GridLayout(3, 1));
	}

	public MainFrameView getMainFrame() {
		return mainFrameView;
	}

	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}

}
