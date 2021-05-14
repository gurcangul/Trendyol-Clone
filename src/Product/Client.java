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
			// ass for seller Which category do you want to add?
			// add a combobox for seller that he/she will choose category or product
			// if the seller choose category
			// add a combobox that have all categories
			// get ID, name from the seller and create category and add productAndCategoryList
			// if the seller choose the product
			// add a combobox that have all categories
			// get ID, name and price from the user and create a product 
			// created product is added to productAndCategoryList
		}
		else if (user.getUserType().equalsIgnoreCase("admin")) {	// only admin creates category
			// do something
			// these categories are created automatically by Admin
			
			IProduct category = new Category(1, "Electronic", null);
			IProduct category1 = new Category(2, "Clothing", null);
			IProduct category2 = new Category(3, "Shoes&Bags", null);
			IProduct category3 = new Category(4, "Watch&Accesories", null);
			IProduct category4 = new Category(5, "Home&Life", null);
			IProduct category5 = new Category(6, "Cosmetic", null);
			
			productAndCategoryList.add(category);
			productAndCategoryList.add(category1);
			productAndCategoryList.add(category2);
			productAndCategoryList.add(category3);
			productAndCategoryList.add(category4);
			productAndCategoryList.add(category5);
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
