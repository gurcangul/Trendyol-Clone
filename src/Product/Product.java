package Product;

import java.util.List;

import User.Seller;

public class Product implements IProduct{
	private int ID;
	private String name;
	private double price;
	private int stok;
	private Seller seller;

    public Product(int ID,String name,double price, int stok, Seller seller){
    	setID(ID);
        setName(name);
        setPrice(price);
        setSeller(seller);
        setStok(stok);
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
    
	@Override
	public Seller getSeller() {
		// TODO Auto-generated method stub
		return seller;
	}

	@Override
	public int getStok() {
		// TODO Auto-generated method stub
		return 0;
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
		return "Product [" + ID + ", " + name + ", " + price + ", " + stok + ", " + seller.getUserName() + "]";
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

	
	public void setStok(int stok) {
		this.stok = stok;
	}


}
