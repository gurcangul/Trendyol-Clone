package App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Contollers.BeforeLoginController;
import Contollers.LoginController;
import Contollers.WelcomeController;
import FileIO.Reader;
import GUI.BeforeLoginView;
import GUI.LoginView;
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
       // @SuppressWarnings("unused")
		WelcomeView welcomeView = new WelcomeView(mainFrameView);//First Panel to welcome our users
		WelcomeController WelcomeController = new WelcomeController(mainFrameView,welcomeView);

		//BeforeLoginView beforeLoginView = new BeforeLoginView(mainFrameView);

		//BeforeLoginController beforeLoginController = new BeforeLoginController(mainFrameView,beforeLoginView);
		
		/*LoginView loginView = new LoginView(mainFrameView);
		LoginController loginController = new LoginController( loginView, mainFrameView);*/
    }
	
	public MainFrameView getMainFrame() {
		return mainFrameView;
	}
	public void setMainFrame(MainFrameView mainFrameView) {
		this.mainFrameView = mainFrameView;
	}
	
		
}

