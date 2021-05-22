package Contollers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import Contollers.LoginController.LoginButtonListener;
import Contollers.LoginController.backButtonListener;
import FileIO.DataHandler;
import FileIO.Writer;
import GUI.BeforeLoginView;
import GUI.LoginView;
import GUI.MainFrameView;
import GUI.MenuView;
import GUI.SignUpView;
import User.Buyer;
import User.Seller;
import User.User;

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
    	else {
    		JOptionPane.showMessageDialog(null, "Sign Up is successfull. ");   
    		if(userType.equalsIgnoreCase("seller")) {
    			System.out.println("seller ici");
    			int ID = dataHandler.createRandomID();
    			User user = new Seller(ID, userType, userName, email, password);
    			System.out.println(user);
    			dataHandler.addUser(user);
    		}
    		else if(userType.equalsIgnoreCase("buyer")) {
    			System.out.println("buyer ici");
    			int ID = dataHandler.createRandomID();
    			User user = new Buyer(ID, userType, userName, email, password);
    			System.out.println(user);
    			dataHandler.addUser(user);
    		}
    		Writer.csvUserWriter(dataHandler.getUserList());
    		for(User usr: dataHandler.getUserList())
    			System.out.println(usr);
    		BeforeLoginView beforeLoginView = new BeforeLoginView(mainFrameView);
        	
    		BeforeLoginController beforeLoginController = new BeforeLoginController(mainFrameView, beforeLoginView);
    	}
      /*  if (user != null) {
            this.menuView=new MenuView(mainFrameView,user);
            System.out.println("giris yapıldı...."+userName+ password);
            //this.menuPanel.addOkButtonListener(new LoggedInOkButtonListener());
           // MenuController menuController = new MenuController(menuView, user);
          
            menuView =  new MenuView(mainFrameView,user);
    		//mainFrameView.addNewPanel(menuView);
            MenuController menuController = new MenuController(mainFrameView,menuView, user);

            //this.menuPanel.addCancelButtonListener(new LoggedInCancelButtonListener());
    		menuView.setUserName(user.getUserName());
    		System.out.println("helloo"+user.getUserName());
           // this.userModel.setLoggedInUser(user);//*****
        } else {
            //loginPanel.passwordCheck();
    		//JLabel lblNewLabel2 = new JLabel("Wrong! Please try again!");
        	signUpView.getPassword().setBackground(Color.RED);
        	signUpView.getUserName().setBackground(Color.RED);
    		JOptionPane.showMessageDialog(null, "Wrong! Please try again! ");        		
            this.showSignInPanel();

            
        }*/
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
            String userType = signUpView.getUserType().getText();
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
