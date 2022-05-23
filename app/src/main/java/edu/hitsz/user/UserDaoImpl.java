package edu.hitsz.user;

import edu.hitsz.application.Settings;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static edu.hitsz.application.MainActivity.userDao;

public class UserDaoImpl implements UserDao, Serializable {
    private List<User> userList;
    public UserDaoImpl() {
        userList= new LinkedList<>();
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public User findUser(int userID) {
        return userList.stream().filter(e->e.userID==userID).findAny().orElse(null);
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public void deleteUser(int userID) {
        userList.removeIf(e->e.userID==userID);
    }

    @Override
    public void readFromFile() {
        String PATH="saves/";
        switch (Settings.difficulty){
            case Casual: PATH=PATH+"save0.data";break;
            case Medium: PATH=PATH+"save1.data";break;
            case Hard:   PATH=PATH+"save2.data";break;
            default:
                throw new IllegalStateException("Unexpected value: " + Settings.difficulty);
        }
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(PATH))){
            userDao=(UserDaoImpl) ois.readObject();
        }catch(Exception err) {
            err.printStackTrace();
        }
        if(userDao==null) userDao=new UserDaoImpl();
    }

    @Override
    public void writeToFile() {
        String PATH="saves/";
        switch (Settings.difficulty){
            case Casual: PATH=PATH+"save0.data";break;
            case Medium: PATH=PATH+"save1.data";break;
            case Hard:   PATH=PATH+"save2.data";break;
            default:
                throw new IllegalStateException("Unexpected value: " + Settings.difficulty);
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH));
            oos.writeObject(userDao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
