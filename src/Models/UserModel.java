package Models;

import java.util.ArrayList;
import java.util.List;

import FileIO.IUserIO;
import Observer.IObserver;
import Observer.ISubject;
import User.User;


public class UserModel implements ISubject {
	private List<User> users;
    private List<IObserver> observers = new ArrayList<>();
    private IUserIO userIO;

    /**
	 * @param users
	 * @param observers
	 */
    
	public UserModel() {
        this.users = userIO.parseUsers();
	}

	@Override
	public void attach(IObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(IObserver o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyUpdate(Object arg) {
		// TODO Auto-generated method stub
		
	}

	 
}
