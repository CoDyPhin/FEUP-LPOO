package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.ScoreModel;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.doReturn;

public class GameOverTest {
    @Test
    public void testDraw() throws IOException {
        ScoreModel score = new ScoreModel();
        Screen screen = Mockito.mock(Screen.class);
        GameOverView menuV = new GameOverView(screen);
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        doReturn(graphicsMock).when(screen).newTextGraphics();
        int width = 50, height = 25;
        menuV.draw(width,height,score);
        Mockito.verify(screen, Mockito.times(1)).clear();
        Mockito.verify(graphicsMock, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#336699"));
        Mockito.verify(graphicsMock, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width,height), ' ');
        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(graphicsMock, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(19, 4), "GAME OVER");
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(15,6), " Your Score was: ");
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(22,8), String.valueOf(score.getValue()));
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(7,10 ), "Press 'ENTER' To Return To Main Menu");
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }
}
