package GUI;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Choice;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.List;
import javax.swing.JRadioButtonMenuItem;

public class ContentView extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrameView mainFrameView;
	private MenuViewForBuyer menuView;
	public ContentView(MainFrameView mainFrameView, MenuViewForBuyer menuView) {
		this.setMenuView(menuView);
		this.setMainFrame(mainFrameView);        
		showPanel();
	}
	public void showPanel(){
		new JPanel(new GridLayout(3, 1));
        setLayout(null);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(201, 206, 85, 21);
		add(btnNewButton);
		
		TextField textField = new TextField();
		textField.setBounds(141, 55, 313, 111);
		add(textField);
		
		List list = new List();
		list.setBounds(10, 76, 104, 56);
		add(list);
		
		List list_1 = new List();
		list_1.setBounds(10, 166, 104, 56);
		add(list_1);
		
		Label label = new Label("New label");
		label.setBounds(306, 244, 59, 21);
		add(label);
        
	}
	public MainFrameView getMainFrameView() {
		return mainFrameView;
	}
	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}
	public MenuViewForBuyer getMenuView() {
		return menuView;
	}
	public void setMenuView(MenuViewForBuyer menuView) {
		this.menuView = menuView;
	}
}
