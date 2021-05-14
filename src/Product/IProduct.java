package Product;

import java.util.List;

public interface IProduct {//Component == Product  (Composite Design Pattern)
	public  int getID();	
	public String getName();	
	public double getPrice();	
    public void print();	
	public void add(Product product);	
    public void remove(Product product);    
    public List<Product> getChild();
}
