package App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Contollers.LoginController;
import FileIO.Reader;
import GUI.MainFrame;
import GUI.WelcomePanel;
import User.User;
import User.UserFactory;

public class OnlineShoppingManager {
	 MainFrame mainFrame;

	 public OnlineShoppingManager() {
		 this.mainFrame = new MainFrame();
	 } 
	 
	public void start() throws IOException{ 
		/*List<User> userList = parseUsers(); 
		for(User user : userList)
			System.out.println(user.getUserName()+" "+user.getPassword());*/
	    
	    //call createObject method of Admin
	    //user1.createObject();
        @SuppressWarnings("unused")
		WelcomePanel welcomePanel = new WelcomePanel(mainFrame);//First Panel to welcome our users
    }
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
		
}