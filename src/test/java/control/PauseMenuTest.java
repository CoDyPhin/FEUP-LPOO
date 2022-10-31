package control;

import com.googlecode.lanterna.screen.Screen;
import org.junit.Test;
import org.mockito.Mockito;
import view.ArenaView;
import view.PauseMenuView;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

public class PauseMenuTest {
    @Test
    public void testPauseMenuToArena() throws IOException {
        Screen screenMock = Mockito.mock(Screen.class);
        PauseMenuView pauseMenuMock = Mockito.mock(PauseMenuView.class);
        GameController gc = new GameController(screenMock);

        gc.getPauseMenuController().setView(pauseMenuMock);
        gc.setCurrentController(gc.getPauseMenuController());

        doReturn(ArenaView.KEYPRESSED.ENTER).when(pauseMenuMock).getKey();
        gc.run();

        assertEquals(ArenaControl.class, gc.getCurrentController().getClass());

    }

    @Test
    public void testPauseMenuToMainMenu() throws IOException {
        Screen screenMock = Mockito.mock(Screen.class);
        PauseMenuView pauseMenuMock = Mockito.mock(PauseMenuView.class);
        GameController gc = new GameController(screenMock);

        gc.getPauseMenuController().setView(pauseMenuMock);
        gc.setCurrentController(gc.getPauseMenuController());

        doReturn(ArenaView.KEYPRESSED.ARROWDOWN).when(pauseMenuMock).getKey();
        gc.run();
        doReturn(ArenaView.KEYPRESSED.ENTER).when(pauseMenuMock).getKey();
        gc.run();

        assertEquals(MainMenuControl.class, gc.getCurrentController().getClass());

    }
}
