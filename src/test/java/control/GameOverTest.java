package control;

import com.googlecode.lanterna.screen.Screen;
import org.junit.Test;
import org.mockito.Mockito;
import view.ArenaView;
import view.GameOverView;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

public class GameOverTest {
    @Test
    public void testGameOverMenuToMainMenu() throws IOException {
        Screen screenMock = Mockito.mock(Screen.class);
        GameOverView gameOverMock = Mockito.mock(GameOverView.class);
        GameController gc = new GameController(screenMock);

        gc.getGameOverController().setView(gameOverMock);
        gc.setCurrentController(gc.getGameOverController());

        doReturn(ArenaView.KEYPRESSED.ENTER).when(gameOverMock).getKey();
        gc.run();

        assertEquals(MainMenuControl.class, gc.getCurrentController().getClass());

    }
}
