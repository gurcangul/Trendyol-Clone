package Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import User.Seller;

public class Category implements IProduct {//Composite==Category  (Composite Design Pattern)
	 private int ID;
	 private String name;
	 ArrayList<IProduct> productList = new ArrayList<IProduct>();

	 public Category(int ID,String name,ArrayList<IProduct> productList )
	 {
	  this.ID=ID;	 
	  this.name = name;
	  this.productList = productList;
	 }
	 public Category(int ID,String name )
	 {
	  this.ID=ID;	 
	  this.name = name;
	 }
	 
	 @Override
	 public void add(IProduct product) 
	 {
		 productList.add(product);
	 }

	 @Override
	 public ArrayList<IProduct> getChild() 
	 {
	  return productList;
	 }

	 @Override
	 public void remove(IProduct employee) {
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
	 public void print() 
	 {
		 
	  System.out.println("==========================");
	  System.out.println("Id ="+getID());
	  System.out.println("Name ="+getName());
	  System.out.println("==========================");
	  
	  Iterator<IProduct> it = productList.iterator();
	  
	      while(it.hasNext())
	     {
	    	  IProduct product = it.next();
	    	  product.print();
	     }
	 }

	@Override
	public String toString() {
		return "Category [" + ID + ", " + name + ", " + productList + "]";
	}


	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Seller getSeller() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getStock() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String viewProductByBuyer() {
		// TODO Auto-generated method stub
		return null;
	}
}
