package GUI;


import javax.swing.*;

import Observer.Observer;

import java.awt.*;

public class MainFrameView extends JFrame implements Observer {
	
	//MenuView menuView=new MenuView(this,null);
	private static final long serialVersionUID = 1L;
    JFrame frame;

	public void run() {
		try {
			frame = new JFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public MainFrameView() {
        
		setBounds(100, 100, 450, 300);
        setSize(760, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

  /*  public void addNewPanel(JPanel panel){
        //System.out.println("heyyyy");
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
    }*/

    public void addNewPanel(JPanel panel){
        this.getContentPane().removeAll();
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
    public void addMenuPanel(JPanel panel){
        this.getContentPane().removeAll();
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
    public JFrame getFrame() {
        return this;
    }
	@Override
	public void update(Object arg) {
		// TODO Auto-generated method stub
		
	}
}
