package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.BonusModel;
import org.junit.Test;
import org.mockito.Mockito;

public class BonusTest {
    @Test
    public void testDraw(){
        BonusModel bonus = new BonusModel(2,10,10);
        TextGraphics screen = Mockito.mock(TextGraphics.class);
        BonusView bonusV = new BonusView(bonus);
        bonus.setDisplay(true);
        bonusV.draw(screen);
        Mockito.verify(screen, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#ffa500"));
        if(bonus.getShowTime() <= 20) {
            Mockito.verify(screen, Mockito.times(1)).enableModifiers(SGR.BLINK);
        }
        else{
            Mockito.verify(screen, Mockito.times(1)).enableModifiers(SGR.BOLD);
        }
        Mockito.verify(screen, Mockito.times(1)).putString(new TerminalPosition(bonus.getPosition().getX(), bonus.getPosition().getY()), "B");

    }
}
