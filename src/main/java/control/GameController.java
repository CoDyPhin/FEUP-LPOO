package control;

import com.googlecode.lanterna.screen.Screen;
import model.CursorModel;
import view.*;

import java.io.IOException;

public class GameController {
    private ArenaControl arenaController;
    private PauseMenuControl pauseMenuController;
    private MainMenuControl mainMenuController;
    private GameOverControl gameOverController;
    private LevelSelectControl levelSelectController;
    private StateController currentController;
    private Screen screen;

    public GameController(Screen screen) throws IOException {
        this.mainMenuController = new MainMenuControl(new MainMenuView(screen), new CursorModel(16,8));
        this.arenaController = new ArenaControl(screen);
        this.pauseMenuController = new PauseMenuControl(new PauseMenuView(screen), new CursorModel(16,8));
        this.gameOverController = new GameOverControl(new GameOverView(screen));
        this.levelSelectController = new LevelSelectControl(new LevelSelectView(screen), new CursorModel(16,8));
        this.currentController = this.mainMenuController;
        this.screen = screen;
    }

    public ArenaControl getArenaController() {
        return arenaController;
    }

    public PauseMenuControl getPauseMenuController() {
        return pauseMenuController;
    }

    public MainMenuControl getMainMenuController() {
        return mainMenuController;
    }

    public GameOverControl getGameOverController() {
        return gameOverController;
    }

    public LevelSelectControl getLevelSelectController() {
        return levelSelectController;
    }

    public StateController getCurrentController() {
        return currentController;
    }

    public void setCurrentController(StateController currentController) {
        this.currentController = currentController;
    }

    public Screen getScreen() {
        return screen;
    }

    public void run() throws IOException {
        this.currentController.run(this);
    }
}
