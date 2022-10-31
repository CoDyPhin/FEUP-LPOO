package control;

import com.googlecode.lanterna.screen.Screen;
import org.junit.Test;
import org.mockito.Mockito;
import view.ArenaView;
import view.LevelSelectView;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

public class LevelSelectTest {
    @Test
    public void testLevelSelectMenuToArena() throws IOException {
        Screen screenMock = Mockito.mock(Screen.class);
        LevelSelectView levelSelectMock = Mockito.mock(LevelSelectView.class);
        GameController gc = new GameController(screenMock);

        gc.getLevelSelectController().setView(levelSelectMock);
        gc.setCurrentController(gc.getLevelSelectController());

        doReturn(ArenaView.KEYPRESSED.ENTER).when(levelSelectMock).getKey();

        gc.run();
        assertEquals(ArenaControl.class, gc.getCurrentController().getClass());

        gc = new GameController(screenMock);
        gc.getLevelSelectController().setView(levelSelectMock);
        gc.setCurrentController(gc.getLevelSelectController());

        doReturn(ArenaView.KEYPRESSED.ARROWDOWN).when(levelSelectMock).getKey();
        gc.run();
        doReturn(ArenaView.KEYPRESSED.ENTER).when(levelSelectMock).getKey();
        gc.run();
        assertEquals(ArenaControl.class, gc.getCurrentController().getClass());

        gc = new GameController(screenMock);
        gc.getLevelSelectController().setView(levelSelectMock);
        gc.setCurrentController(gc.getLevelSelectController());

        doReturn(ArenaView.KEYPRESSED.ARROWDOWN).when(levelSelectMock).getKey();
        gc.run();
        doReturn(ArenaView.KEYPRESSED.ARROWDOWN).when(levelSelectMock).getKey();
        gc.run();
        doReturn(ArenaView.KEYPRESSED.ENTER).when(levelSelectMock).getKey();
        gc.run();
        assertEquals(ArenaControl.class, gc.getCurrentController().getClass());

    }

    @Test
    public void testLevelSelectMenuToMainMenu() throws IOException {
        Screen screenMock = Mockito.mock(Screen.class);
        LevelSelectView levelSelectMock = Mockito.mock(LevelSelectView.class);
        GameController gc = new GameController(screenMock);

        gc.getLevelSelectController().setView(levelSelectMock);
        gc.setCurrentController(gc.getLevelSelectController());

        doReturn(ArenaView.KEYPRESSED.ARROWDOWN).when(levelSelectMock).getKey();
        gc.run();
        doReturn(ArenaView.KEYPRESSED.ARROWDOWN).when(levelSelectMock).getKey();
        gc.run();
        doReturn(ArenaView.KEYPRESSED.ARROWDOWN).when(levelSelectMock).getKey();
        gc.run();
        doReturn(ArenaView.KEYPRESSED.ENTER).when(levelSelectMock).getKey();
        gc.run();

        assertEquals(MainMenuControl.class, gc.getCurrentController().getClass());

    }
}
