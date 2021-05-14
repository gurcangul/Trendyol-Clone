package App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Contollers.LoginController;
import FileIO.Reader;
import GUI.MainFrameView;
import GUI.WelcomeView;
import User.User;
import User.UserFactory;

public class OnlineShoppingManager {
	 MainFrameView mainFrameView;

	 public OnlineShoppingManager() {
		 this.mainFrameView = new MainFrameView();
	 } 
	 
	public void start() throws IOException{ 
		/*List<User> userList = parseUsers(); 
		for(User user : userList)
			System.out.println(user.getUserName()+" "+user.getPassword());*/
	    
	    //call createObject method of Admin
	    //user1.createObject();
        @SuppressWarnings("unused")
		WelcomeView welcomeView = new WelcomeView(mainFrameView);//First Panel to welcome our users
    }
	
	public MainFrameView getMainFrame() {
		return mainFrameView;
	}
	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}
	
		
}