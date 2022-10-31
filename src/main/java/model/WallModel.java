package model;

public class WallModel{
    private Position position;

    public WallModel(int x, int y){
        this.position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
