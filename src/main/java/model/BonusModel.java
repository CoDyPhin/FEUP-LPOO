package model;

import java.util.Random;

public class BonusModel {
    private int value;
    private boolean display;
    private Position position;
    private int showTime;

    public BonusModel(int value, int width, int height){
        this.value = value;
        this.display = false;
        Random random = new Random();
        this.position = new Position(random.nextInt(width - 2) + 1,random.nextInt(height - 2) + 1);
        this.showTime = 40;
    }

    public int getValue() {
        return value;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public void decrementShowTime() {
        this.showTime--;
    }

    public int getShowTime() {
        return showTime;
    }
}
