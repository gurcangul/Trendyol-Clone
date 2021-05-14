package Product;

import java.util.List;

import User.User;

public class Client {
	
	private List<IProduct> productAndCategoryList;
	private User user;
	
	public Client(List<IProduct> productAndCategoryList, User user) {
		setProductAndCategoryList(productAndCategoryList);
		setUser(user);
		
		
		if(user.getUserType().equalsIgnoreCase("seller")){ // only seller creates product 
			// do something
		}
		else if (user.getUserType().equalsIgnoreCase("admin")) {	// only admin creates category
			// do something
			int ID = 0; 
			String name = "";
			double price = 0;
			IProduct category = new Category(ID, name, price);
			
			// Ask in interface (Which category do you add?)
			
			productAndCategoryList.add(category);
		}
	}

	public List<IProduct> getProductAndCategoryList() {
		return productAndCategoryList;
	}

	public void setProductAndCategoryList(List<IProduct> productList) {
		this.productAndCategoryList = productList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
