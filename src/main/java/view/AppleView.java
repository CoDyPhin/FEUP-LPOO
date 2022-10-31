package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.AppleModel;

public class AppleView {
    private AppleModel apple;

    public AppleView(AppleModel apple){
        this.apple = apple;
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#e71837"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(this.apple.getPosition().getX(), this.apple.getPosition().getY()), "A");
    }
}
