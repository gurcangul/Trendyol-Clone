package App;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import FileIO.DataHandler;

public class OnlineShoppingApp {
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException {
		DataHandler.readFile();
    	OnlineShoppingManager onlineShoppingManager = new OnlineShoppingManager();
    	onlineShoppingManager.start();
    	/*Parser p = new Parser();
    	p.parseProductAndCategory();*/
	}
}
