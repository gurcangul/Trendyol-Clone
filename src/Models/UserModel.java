package Models;

import java.util.ArrayList;
import java.util.List;

import Contollers.UserFinderHelper;
import FileIO.IParser;
import FileIO.Parser;
import Observer.Observer;
import Observer.Subject;
import User.User;


public class UserModel implements Subject {
	private List<User> users;
    private List<Observer> observerList = new ArrayList<>();
    private IParser userIO;
    private User loggedInUser;
    /**
	 * @param users
	 * @param observers
	 */
    
	public UserModel() {
        setUserIO(new Parser());
        setUsers(getUserIO().parseUsers());
        for(User user : users)
			System.out.println(user + "   " + users.get(0).getUserName());
	}
	@Override
	public void attach(Observer o) {
    	observerList.add(o);
		
	}
	@Override
	public void detach(Observer o) {
    	observerList.remove(o);
		
	}
	@Override
	public void notifyUpdate(Object arg) {
        for(Observer o: observerList) {
            o.update(arg);
        }		
	}
    public User checkUserIsExist(String username, String password){
    	
		for(User user : users)
			System.out.println(user);
        return UserFinderHelper.checkUserIsExist(username,password,getUsers());
        /*for (User user: users) {
            if(user.getUserName().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;*/
    }
	//getters and setters
    public User getLoggedInUser() {
        return loggedInUser;
    }
    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
        //attach(loggedInUser);
        notifyUpdate(loggedInUser);
    }
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public IParser getUserIO() {
		return userIO;
	}
	public void setUserIO(IParser userIO) {
		this.userIO = userIO;
	}

	 
}
