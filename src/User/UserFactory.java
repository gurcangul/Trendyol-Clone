package User;

public class UserFactory {
	   //use getShape method to get object of type shape 
	   public User getShape(String shapeType){
	      if(shapeType == null){
	         return null;
	      }		
	      if(shapeType.equalsIgnoreCase("Admin")){
	         return new Admin();
	         
	      } else if(shapeType.equalsIgnoreCase("Admin")){
	         return new Admin();
	         
	      } else if(shapeType.equalsIgnoreCase("Seller")){
	         return new Seller();
	      }
	      
	      return null;
	   }
}
