package User;

public class UserFactory {
	   //use getShape method to get object of type shape 
	   public User getUser(int userID, String userType, String userName, String email, String password){
	      if(userType == null){
	         return null;
	      }		
	      if(userType.equalsIgnoreCase("Admin")){
	    	  
	         return new Admin(userID, userType, userName, email, password);
	         
	      } else if(userType.equalsIgnoreCase("Buyer")){
	         return new Buyer(userID, userType, userName, email, password);
	         
	      } else if(userType.equalsIgnoreCase("Seller")){
	         return new Seller(userID, userType, userName, email, password);
	      }
		return null;
	      
	   }
}
