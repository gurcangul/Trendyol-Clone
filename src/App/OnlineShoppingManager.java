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
		List<User> userList = parseUsers(); 
		for(User user : userList)
			System.out.println(user.getUserName()+" "+user.getPassword());
	    
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
	
   public List<User> parseUsers() throws IOException {
      ArrayList<String> List = Reader.readFile("user.csv");
      ArrayList<User> userList = new ArrayList<User>();
      for(int i=1; i<List.size();i++) {
			String str = List.get(i);
			String[] split = str.split(","); 
			UserFactory userFactory = new UserFactory();
			User user = userFactory.getUser(Integer.parseInt(split[0]), split[1],split[2], split[3], split[4]);
			userList.add(user);
			
		} 
		return userList;
   }		
}