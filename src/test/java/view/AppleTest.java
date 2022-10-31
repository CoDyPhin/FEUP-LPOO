package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.AppleModel;
import org.junit.Test;
import org.mockito.Mockito;

public class AppleTest {
    @Test
    public void testDraw(){
        AppleModel apple = new AppleModel(10,10);
        TextGraphics screen = Mockito.mock(TextGraphics.class);
        AppleView appleV = new AppleView(apple);
        appleV.draw(screen);
        Mockito.verify(screen, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#e71837"));
        Mockito.verify(screen, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(screen, Mockito.times(1)).putString(new TerminalPosition(apple.getPosition().getX(), apple.getPosition().getY()), "A");
    }
}
