package edu.hitsz.user;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers() ;

    public User findUser(int userID);
    public void addUser(User user);
    public void deleteUser(int userID);
    public void readFromFile();
    public void writeToFile();
}
