package control;

import model.CursorModel;
import view.ArenaView;
import view.MainMenuView;

import java.io.IOException;

public class MainMenuControl implements StateController{

    private MainMenuView view;
    private CursorModel cursor;

    public MainMenuControl(MainMenuView view, CursorModel cursor){
        this.view = view;
        this.cursor = cursor;
        this.view.setCursor(this.cursor);
    }

    public MainMenuView getView() {
        return view;
    }

    public void setView(MainMenuView view) {
        this.view = view;
    }

    public void moveCursorUp(){
        this.cursor.getPosition().setY(this.cursor.getPosition().getY()-2);
        this.view.setCursor(this.cursor);
    }

    public void moveCursorDown(){
        this.cursor.getPosition().setY(this.cursor.getPosition().getY()+2);
        this.view.setCursor(this.cursor);
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
                    gc.setCurrentController(gc.getLevelSelectController());
                }
                else{
                    gc.setCurrentController(null);
                    gc.getScreen().close();
                }
            }
    }
}
