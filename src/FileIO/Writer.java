package FileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

import Product.IProduct;
import User.User;

public class Writer {

	public static void jsonProductWriter(ArrayList<IProduct> products) throws JSONException, IOException {
		JSONArray productList = new JSONArray();
		FileWriter writer = new FileWriter("example.json", false);
		JSONArray categoryList = new JSONArray();
		for(IProduct product: products){
			JSONObject productCategory = new JSONObject();
			JSONObject productObject = new JSONObject();
			if("class Product.Category".equalsIgnoreCase(product.getClass().toString())) {
				productObject.put("ID", String.valueOf(product.getID()));
				productObject.put("name", product.getName());
				if(product.getChild().isEmpty()) {
					productObject.put("productList", product.getChild());

					}
				else {
					JSONObject categoryObjectList = new JSONObject();
					helperJsonProductWriter(productObject, product.getChild());
					categoryObjectList.put("category", productObject);
					categoryList.put(categoryObjectList);
				}
			}
			productCategory.put("category", productObject);
			productList.put(productCategory);
		}
		writer.write(productList.toString(5));
		writer.flush();
		writer.close();
	}
	
	public static void helperJsonProductWriter(JSONObject productObject, ArrayList<IProduct> products) throws JSONException, IOException {

		JSONArray categoryList = new JSONArray();
		for(IProduct product: products){
			JSONObject categoryObject = new JSONObject();
			if("class Product.Category".equalsIgnoreCase(product.getClass().toString())) { 
				categoryObject.put("ID", String.valueOf(product.getID()));
				categoryObject.put("name", product.getName());
				if(product.getChild().isEmpty()) {
					JSONObject category = new JSONObject();
					categoryObject.put("productList", product.getChild());
					category.put("category", categoryObject);
					categoryList.put(category);

				}
				else {
					
					JSONObject categoryObjectList = new JSONObject();
					helperJsonProductWriter(categoryObject, product.getChild());
					categoryObjectList.put("category", categoryObject);
					categoryList.put(categoryObjectList);

				}
			}
			else if("class Product.Product".equalsIgnoreCase(product.getClass().toString())) {

				JSONObject productListObject = new JSONObject();
				productListObject.put("ID", String.valueOf(product.getID()));
				productListObject.put("name", product.getName());
				productListObject.put("price",  String.valueOf(product.getPrice()));
				productListObject.put("stok",  String.valueOf(product.getStok()));
				productListObject.put("seller", product.getSeller().getUserName());	
				categoryObject.put("product", productListObject);
				categoryList.put(categoryObject);

			}
		}
		productObject.put("productList", categoryList);
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
