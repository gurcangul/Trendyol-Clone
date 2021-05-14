package FileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import Product.Product;

public class Writer {
	
	public static void jsonProductWriter(List<IProduct> products) throws JSONException, IOException {
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
}
