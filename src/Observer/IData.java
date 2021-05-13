package Observer;

import java.util.List;

import User.User;

public interface IData {
    public User getUser(String userName);
    public void putUser(User user);
    public List<String> getUserNameList();
}
