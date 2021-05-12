package App;

import GUI.MainFrame;
import GUI.WelcomePanel;
import User.User;
import User.UserFactory;

public class OnlineShoppingManager {
	 MainFrame mainFrame;

	    public OnlineShoppingManager() {
	        this.mainFrame = new MainFrame();
	    } 
		public void start(){ 
			
		    UserFactory userFactory = new UserFactory();

		    System.out.println("....");
		    //get an object of Admin and call its createObject method.
		    User user1 = userFactory.getUser("Admin");
		    
		    //call createObject method of Admin
		    user1.createObject();

		    //get an object of Buyer and call its createObject method.
		    User user2 = userFactory.getUser("Buyer");

		    //call createObject method of Buyer
		    user2.createObject();

		    //get an object of Square and call its createObject method.
		    User user3 = userFactory.getUser("Seller");

		    //call createObject method of Seller
		    user3.createObject();
			
	        @SuppressWarnings("unused")
			WelcomePanel welcomePanel = new WelcomePanel(mainFrame);//First Panel to welcome our users
	        //LoginController loginController = new LoginController(loginView);//panel checker
	    }
		public MainFrame getMainFrame() {
			return mainFrame;
		}
		public void setMainFrame(MainFrame mainFrame) {
			this.mainFrame = mainFrame;
		}
}
