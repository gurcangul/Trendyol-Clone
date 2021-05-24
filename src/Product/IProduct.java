package Product;

import java.util.ArrayList;
import java.util.List;

import User.Seller;

public interface IProduct {//Component == Product  (Composite Design Pattern)
	public  int getID();	
	public String getName();	
	public double getPrice();	
    public void print();	
	public void add(IProduct product);	
    public void remove(IProduct product);    
    public ArrayList<IProduct> getChild();
    public int getStock();
    public Seller getSeller();
    public String viewProductByBuyer();
}
