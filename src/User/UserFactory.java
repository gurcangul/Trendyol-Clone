package User;

public class UserFactory {
	   //use getShape method to get object of type shape 
	   public User getUser(String userType){
	      if(userType == null){
	         return null;
	      }		
	      if(userType.equalsIgnoreCase("Admin")){
	         return new Admin();
	         
	      } else if(userType.equalsIgnoreCase("Buyer")){
	         return new Buyer();
	         
	      } else if(userType.equalsIgnoreCase("Seller")){
	         return new Seller();
	      }
	      
	      return null;
	   }
}
