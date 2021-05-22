package Contollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import GUI.BeforeLoginView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.SignUpView;
import GUI.WelcomeView;

public class BeforeLoginController {
    private final BeforeLoginView beforeLoginView;
    private final  MainFrameView mainFrameView;
    
    public BeforeLoginController(MainFrameView mainFrameView, BeforeLoginView beforeLoginView){
		this.mainFrameView=mainFrameView;
    	this.beforeLoginView = beforeLoginView;
		
		beforeLoginView.addLoginButton(new loginActionListener());
		beforeLoginView.addSignInButton(new signInActionListener());
		beforeLoginView.addBackButton(new backActionListener());

    }
    private class loginActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*String title = browseWatchlistView.getUserInput("Watch List title:");
            currentUser.addWatchlist(new Watchlist(new ArrayList<>(),title));*/ 
        	LoginView loginView =  new LoginView(mainFrameView);
    		//mainFrameView.addNewPanel(loginView);	
    		LoginController loginController = new LoginController(mainFrameView,loginView);
        }
    }
    
    private class backActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	WelcomeView welcomeView =  new WelcomeView(mainFrameView);
    		//mainFrameView.addNewPanel(welcomeView);
    		WelcomeController welcomeController = new WelcomeController(mainFrameView,welcomeView);

        }
    }
    
    private class signInActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*String title = browseWatchlistView.getUserInput("Watch List title:");
            currentUser.addWatchlist(new Watchlist(new ArrayList<>(),title));*/ 
    		//JOptionPane.showMessageDialog(null, "This is not avaible for now! ");
        	SignUpView signUpView = new SignUpView(mainFrameView);
        	
        	SignUpController signUpController = new SignUpController(mainFrameView, signUpView);

        }
    }
    
    
    
	public BeforeLoginView getBeforeLoginView() {
		return beforeLoginView;
	}

}
