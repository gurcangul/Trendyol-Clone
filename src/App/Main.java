package App;

import User.User;
import User.UserFactory;

public class Main {
	   public static void main(String[] args) {
		      UserFactory userFactory = new UserFactory();

		      System.out.println("....");
		      //get an object of Admin and call its createObject method.
		      User user1 = userFactory.getShape("Admin");
		      
		      //call createObject method of Admin
		      user1.createObject();

		      //get an object of Buyer and call its createObject method.
		      User user2 = userFactory.getShape("Buyer");

		      //call createObject method of Buyer
		      user2.createObject();

		      //get an object of Square and call its createObject method.
		      User user3 = userFactory.getShape("Seller");

		      //call createObject method of Seller
		      user3.createObject();
		   }
}
