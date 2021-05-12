package User;

public class Buyer implements User {
	@Override
    public void createObject() {
		System.out.println("Inside Buyer::createObject() method.");
	}
}
   