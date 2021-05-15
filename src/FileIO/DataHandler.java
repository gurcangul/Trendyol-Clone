package FileIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import Product.Category;
import Product.IProduct;
import Product.Product;
import User.Seller;
import User.User;
import User.UserFactory;



public class DataHandler {//for create user object from the csv file 
	
	static  ArrayList<User> userList = parseUsers();
	static  ArrayList<IProduct> productAndCategories = new ArrayList<IProduct>();

	
	   public static ArrayList<User> parseUsers() {
		   ArrayList<String> List = Reader.readFile("user.csv");
		   ArrayList<User> userList = new ArrayList<User>();
		   for(int i=1; i<List.size();i++) {
			   String str = List.get(i);
			   String[] split = str.split(","); 
			   UserFactory userFactory = new UserFactory();
			   User user = userFactory.getUser(Integer.parseInt(split[0]), split[1],split[2], split[3], split[4]);
			   userList.add(user);			
			} 
			return userList;
	   }
	
	
	private static void parseProduct(JSONObject category) {
		JSONObject productObject = (JSONObject) category.get("product");
        String ID = (String) productObject.get("ID");
        //System.out.println(ID);
        String name = (String) productObject.get("name");
        //System.out.println(name);
        String price = (String) productObject.get("price");
        //System.out.println(price);
        String seller = (String) productObject.get("seller");
        //System.out.println(seller);

        User user = UserFinderHelper.findUserByUsername(userList, seller);
        IProduct product1 = new Product(Integer.parseInt(ID), name, Double.parseDouble(price), (Seller)user);
	    productAndCategories.add(product1);
	}
	
	
	private static void parseProductObject(JSONObject category, JSONArray productList) 
    {
        //Get employee object within list
        JSONObject categoryObject = (JSONObject) category.get("category");
        JSONObject productObject = (JSONObject) category.get("product"); 
        //Get employee first name
        
        if(productObject != null) {
        	//for (Object o : )

            productList.forEach( prd -> parseProduct( (JSONObject) prd ) ); 
            
        }
        else if(categoryObject != null) {
	        String ID = (String) categoryObject.get("ID");    
	        //System.out.println(ID);
	         
	        //Get employee last name
	        String name = (String) categoryObject.get("name");  
	        //System.out.println(name);
	        JSONArray productList2 = (JSONArray) categoryObject.get("productList");
	        IProduct category1 = new Category(Integer.parseInt(ID), name, null);
	        productAndCategories.add(category1);
	       /* for (Object c : productList) {
	        	
	        	parseProductObject((JSONObject) c);
	        }*/
	        productList.forEach( prd -> parseProductObject( (JSONObject) prd, productList2 ) );
        }
   }
	
	public static ArrayList<IProduct> readFile() {
	      JSONParser jsonParser = new JSONParser();
	         
	        try (FileReader reader = new FileReader("example.json"))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray productAndCategoryList = (JSONArray) obj;
	           // System.out.println(productAndCategoryList);
	            
	            //Iterate over employee array
	            productAndCategoryList.forEach( prd -> parseProductObject( (JSONObject) prd , productAndCategoryList) );
	            
	           // System.out.println(productAndCategories);
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Ben calistim");
	        return productAndCategories;
	}


	public static ArrayList<IProduct> getProductAndCategories() {
		return readFile();
	}


	public static void setProductAndCategories(ArrayList<IProduct> productAndCategories) {
		DataHandler.productAndCategories = readFile();
	}
	
	public User checkUserIsExist(String username, String password){
		for(User user : userList)
			System.out.println(user);
	    return UserFinderHelper.checkUserIsExist(username,password,userList);
	}
	

}

/*

*/