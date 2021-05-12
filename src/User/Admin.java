package User;

public class Admin implements User {
	   @Override
	   public void createObject() {
	      System.out.println("Inside Admin::createObject() method.");
	   }
}
