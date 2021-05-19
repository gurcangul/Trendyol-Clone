package FileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import Product.Product;
import User.User;

public class Writer {

	public static void jsonProductWriter(List<Product> products) throws JSONException, IOException {
		JSONObject productObject = new JSONObject();
		for(Product product: products){
			productObject.put(product.getName(), product);
			FileWriter writer = new FileWriter("products.json", false);
			//productList.put(productObject);
			writer.write(productObject.toString(5));
			writer.flush();
			writer.close();
		}
	}
	
	public static void csvUserWriter(List<User> userList) throws IOException{
		String updatedLine = "";
		ArrayList<String> userFile = new ArrayList<String>();
		for(User user: userList) {
			updatedLine = user.getUserID() + "," + user.getUserType() + "," + user.getUserName() + "," + user.getEmail() + "," + user.getPassword();
			userFile.add(updatedLine);
		}

		BufferedWriter updatedFile =new BufferedWriter(new FileWriter("user.csv", false));
		for(String updatedFileLine: userFile){
			updatedFile.write(updatedFileLine+ "\n"); // this line writes the user.csv for the updatedLine
		}
		updatedFile.flush();
		updatedFile.close();
	}
}
