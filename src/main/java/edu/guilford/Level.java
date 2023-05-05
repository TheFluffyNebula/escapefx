package edu.guilford;

public class Level {
    //attributes
    private int levelNumber;
    private String levelName;
    
    //constructor
    public Level(int levelNumber, String levelName) {
        this.levelNumber = levelNumber;
        this.levelName = levelName;
    }

    //getters and setters
    public int getLevelNumber() {
        return levelNumber;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }


    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

}
