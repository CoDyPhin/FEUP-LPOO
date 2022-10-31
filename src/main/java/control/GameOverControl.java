package control;

import view.ArenaView;
import view.GameOverView;

import java.io.IOException;

public class GameOverControl implements StateController{
    private GameOverView view;

    public GameOverControl(GameOverView view){
        this.view = view;
    }

    public void setView(GameOverView view) {
        this.view = view;
    }

    @Override
    public void run(GameController gc) throws IOException {
            view.draw(50,25, gc.getArenaController().getSelectedArena().getScore());
            ArenaView.KEYPRESSED key = view.getKey();
            if(key == ArenaView.KEYPRESSED.ENTER) {
                gc.getArenaController().resetArena();
                gc.setCurrentController(gc.getMainMenuController());
            }
    }

}
