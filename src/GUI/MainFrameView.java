package GUI;


import javax.swing.*;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class MainFrameView extends JFrame implements Observer {
	MenuViewForBuyer menuView=new MenuViewForBuyer(this,null);
	private static final long serialVersionUID = 1L;

	public void run() {
		try {
			Frame frame = new Frame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public MainFrameView() {
        setTitle("Gaga | The best Online Shopping Application!");
		setBounds(100, 100, 450, 300);
        setSize(760, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addNewPanel(JPanel panel){
    	getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();     
    }
    public void addMenu(){
    	getContentPane().removeAll();
        getContentPane().add(menuView, BorderLayout.PAGE_START);
        revalidate();
        repaint();
    }
    public void addMenuPanel(JPanel panel){
    	addMenu();	
        getContentPane().add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }   
    public void addNewPanel2(JPanel panel){
    	getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.PAGE_START);
        revalidate();
        repaint();
        
    }    
    public void addMenuPanel3(JPanel panel){
        getContentPane().add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }  
    
    public JFrame getFrame() {
        return this;
    }
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub		
	}
}