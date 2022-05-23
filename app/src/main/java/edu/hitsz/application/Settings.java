package edu.hitsz.application;
import java.io.Serializable;

public class Settings implements Serializable {
    public enum Difficulty{Casual,Medium,Hard};
    public enum SystemMusicState{ON,OFF};
    public static Difficulty difficulty;
    public static SystemMusicState systemMusicState;
}
