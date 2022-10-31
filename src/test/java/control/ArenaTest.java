package control;

import com.googlecode.lanterna.screen.Screen;
import model.SnakeModel;
import org.junit.Test;
import org.mockito.Mockito;
import view.ArenaView;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

public class ArenaTest{
    @Test
    public void testArenaToPauseMenu() throws IOException {
        Screen screenMock = Mockito.mock(Screen.class);
        ArenaView arenaMock = Mockito.mock(ArenaView.class);
        GameController gc = new GameController(screenMock);

        gc.getArenaController().setView(arenaMock);
        gc.setCurrentController(gc.getArenaController());

        doReturn(ArenaView.KEYPRESSED.P).when(arenaMock).getKey();
        gc.run();

        assertEquals(PauseMenuControl.class, gc.getCurrentController().getClass());

    }

    @Test
    public void testSnakeMovementOnArena() throws IOException {
        Screen screenMock = Mockito.mock(Screen.class);
        ArenaView arenaMock = Mockito.mock(ArenaView.class);
        GameController gc = new GameController(screenMock);

        gc.getArenaController().setView(arenaMock);
        gc.setCurrentController(gc.getArenaController());

        doReturn(ArenaView.KEYPRESSED.ARROWUP).when(arenaMock).getKey();
        gc.run();

        assertEquals(gc.getArenaController().getSelectedArena().getSnake().getDirection(), SnakeModel.Orientation.UP);

        doReturn(ArenaView.KEYPRESSED.ARROWDOWN).when(arenaMock).getKey();
        gc.run();

        assertEquals(gc.getArenaController().getSelectedArena().getSnake().getDirection(), SnakeModel.Orientation.UP);

        doReturn(ArenaView.KEYPRESSED.ARROWLEFT).when(arenaMock).getKey();
        gc.run();

        assertEquals(gc.getArenaController().getSelectedArena().getSnake().getDirection(), SnakeModel.Orientation.LEFT);

        doReturn(ArenaView.KEYPRESSED.ARROWRIGHT).when(arenaMock).getKey();
        gc.run();

        assertEquals(gc.getArenaController().getSelectedArena().getSnake().getDirection(), SnakeModel.Orientation.LEFT);

        doReturn(ArenaView.KEYPRESSED.ARROWDOWN).when(arenaMock).getKey();
        gc.run();

        assertEquals(gc.getArenaController().getSelectedArena().getSnake().getDirection(), SnakeModel.Orientation.DOWN);

        doReturn(ArenaView.KEYPRESSED.ARROWUP).when(arenaMock).getKey();
        gc.run();

        assertEquals(gc.getArenaController().getSelectedArena().getSnake().getDirection(), SnakeModel.Orientation.DOWN);

        doReturn(ArenaView.KEYPRESSED.ARROWRIGHT).when(arenaMock).getKey();
        gc.run();

        assertEquals(gc.getArenaController().getSelectedArena().getSnake().getDirection(), SnakeModel.Orientation.RIGHT);

        doReturn(ArenaView.KEYPRESSED.ARROWLEFT).when(arenaMock).getKey();
        gc.run();

        assertEquals(gc.getArenaController().getSelectedArena().getSnake().getDirection(), SnakeModel.Orientation.RIGHT);
    }

}
