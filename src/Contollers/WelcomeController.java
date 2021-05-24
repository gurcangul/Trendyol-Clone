package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.BeforeLoginView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.WelcomeView;

public class WelcomeController {
	private final WelcomeView welcomeView;
    private MainFrameView mainFrameView;
    
    public WelcomeController(MainFrameView mainFrameView, WelcomeView welcomeView){
		this.mainFrameView=mainFrameView;
    	this.welcomeView = welcomeView;
		
    	welcomeView.addEnterButton(new enterActionListener());

    }
    private class enterActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	BeforeLoginView beforeLoginView =  new BeforeLoginView(mainFrameView);
    		BeforeLoginController beforeLoginController = new BeforeLoginController(mainFrameView, beforeLoginView );
        }
    }
}
