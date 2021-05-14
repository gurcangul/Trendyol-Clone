package App;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import FileIO.DataHandler;
import Product.IProduct;

public class OnlineShoppingApp {
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException {
		//DataHandler.getProductAndCategories();
		ArrayList<IProduct> products = DataHandler.getProductAndCategories();
		System.out.println(products);
		
    	OnlineShoppingManager onlineShoppingManager = new OnlineShoppingManager();
    	onlineShoppingManager.start();
    	/*Parser p = new Parser();
    	p.parseProductAndCategory();*/
	}
}
