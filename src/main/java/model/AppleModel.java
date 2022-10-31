package model;

import java.util.Random;

public class AppleModel {
    private Position position;

    public AppleModel(int width, int height){
        Random random = new Random();
        this.position = new Position(random.nextInt(width - 2) + 1,random.nextInt(height - 2) + 1);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(int width, int height) {
        Random random = new Random();
        this.position = new Position(random.nextInt(width - 2) + 1,random.nextInt(height - 2) + 1);
    }

}
