package User;

import java.util.Map;

import Product.IProduct;
public interface User {
	
	
	void setUserID(int userID);
	int getUserID();
	void setUserType(String userType);
	String getUserType();
	void setUserName(String userName);
	String getUserName();
	void setEmail(String email);
	String getEmail();
	void setPassword(String password);
	String getPassword();
	void createObject();
	Map<IProduct, Integer> getShoppingCart();
	void addProductToShoppingCart(IProduct product, Integer quantity);
	void removeProductFromShoppingCart(IProduct product, Integer quantity);
}
