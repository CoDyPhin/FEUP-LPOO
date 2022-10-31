package model;

public class CursorModel {
    private Position position;
    private String body;

    public CursorModel(int x, int y){
        this.position = new Position(x,y);
        this.body = "->";
    }

    public Position getPosition() {
        return position;
    }

    public String getBody() {
        return body;
    }

}
