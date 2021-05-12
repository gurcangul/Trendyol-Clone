package App;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
		List<User> userList = parseUsers(); 
	    System.out.println(userList);
	    System.out.println("....");
	    
	    //call createObject method of Admin
	    //user1.createObject();
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
