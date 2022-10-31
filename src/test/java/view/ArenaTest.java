package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.ArenaModel;
import model.BonusModel;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static java.lang.StrictMath.round;
import static org.mockito.Mockito.doReturn;

public class ArenaTest {
    @Test
    public void testDrawWithoutWalls() throws IOException {
        ArenaModel arena = new ArenaModel(50,25);
        arena.createBonus(1);

        arena.initTime();
        Screen screenMock = Mockito.mock(Screen.class);
        AppleView appleMock = Mockito.mock(AppleView.class);
        SnakeView snakeMock = Mockito.mock(SnakeView.class);
        BonusView bonusMock = Mockito.mock(BonusView.class);
        TextGraphics screen = Mockito.mock(TextGraphics.class);
        ArenaView arenaV = new ArenaView(screenMock,snakeMock,appleMock,bonusMock);
        doReturn(screen).when(screenMock).newTextGraphics();
        doReturn(new BonusModel(1,50,25)).when(bonusMock).getBonus();

        arenaV.draw(arena);
        Mockito.verify(screenMock, Mockito.times(1)).clear();
        Mockito.verify(screen, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#393489"));
        Mockito.verify(screen, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');
        Mockito.verify(screen, Mockito.times(1)).disableModifiers(SGR.BLINK);
        Mockito.verify(screen, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(screen, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(screen, Mockito.times(2)).enableModifiers(SGR.BOLD);
        Mockito.verify(screen, Mockito.times(1)).putString(new TerminalPosition(0,arena.getHeight()+1), "Score: ");
        Mockito.verify(screen, Mockito.times(1)).putString(new TerminalPosition((int) round(0.16*arena.getWidth()),arena.getHeight()+1), String.valueOf(arena.getScore().getValue()));
        Mockito.verify(screenMock, Mockito.times(1)).refresh();

    }

    @Test
    public void testDrawWithWallsAndGaps() throws IOException {
        ArenaModel arena = new ArenaModel(50,25);
        arena.createBonus(1);
        arena.createWallsWithGaps();
        arena.initTime();

        Screen screenMock = Mockito.mock(Screen.class);
        AppleView appleMock = Mockito.mock(AppleView.class);
        SnakeView snakeMock = Mockito.mock(SnakeView.class);
        BonusView bonusMock = Mockito.mock(BonusView.class);
        TextGraphics screen = Mockito.mock(TextGraphics.class);
        ArenaView arenaV = new ArenaView(screenMock,snakeMock,appleMock,bonusMock);
        doReturn(screen).when(screenMock).newTextGraphics();
        doReturn(new BonusModel(1,50,25)).when(bonusMock).getBonus();

        arenaV.draw(arena);
        Mockito.verify(screenMock, Mockito.times(1)).clear();
        Mockito.verify(screen, Mockito.times(138)).setForegroundColor(TextColor.Factory.fromString("#0000FF"));
        for (int i = 0; i < 138 ; i++) {
            Mockito.verify(screen, Mockito.times(1)).putString(new TerminalPosition(arena.getWalls().get(i).getPosition().getX(), arena.getWalls().get(i).getPosition().getY()), "W");
        }
        Mockito.verify(screen, Mockito.times(140)).enableModifiers(SGR.BOLD);
        Mockito.verify(screenMock, Mockito.times(1)).refresh();

    }

    @Test
    public void testDrawWithWalls() throws IOException {
        ArenaModel arena = new ArenaModel(50,25);
        arena.createBonus(1);
        arena.createWalls();
        arena.initTime();
        Screen screenMock = Mockito.mock(Screen.class);
        AppleView appleMock = Mockito.mock(AppleView.class);
        SnakeView snakeMock = Mockito.mock(SnakeView.class);
        BonusView bonusMock = Mockito.mock(BonusView.class);
        TextGraphics screen = Mockito.mock(TextGraphics.class);
        ArenaView arenaV = new ArenaView(screenMock,snakeMock,appleMock,bonusMock);
        doReturn(screen).when(screenMock).newTextGraphics();
        doReturn(new BonusModel(1,50,25)).when(bonusMock).getBonus();

        arenaV.draw(arena);
        Mockito.verify(screenMock, Mockito.times(1)).clear();
        for (int i = 0; i < 198 ; i++) {
            Mockito.verify(screen, Mockito.times(1)).putString(new TerminalPosition(arena.getWalls().get(i).getPosition().getX(), arena.getWalls().get(i).getPosition().getY()), "W");
        }
        Mockito.verify(screen, Mockito.times(200)).enableModifiers(SGR.BOLD);
        Mockito.verify(screenMock, Mockito.times(1)).refresh();

    }
}
