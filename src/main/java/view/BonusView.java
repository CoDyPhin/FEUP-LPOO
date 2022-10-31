package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.BonusModel;

import java.util.Random;

public class BonusView {
    private BonusModel bonus;

    public BonusView(BonusModel bonus){
        this.bonus = bonus;
    }

    public void draw(TextGraphics graphics){
        Random random = new Random();
        int result = random.nextInt(50-1) + 1;
        if(!this.bonus.isDisplay() && result == 1){
            this.bonus.setDisplay(true);
        }
        if(this.bonus.isDisplay()){
            graphics.setForegroundColor(TextColor.Factory.fromString("#ffa500"));
            if(bonus.getShowTime() <= 20){
                graphics.enableModifiers(SGR.BLINK);
            }
            else
                graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(this.bonus.getPosition().getX(), this.bonus.getPosition().getY()), "B");
            this.bonus.decrementShowTime();
        }
    }

    public BonusModel getBonus() {
        return bonus;
    }

    public void setBonus(BonusModel bonus) {
        this.bonus = bonus;
    }
}
