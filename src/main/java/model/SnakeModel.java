package model;

import java.util.ArrayList;
import java.util.List;

public class SnakeModel {
    private List<Position> body;
    private Orientation direction;

    public enum Orientation {UP, DOWN, LEFT, RIGHT}

    public SnakeModel(Position p){
        this.body = new ArrayList<>();
        this.direction = Orientation.RIGHT;
        body.add(p);
        body.add(new Position(p.getX()-1,p.getY()));
        body.add(new Position(p.getX()-2,p.getY()));
    }

    public void addPosition(Position p){
        body.add(p);
    }

    public List<Position> getBody(){
        return this.body;
    }

    public int getBodySize(){
        return this.body.size();
    }

    public void removeFromBackToFront(Position p){
        this.body.remove(getBodySize()-1);
        this.body.add(0,p);
    }

    public Orientation getDirection() {
        return direction;
    }

    public void setDirection(Orientation direction) {
        this.direction = direction;
    }

    public Boolean checkBodyCollision(){
        for (int i = 1; i < getBodySize(); i++) {
            if(getBody().get(0).equals(getBody().get(i)))
                return true;
        }
        return false;
    }
}
