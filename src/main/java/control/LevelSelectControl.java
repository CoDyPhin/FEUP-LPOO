package control;

import model.CursorModel;
import view.ArenaView;
import view.LevelSelectView;

import java.io.IOException;

public class LevelSelectControl implements StateController{
    private LevelSelectView view;
    private CursorModel cursor;

    public LevelSelectControl(LevelSelectView view, CursorModel cursor){
        this.view = view;
        this.cursor = cursor;
        this.view.setCursor(cursor);
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

    public void setView(LevelSelectView view) {
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
                if(this.cursor.getPosition().getY() < 14)
                    moveCursorDown();
            }
            else if(key == ArenaView.KEYPRESSED.ENTER){
                if(this.cursor.getPosition().getY() == 8){
                    gc.getArenaController().setSelectedArena(0);
                    gc.getArenaController().getSelectedArena().initTime();
                    gc.setCurrentController(gc.getArenaController());
                }
                else if(this.cursor.getPosition().getY() == 10){
                    gc.getArenaController().setSelectedArena(1);
                    gc.getArenaController().getSelectedArena().initTime();
                    gc.setCurrentController(gc.getArenaController());
                }
                else if(this.cursor.getPosition().getY() == 12){
                    gc.getArenaController().setSelectedArena(2);
                    gc.getArenaController().getSelectedArena().initTime();
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
