package Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import User.Seller;

public class Product extends Observable implements IProduct{
	private int ID;
	private String name;
	private double price;
	private int stock;
	private Seller seller;
	private int numberOfFavorite;
    public Product(int ID,String name,double price, int stock,int numberOfFavorite, Seller seller){
    	setID(ID);
        setName(name);
        setPrice(price);
        setStock(stock);
        setSeller(seller);
        setNumberOfFavorite(numberOfFavorite);
    }
    
    @Override
    public void add(IProduct product) {
        //this is leaf node so this method is not applicable to this class.
    }

    @Override
    public ArrayList<IProduct> getChild() {
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
    
	@Override
	public Seller getSeller() {
		// TODO Auto-generated method stub
		return seller;
	}

	@Override
	public int getStock() {
		// TODO Auto-generated method stub
		return stock;
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
		return "Product [" + ID + ", " + name + ", " + price + ", " + stock +", "+ numberOfFavorite+", " + seller.getUserName() + "]";
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
	
    public void setStock(int stock) {
		this.stock = stock;
        setChanged();
        notifyObservers();
    }

	public int getNumberOfFavorite() {
		return numberOfFavorite;
	}

	public void setNumberOfFavorite(int numberOfFavorite) {
		this.numberOfFavorite = numberOfFavorite;
	    setChanged();
	    notifyObservers();
	}
	
	@Override
	public String viewProductByBuyer() {
		return "Product Name = " + name + "\n" + "Price = " + price + "\n" + "Seller = " + seller.getUserName();
	}
}