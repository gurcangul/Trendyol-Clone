package User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Product.IProduct;

public class Buyer implements User {


	private int userID ;
	private String userType;
	private String userName ;
	private String email;
	private String password;
	private Map<IProduct, Integer> shoppingCart = new HashMap<IProduct, Integer>(); 
	private ArrayList<IProduct> favoriList = new ArrayList<IProduct>(); 
	
	public Buyer(int userID, String userType, String userName, String email, String password){
		setUserID(userID);
		setUserType(userType);
		setUserName(userName);
		setEmail(email);
		setPassword(password);
	}
	
	@Override
	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public int getUserID() {
		// TODO Auto-generated method stub
		return userID;
	}

	@Override
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String getUserType() {
		// TODO Auto-generated method stub
		return userType;
	}

	@Override
	public void setUserName(String userName) {
		this.userName  = userName;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
		
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public void createObject() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return userID + ", " + userType + ", " + userName + ", " + email
				+ ", " + password + ", " + shoppingCart;
	}
	
	
	
	public void setShoppingCart(Map<IProduct, Integer> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Override
	public Map<IProduct, Integer> getShoppingCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProductToShoppingCart(IProduct product, Integer quantity) {
		boolean flag = false;
		if(!shoppingCart.isEmpty()) {
			for(Map.Entry m:shoppingCart.entrySet()) {
				IProduct prd = (IProduct) m.getKey();
				if(product.getName().equalsIgnoreCase(prd.getName())) {
					flag = true;
					Integer productQuantity = (Integer) m.getValue();
					productQuantity += quantity;
					shoppingCart.replace(product, productQuantity);
				}
			}
			if(!flag) shoppingCart.put(product, quantity);
		}
		else shoppingCart.put(product, quantity);
	}

	@Override
	public void removeProductFromShoppingCart(IProduct product, Integer quantity) {
		if(!shoppingCart.isEmpty()) {
			for(Map.Entry m:shoppingCart.entrySet()) {
				IProduct prd = (IProduct) m.getKey();
				if(product.getName().equalsIgnoreCase(prd.getName())) {
					Integer productQuantity = (Integer) m.getValue();
					if(quantity > productQuantity)
					{
						// yeterli ürün yok demesi lazım ama bunu ui da yazdırmalıyız buraya nasıl bir şey yapacağımızı ui da karar verelim
					}
					else if(quantity == productQuantity)
						shoppingCart.remove(product, quantity);
					else
						productQuantity -= quantity;
					shoppingCart.replace(product, productQuantity);
				}
			}
		}
	}

	@Override
	public ArrayList<IProduct> getFavoriteList() {
		
		return favoriList;
	}

	@Override
	public void addProductToFavoriteList(IProduct product) {
		favoriList.add(product);
		
	}
}
   