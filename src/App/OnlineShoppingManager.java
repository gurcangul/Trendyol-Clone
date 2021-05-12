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
		//List<User> userList = parseUsersXML(); // gurcan bu hatali degismeli -- tamam sonra bakalim okey-GG
	    System.out.println(userList);
	    UserFactory userFactory = new UserFactory();

	    System.out.println("....");
	    //get an object of Admin and call its createObject method.
	    //User user1 = userFactory.getUser("Admin");
	    
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
	

   private static List<User> parseUsersXML() throws ParserConfigurationException, SAXException, IOException{
      List<User> users = new ArrayList<User>();
      User user = null;
      
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document file = builder.parse(new File("users.xml"));
      file.getDocumentElement().normalize();
      NodeList nList = file.getElementsByTagName("user");
      for (int temp = 0; temp < nList.getLength(); temp++)
      {
         Node node = nList.item(temp);
         if (node.getNodeType() == Node.ELEMENT_NODE)
         {
            Element eElement = (Element) node;

            //user = new User();
            user.setUserName(eElement.getElementsByTagName("userName").item(0).getTextContent());
            user.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());

            users.add(user);
         }
      }
      return users;
   }
		
}
