package App;

import User.User;
import User.UserFactory;

public class Main {
	   public static void main(String[] args) {
		      UserFactory userFactory = new UserFactory();

		      System.out.println("....");
		      //get an object of Admin and call its draw method.
		      User user1 = userFactory.getShape("Admin");
		      
		      //call draw method of Admin
		      user1.draw();

		      //get an object of Buyer and call its draw method.
		      User user2 = userFactory.getShape("Buyer");

		      //call draw method of Buyer
		      user2.draw();

		      //get an object of Square and call its draw method.
		      User user3 = userFactory.getShape("Seller");

		      //call draw method of Seller
		      user3.draw();
		   }
}
