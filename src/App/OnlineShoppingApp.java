package App;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import FileIO.DataHandler;
import Product.IProduct;

public class OnlineShoppingApp {
	/*
	 * Aeayüzdeki Buttonlar sadece birer kere çalışıyor, tıklanıldıktan sonra bir daha çalışmıyor, ufak bir sorun fakat bulamadım. yarın tekrar deneyecegim. 
	 *** */
	
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException {
		//DataHandler.getProductAndCategories();
		ArrayList<IProduct> products = DataHandler.getProductAndCategories();
		System.out.println(products);
		System.out.println(products.get(0).getChild().get(0).getChild().get(0).getChild().get(0).getSeller().getEmail());
		System.out.println(products.get(0).getChild().get(1));

    	OnlineShoppingManager onlineShoppingManager = new OnlineShoppingManager();
    	onlineShoppingManager.start();
    	/*Parser p = new Parser();
    	p.parseProductAndCategory();*/
	}
}
