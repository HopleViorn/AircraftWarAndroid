package edu.hitsz.user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    public int userID;
    public String Name;
    public int score;
    public Date date;
    public User(int userID,String Name,int score,Date date){
        this.userID=userID;
        this.Name=Name;
        this.score=score;
        this.date=date;
    }
}
