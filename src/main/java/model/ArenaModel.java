package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.StrictMath.round;

public class ArenaModel {
    private int width, height;
    private SnakeModel snake = new SnakeModel(new Position(3,3));
    private AppleModel apple;
    private List<WallModel> walls = new ArrayList<>();
    private ScoreModel score = new ScoreModel();
    private BonusModel bonus;
    private Date time;

    public ArenaModel(int width, int height){
        this.width = width;
        this.height = height;
        this.apple = new AppleModel(width,height);
    }

    public void createBonus(int value){
        this.bonus = new BonusModel(value,this.width,this.height);
        while(checkBonusPosition()){
            this.bonus = new BonusModel(value,this.width,this.height);
        }
    }

    public BonusModel getBonus() {
        return bonus;
    }

    public ScoreModel getScore() {
        return score;
    }

    public void initTime(){
        this.time = new Date();
    }

    public Date getTime() {
        return time;
    }

    public SnakeModel getSnake() {
        return snake;
    }

    public AppleModel getApple() {
        return apple;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int weight) {
        this.width = weight;
    }

    public void snakeGrow(Position p){
        this.snake.addPosition(p);
    }

    public void resetSnake(){
        this.snake = new SnakeModel(new Position(3,3));
    }

    public List<WallModel> getWalls() {
        return walls;
    }

    public Boolean checkApplePosition(){
        for (int i = 0; i < this.snake.getBodySize(); i++) {
            if(this.apple.getPosition().equals(this.snake.getBody().get(i))){
                return true;
            }
        }
        for (WallModel wall : this.walls) {
            if (this.apple.getPosition().equals(wall.getPosition()))
                return true;
        }
        if(this.apple.getPosition().equals(this.bonus.getPosition()))
            return true;
        return false;
    }
    public Boolean checkBonusPosition(){
        for (int i = 0; i < this.snake.getBodySize(); i++) {
            if(this.bonus.getPosition().equals(this.snake.getBody().get(i))){
                return true;
            }
        }
        for (WallModel wall : this.walls) {
            if (this.bonus.getPosition().equals(wall.getPosition()))
                return true;
        }
        if(this.bonus.getPosition().equals(this.apple.getPosition()))
            return true;
        return false;
    }


    public void createWalls(){
        for (int i = 0; i < this.width; i++) {
            this.walls.add(new WallModel(i, 0));
            this.walls.add(new WallModel(i, this.height - 1));
        }

        for (int i = 1; i < this.height - 1; i++) {
            this.walls.add(new WallModel(0, i));
            this.walls.add(new WallModel(this.width - 1, i));
        }
        for (int i = this.width/3; i < 2*this.width/3 ; i++) {
            this.walls.add(new WallModel(i,this.height/4));
            this.walls.add(new WallModel(i,3*this.height/4));
        }
        for (int i = this.height/3; i <= 2*this.height/3; i++) {
            this.walls.add(new WallModel(this.width/4,i));
            this.walls.add(new WallModel(3*this.width/4,i));
        }
    }

    public void createWallsWithGaps(){
        for (int i = 0; i < this.width; i++) {
            if(i == round(this.width*0.24) || i == round(this.width*0.8))
                continue;
            this.walls.add(new WallModel(i, 0));
            this.walls.add(new WallModel(i, this.height - 1));
        }

        for (int i = 1; i < this.height - 1; i++) {
            if(i == round(this.height*0.24) || i == round(this.height*0.8))
                continue;
            this.walls.add(new WallModel(0, i));
            this.walls.add(new WallModel(this.width - 1, i));
        }
    }

    public Boolean checkWallCollision(){
        for (int i = 0; i < walls.size(); i++) {
            if(walls.get(i).getPosition().equals(snake.getBody().get(0)))
                return true;
        }
        return false;
    }

}
