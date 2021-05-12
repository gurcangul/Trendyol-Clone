package User;

public class Seller implements User{
	@Override
    public void createObject() {
		System.out.println("Inside Seller::createObject() method.");
	}
}
