package FileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import User.User;
import User.UserFactory;


public class Parser implements IParser{//for create user object from the csv file 

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
	
	{
		
	}

	@Override
	public Map parseProductAndCategory() throws FileNotFoundException, IOException, ParseException {
		Object obj = new JSONParser().parse(new FileReader("products.json"));
		JSONObject jo = (JSONObject) obj;
		Map category = jo;
		Iterator<Map.Entry> itr1 = category.entrySet().iterator();
		while(itr1.hasNext()) {
			Map.Entry pair = itr1.next();
			System.out.println(pair.getKey() + " : " + pair.getValue());
		}
		return null;
	}

}
