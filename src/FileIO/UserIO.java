package FileIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import User.User;
import User.UserFactory;


public class UserIO implements IUserIO{//for create user object from the csv file 

	@Override
	   public List<User> parseUsers() {
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
