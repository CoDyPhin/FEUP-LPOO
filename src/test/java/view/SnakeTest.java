package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


import model.Position;
import model.SnakeModel;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;



public class SnakeTest {
    @Test
    public void testDraw() throws IOException {
        SnakeModel snake = new SnakeModel(new Position(3,3));
        TextGraphics screen = Mockito.mock(TextGraphics.class);
        SnakeView appleV = new SnakeView(snake);
        appleV.draw(screen);
        Mockito.verify(screen, Mockito.times(3)).setForegroundColor(TextColor.Factory.fromString("#08AF08"));
        Mockito.verify(screen, Mockito.times(3)).enableModifiers(SGR.BOLD);
        Mockito.verify(screen, Mockito.times(1)).putString(new TerminalPosition(snake.getBody().get(0).getX(), snake.getBody().get(0).getY()), "O");
        Mockito.verify(screen, Mockito.times(1)).putString(new TerminalPosition(snake.getBody().get(1).getX(), snake.getBody().get(1).getY()), "O");
        Mockito.verify(screen, Mockito.times(1)).putString(new TerminalPosition(snake.getBody().get(2).getX(), snake.getBody().get(2).getY()), "O");
    }
}
