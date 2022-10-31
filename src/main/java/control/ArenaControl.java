package control;

import com.googlecode.lanterna.screen.Screen;
import model.ArenaFactory;
import model.ArenaModel;
import model.Position;
import model.SnakeModel;
import view.AppleView;
import view.ArenaView;
import view.BonusView;
import view.SnakeView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArenaControl implements StateController{
    private ArenaView view;
    private ArenaModel selectedArena;
    private List<ArenaModel> arenas = new ArrayList<>();
    public ArenaControl(Screen screen) throws IOException {
        ArenaFactory factory = new ArenaFactory();
        for (int i = 1; i < 4 ; i++) {
            arenas.add(factory.createArena(50, 23,i));
        }
        this.view = new ArenaView(screen, new SnakeView(arenas.get(0).getSnake()), new AppleView(arenas.get(0).getApple()), new BonusView(arenas.get(0).getBonus()));
        selectedArena = arenas.get(0);
    }

    public ArenaModel getSelectedArena() {
        return selectedArena;
    }

    public ArenaView getView() {
        return view;
    }

    public void setView(ArenaView view) {
        this.view = view;
    }

    public void setSelectedArena(int index) throws IOException {
        this.view = new ArenaView(view.getScreen(), new SnakeView(arenas.get(index).getSnake()), new AppleView(arenas.get(index).getApple()), new BonusView(arenas.get(index).getBonus()));
        this.selectedArena = arenas.get(index);
    }


    public void SnakeMoveUp(){
        int newY = selectedArena.getSnake().getBody().get(0).getY()-1;
        if(newY < 0){
           newY+= this.selectedArena.getHeight();
        }
        this.selectedArena.getSnake().removeFromBackToFront(new Position(selectedArena.getSnake().getBody().get(0).getX(), newY));
        this.selectedArena.getSnake().setDirection(SnakeModel.Orientation.UP);
    }

    public void SnakeMoveDown(){
        this.selectedArena.getSnake().removeFromBackToFront(new Position(selectedArena.getSnake().getBody().get(0).getX(),(selectedArena.getSnake().getBody().get(0).getY()+1)%selectedArena.getHeight()));
        this.selectedArena.getSnake().setDirection(SnakeModel.Orientation.DOWN);
    }

    public void SnakeMoveRight(){
        this.selectedArena.getSnake().removeFromBackToFront(new Position((selectedArena.getSnake().getBody().get(0).getX()+1)%selectedArena.getWidth(),selectedArena.getSnake().getBody().get(0).getY()));
        this.selectedArena.getSnake().setDirection(SnakeModel.Orientation.RIGHT);
    }

    public void SnakeMoveLeft(){
        int newX = selectedArena.getSnake().getBody().get(0).getX()-1;
        if(newX < 0)
            newX += this.selectedArena.getWidth();
        this.selectedArena.getSnake().removeFromBackToFront(new Position(newX,selectedArena.getSnake().getBody().get(0).getY()));
        this.selectedArena.getSnake().setDirection(SnakeModel.Orientation.LEFT);
    }

    public void resetArena(){
        this.selectedArena.getScore().reset();
        this.selectedArena.resetSnake();
        view.updateSnakeModel(this.selectedArena.getSnake());
    }

    public Boolean checkOppositeDirection(SnakeModel.Orientation newDirection){
        if((this.selectedArena.getSnake().getDirection() == SnakeModel.Orientation.RIGHT && newDirection == SnakeModel.Orientation.LEFT) || (this.selectedArena.getSnake().getDirection() == SnakeModel.Orientation.LEFT && newDirection == SnakeModel.Orientation.RIGHT))
            return true;
        else if((this.selectedArena.getSnake().getDirection() == SnakeModel.Orientation.UP && newDirection == SnakeModel.Orientation.DOWN) || (this.selectedArena.getSnake().getDirection() == SnakeModel.Orientation.DOWN && newDirection == SnakeModel.Orientation.UP))
            return true;
        return false;
    }

    public void contMovement(SnakeModel.Orientation lastmove) {
        switch (lastmove) {
            case UP:
                SnakeMoveUp();
                break;
            case DOWN:
                SnakeMoveDown();
                break;
            case RIGHT:
                SnakeMoveRight();
                break;
            case LEFT:
                SnakeMoveLeft();
                break;
        }
    }

    @Override
    public void run(GameController gc) throws IOException {
            if(selectedArena.getSnake().checkBodyCollision() || selectedArena.checkWallCollision()){
                gc.setCurrentController(gc.getGameOverController());
                return;
            }
            view.draw(this.selectedArena);
            ArenaView.KEYPRESSED key = view.getKey();
            if(key == ArenaView.KEYPRESSED.ARROWUP){
                if(!checkOppositeDirection(SnakeModel.Orientation.UP)){
                    SnakeMoveUp();
                }
            }
            else if(key == ArenaView.KEYPRESSED.ARROWDOWN){
                if(!checkOppositeDirection(SnakeModel.Orientation.DOWN)){
                    SnakeMoveDown();
                }
            }
            else if(key == ArenaView.KEYPRESSED.ARROWRIGHT){
                if(!checkOppositeDirection(SnakeModel.Orientation.RIGHT)){
                    SnakeMoveRight();
                }
            }
            else if(key == ArenaView.KEYPRESSED.ARROWLEFT){
                if(!checkOppositeDirection(SnakeModel.Orientation.LEFT)){
                    SnakeMoveLeft();
                }
            }
            else if(key == ArenaView.KEYPRESSED.P){
                gc.setCurrentController(gc.getPauseMenuController());
            }

            else if(key == ArenaView.KEYPRESSED.CONTINUEMOV)
                contMovement(selectedArena.getSnake().getDirection());
    }
}
