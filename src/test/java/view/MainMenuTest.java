package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.CursorModel;
import model.Position;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.doReturn;

public class MainMenuTest {
    @Test
    public void testDraw() throws IOException {
        Screen screen = Mockito.mock(Screen.class);
        MainMenuView menuV = new MainMenuView(screen);
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        CursorModel cursorMock = Mockito.mock(CursorModel.class);
        menuV.setCursor(cursorMock);
        doReturn(new Position(16,8)).when(cursorMock).getPosition();
        doReturn(new Position(16,8)).when(cursorMock).getPosition();
        doReturn("->").when(cursorMock).getBody();
        doReturn(graphicsMock).when(screen).newTextGraphics();
        int width = 50, height = 25;
        menuV.draw(width,height);
        Mockito.verify(screen, Mockito.times(1)).clear();
        Mockito.verify(graphicsMock, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#336699"));
        Mockito.verify(graphicsMock, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width,height), ' ');
        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(graphicsMock, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(16,4), "WELCOME TO SNAKE");
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(16, 8), "->");
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(22, 8), "Play");
        Mockito.verify(graphicsMock, Mockito.times(1)).putString(new TerminalPosition(22, 10), "Exit");
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }
}
