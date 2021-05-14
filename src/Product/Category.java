package Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Category implements IProduct {//Composite==Category  (Composite Design Pattern)
	 private int ID;
	 private String name;
	 private double price;
	 List<Product> productList = new ArrayList<Product>();

	 public Category(int ID,String name,double price)
	 {
	  this.ID=ID;	 
	  this.name = name;
	  this.price = price;
	 }
	 
	 
	 @Override
	 public void add(Product product) 
	 {
		 productList.add(product);
	 }

	 @Override
	 public List<Product> getChild() 
	 {
	  return productList;
	 }

	 @Override
	 public void remove(Product employee) {
		 productList.remove(employee);
	 }	
	 
	 @Override
	 public int getID() 
	 {
	  return ID;
	 }
	 
	 @Override
	 public String getName() 
	 {
	  return name;
	 }
	 
	 @Override
	 public double getPrice()
	 {
	  return price;
	 }

	 @Override
	 public void print() 
	 {
		 
	  System.out.println("==========================");
	  System.out.println("Id ="+getID());
	  System.out.println("Name ="+getName());
	  System.out.println("Price ="+getPrice());
	  System.out.println("==========================");
	  
	  Iterator<Product> it = productList.iterator();
	  
	      while(it.hasNext())
	     {
	    	  Product employee = it.next();
	        employee.print();
	     }
	 }

	@Override
	public String toString() {
		return "Assembly [ID=" + ID + ", name=" + name + ", price=" + price + ", productList=" + productList + "]";
	}
}
