package control;

import model.CursorModel;
import view.ArenaView;
import view.PauseMenuView;

import java.io.IOException;

public class PauseMenuControl implements StateController{
    private PauseMenuView view;
    private CursorModel cursor;

    public PauseMenuControl(PauseMenuView view, CursorModel cursor){
        this.view = view;
        this.cursor = cursor;
        this.view.setCursor(this.cursor);
    }

    public void moveCursorUp(){
        this.cursor.getPosition().setY(this.cursor.getPosition().getY()-2);
        this.view.setCursor(this.cursor);
    }

    public void moveCursorDown(){
        this.cursor.getPosition().setY(this.cursor.getPosition().getY()+2);
        this.view.setCursor(this.cursor);
    }

    public void resetCursor(){
        this.cursor.getPosition().setX(16);
        this.cursor.getPosition().setY(8);
    }

    public void setView(PauseMenuView view) {
        this.view = view;
    }

    @Override
    public void run(GameController gc) throws IOException {
            view.draw(50,25);
            ArenaView.KEYPRESSED key = view.getKey();
            if(key == ArenaView.KEYPRESSED.ARROWUP){
                if(this.cursor.getPosition().getY() > 8)
                    moveCursorUp();
            }
            else if(key == ArenaView.KEYPRESSED.ARROWDOWN){
                if(this.cursor.getPosition().getY() < 10)
                    moveCursorDown();
            }
            else if(key == ArenaView.KEYPRESSED.ENTER){
                if(this.cursor.getPosition().getY() == 8){
                    gc.setCurrentController(gc.getArenaController());
                }
                else{
                    gc.getArenaController().resetArena();
                    gc.setCurrentController(gc.getMainMenuController());
                }
                resetCursor();
            }
    }
}
