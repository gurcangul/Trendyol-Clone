package User;

public class Seller implements User{

	private int userID ;
	private String userType;
	private String userName ;
	private String email;
	private String password;
	
	public Seller(int userID, String userType, String userName, String email, String password){
		setUserID(userID);
		setUserType(userType);
		setUserName(userName);
		setEmail(email);
		setPassword(password);
		
	}
	public Seller(){
		setUserID(0);
		setUserType("");
		setUserName("");
		setEmail("");
		setPassword("");
		
	}
	
	@Override
	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public int getUserID() {
		// TODO Auto-generated method stub
		return userID;
	}

	@Override
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String getUserType() {
		// TODO Auto-generated method stub
		return userType;
	}

	@Override
	public void setUserName(String userName) {
		this.userName  = userName;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
		
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public void createObject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return userID + ", " + userType + ", " + userName + ", " + email
				+ ", " + password;
	}
	
	
	
}
