package model;

public class ScoreModel {
    int value;

    public ScoreModel(){
        int value = 0;
    }

    public int getValue() {
        return value;
    }

    public void incrementScore(int value){
        this.value+= value;
    }

    public void reset(){
        this.value = 0;
    }

}
