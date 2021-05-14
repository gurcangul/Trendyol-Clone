package Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Category implements IProduct {//Composite==Category  (Composite Design Pattern)
	 private int ID;
	 private String name;
	 List<IProduct> productList = new ArrayList<IProduct>();

	 public Category(int ID,String name,List<IProduct> productList )
	 {
	  this.ID=ID;	 
	  this.name = name;
	  this.productList = productList;
	 }
	 
	 
	 @Override
	 public void add(IProduct product) 
	 {
		 productList.add(product);
	 }

	 @Override
	 public List<IProduct> getChild() 
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
		return "Assembly [ID=" + ID + ", name=" + name +  ", productList=" + productList + "]";
	}


	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
}
