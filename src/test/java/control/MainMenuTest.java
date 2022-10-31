package control;

import com.googlecode.lanterna.screen.Screen;
import org.junit.Test;
import org.mockito.Mockito;
import view.ArenaView;
import view.MainMenuView;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;

public class MainMenuTest {
    @Test
    public void testMainMenuToLevelSelectMenu() throws IOException {
        Screen screenMock = Mockito.mock(Screen.class);
        MainMenuView mainMenuMock = Mockito.mock(MainMenuView.class);
        GameController gc = new GameController(screenMock);

        gc.getMainMenuController().setView(mainMenuMock);

        doReturn(ArenaView.KEYPRESSED.ENTER).when(mainMenuMock).getKey();

        gc.run();
        assertEquals(LevelSelectControl.class, gc.getCurrentController().getClass());

        gc.setCurrentController(gc.getMainMenuController());
        doReturn(ArenaView.KEYPRESSED.ARROWDOWN).when(mainMenuMock).getKey();
        gc.run();
        assertEquals(MainMenuControl.class, gc.getCurrentController().getClass());

        doReturn(ArenaView.KEYPRESSED.ENTER).when(mainMenuMock).getKey();
        gc.run();

        assertNull(gc.getCurrentController());

    }

    @Test
    public void testMainMenuToNull() throws IOException {
        Screen screenMock = Mockito.mock(Screen.class);
        MainMenuView mainMenuMock = Mockito.mock(MainMenuView.class);
        GameController gc = new GameController(screenMock);

        gc.getMainMenuController().setView(mainMenuMock);

        gc.setCurrentController(gc.getMainMenuController());
        doReturn(ArenaView.KEYPRESSED.ARROWDOWN).when(mainMenuMock).getKey();
        gc.run();
        assertEquals(MainMenuControl.class, gc.getCurrentController().getClass());

        doReturn(ArenaView.KEYPRESSED.ENTER).when(mainMenuMock).getKey();
        gc.run();

        assertNull(gc.getCurrentController());

    }
}
