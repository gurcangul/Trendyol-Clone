package Product;

import java.util.List;

import User.Seller;

public class Product implements IProduct{
	private int ID;
	private String name;
	private double price;
	private Seller seller;

    public Product(int ID,String name,double price, Seller seller){
    	setID(ID);
        setName(name);
        setPrice(price);
        setSeller(seller);
    }
    
    @Override
    public void add(IProduct product) {
        //this is leaf node so this method is not applicable to this class.
    }

    @Override
    public List<IProduct> getChild() {
        //this is leaf node so this method is not applicable to this class.
        return null;
    }
    
    @Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
    

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
    public void print() {
        System.out.println("==========================");
        System.out.println("Id ="+getID());
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getPrice());
        System.out.println("==========================");
    }

    @Override
    public void remove(IProduct product) {
        //this is leaf node so this method is not applicable to this class.
    }

    

	

	@Override
	public String toString() {
		return "Product [" + ID + ", " + name + ", " + price + ", " + seller.getUserName() + "]";
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public Seller getSeller() {
		// TODO Auto-generated method stub
		return seller;
	}
	
}
