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
import java.util.Observable;
import java.util.Observer;

public class AboutAppView extends JPanel implements Observer {
	private static final long serialVersionUID = 3847238445785672779L;
	MainFrameView mainFrameView ;
	public AboutAppView(MainFrameView mainFrameView ) {
		this.setMainFrame(mainFrameView);        
		new JPanel(new GridLayout(3, 1));
		String info="This Application created by \nAynur Atış  and \nGürcan Gül";
		setLayout(new BorderLayout(0, 0));Label label = new Label(info);
		label.setAlignment(Label.CENTER);
		add(label, BorderLayout.NORTH);
		JLabel copyrightLabel = new JLabel("Copyright 2021 All rights reserved.");

		info="Copyright 2021 All rights reserved.";
		add(copyrightLabel);

	}
	public MainFrameView getMainFrame() {
		return mainFrameView;
	}
	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
