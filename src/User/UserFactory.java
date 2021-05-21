package User;



public class UserFactory {
	   //factory pattern is used
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
