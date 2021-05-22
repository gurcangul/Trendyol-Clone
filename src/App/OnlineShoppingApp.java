package App;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import FileIO.DataHandler;
import FileIO.Writer;
import Product.Category;
import Product.IProduct;
import Product.Product;
import User.Seller;
import User.User;

public class OnlineShoppingApp {
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException, JSONException {
		//DataHandler.getProductAndCategories();
		ArrayList<IProduct> products = DataHandler.getProductAndCategories();
		ArrayList<User> userList = DataHandler.parseUsers();
		/*IProduct category = new Category(7, "category7");
		Seller seller = (Seller)userList.get(1);
		IProduct product = new Product(70, "product1", (double)1000, 14, seller);
		IProduct product2 = new Product(71, "product2", (double)100, 114, seller);
		category.add(product);
		category.add(product2);
		products.add(category);
		Writer.jsonProductWriter(products);
		System.out.println(products);
		//System.out.println(products.get(0).getChild().get(0).getChild().get(0).getChild().get(0).getSeller().getEmail());
		//System.out.println(products.get(0).getChild().get(1));*/
		System.out.println(products);

		System.out.println(products.size());
		
		for(int i=0;i<products.size();i++) {
			System.out.println(products.get(i).getName());
		}
		
		
		/*for(Object obj: products) {
			if(obj.getClass().getName().equalsIgnoreCase("category")) {
				System.out.println(obj.getClass());

			}
		}*/
		
		//System.out.println(products.getClass().equals("category"));

    	OnlineShoppingManager onlineShoppingManager = new OnlineShoppingManager();
    	onlineShoppingManager.start();
    	/*Parser p = new Parser();
    	p.parseProductAndCategory();*/
	}
}
