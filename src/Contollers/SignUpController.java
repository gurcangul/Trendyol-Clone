package Contollers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import FileIO.DataHandler;
import FileIO.Writer;
import GUI.BeforeLoginView;
import GUI.MainFrameView;
import GUI.MenuView;
import GUI.SignUpView;
import User.User;
import User.UserFactory;

public class SignUpController {

    private BeforeLoginView beforeLoginView;
    private MenuView menuView;
    private MainFrameView mainFrameView;
    private User user;
    private SignUpView signUpView;

    public SignUpController(MainFrameView mainFrameView,SignUpView signUpView) {
        this.signUpView = signUpView;
        this.mainFrameView=mainFrameView;
        signUpView.addSignInActionListener(new SignInButtonListener());
        signUpView.addBackActionListener(new backButtonListener());
        
    }
    
    public void signIn(String userName, String email, String userType, String password) throws IOException {
        DataHandler dataHandler = new DataHandler();
    	//user =  dataHandler.checkUserIsExist(userName, password);
    	
    	boolean checkUserName = dataHandler.checkUserNameIsExist(userName);
    	boolean checkEmail = dataHandler.checkEmailIsExist(email);
    	if(checkUserName) {
    		signUpView.getUserName().setBackground(Color.RED);
    		JOptionPane.showMessageDialog(null, "This user name already exist! Please enter new one! ");        		
            this.showSignInPanel();
    	}
    	else if(checkEmail) {
    		signUpView.getEmail().setBackground(Color.RED);
    		JOptionPane.showMessageDialog(null, "This email already exist! Please enter new one! ");        		
            this.showSignInPanel();
    	}
    	else if(userName.equals("") || email.equals("") || userType.equals("") || password.equals("")){
    		if( userType.equals("")) signUpView.getUserType().setBackground(Color.RED);
    		if(userName.equals("")) signUpView.getUserName().setBackground(Color.RED);
    		if(email.equals("")) signUpView.getEmail().setBackground(Color.RED);
    		if(password.equals("")) signUpView.getPassword().setBackground(Color.RED);
    		JOptionPane.showMessageDialog(null, "All fields must be filled ");        		
            this.showSignInPanel();
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "Sign Up is successfull. ");   
    		int ID = dataHandler.createRandomID();
    		UserFactory uf = new UserFactory();
    		user = uf.getUser(ID, userType, userName, email, password);
    		dataHandler.addUser(user);
    		Writer.csvUserWriter(dataHandler.getUserList());
    		for(User usr: dataHandler.getUserList())
    			System.out.println(usr);
    		BeforeLoginView beforeLoginView = new BeforeLoginView(mainFrameView);
        	
    		BeforeLoginController beforeLoginController = new BeforeLoginController(mainFrameView, beforeLoginView);
    	}
    }
    
    public void showSignInPanel() {
    	signUpView.getPassword().setBackground(Color.white);
    	signUpView.getUserName().setBackground(Color.white);
    	signUpView.getUserType().setBackground(Color.white);
    	signUpView.getEmail().setBackground(Color.white);
    	signUpView.setVisible();
    	signUpView.addSignInActionListener(new SignInButtonListener());
    }
    
    class SignInButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = signUpView.getUserName().getText();
            String password = signUpView.getPassword().getText();
            String userType = signUpView.getUserType().getSelectedItem().toString();
            String email = signUpView.getEmail().getText();
            try {
				signIn(username, email, userType, password);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
    class backButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            	beforeLoginView =  new BeforeLoginView(mainFrameView);
            	//mainFrameView.addNewPanel(beforeLoginView);
            	BeforeLoginController beforeLoginController = new BeforeLoginController(mainFrameView,beforeLoginView);

        }
    }
    class LoggedInOkButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	menuView =  new MenuView(mainFrameView,user);
    		//mainFrameView.addNewPanel(menuView);
            MenuController menuController = new MenuController(mainFrameView,menuView, user);

    		
        }
    }
}
