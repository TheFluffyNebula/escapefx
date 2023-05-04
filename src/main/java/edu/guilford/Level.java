package edu.guilford;

public class Level {
    //attributes
    private int levelNumber;
    private String levelState;
    private String levelName;
    // can be notThereYet, inProgress, or complete
    
    //constructor
    public Level(int levelNumber, String levelState, String levelName) {
        this.levelNumber = levelNumber;
        this.levelState = levelState;
        this.levelName = levelName;
    }

    //getters and setters
    public int getLevelNumber() {
        return levelNumber;
    }

    public String getLevelState() {
        return levelState;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public void setLevelState(String levelState) {
        this.levelState = levelState;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

}
