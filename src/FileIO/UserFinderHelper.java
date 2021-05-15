package FileIO;

import java.util.List;

import User.User;

public class UserFinderHelper {

    public static User findUserByUsername(String username,List<User> users){
        for (User user: users) {
            if (user.getUserName().equals(username))
                return user;
        }
        return null;
    }
    public static User checkUserIsExist(String username, String password,List<User> users){
        for (User user: users) {
            if(user.getUserName().equals(username) && user.getPassword().equals(password)){
            	System.out.println(user);
                return user;
            }
        }
        return null;
    }
    public static User findUserByUsername(List<User> users, String username){
        for (User user: users) {
            if (user.getUserName().equals(username))
                return user;
        }
        return null;
    }
    


}
