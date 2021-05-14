package Product;

import java.util.List;

public class Product implements IProduct{
	private int ID;
	private String name;
	private double price;

    public Product(int ID,String name,double price){
    	setID(ID);
        setName(name);
        setPrice(price);
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
		return "Part [id=" + ID + ", name=" + name + ", salary=" + price + "]";
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
	
}
