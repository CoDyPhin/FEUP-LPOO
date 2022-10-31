package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import model.CursorModel;

import java.io.IOException;


public class PauseMenuView {
    private Screen screen;
    private CursorModel cursor;

    public PauseMenuView(Screen screen){
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setCursor(CursorModel cursor) {
        this.cursor = cursor;
    }

    public void draw(int width, int height){
        try{
            TextGraphics graphics = screen.newTextGraphics();
            screen.clear();
            graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width,height), ' ');
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(19, 4), "PAUSE MENU");
            graphics.putString(new TerminalPosition(this.cursor.getPosition().getX(), this.cursor.getPosition().getY()), this.cursor.getBody());
            graphics.putString(new TerminalPosition(20,8), "Continue");
            graphics.putString(new TerminalPosition(20, 10), "Main Menu");
            screen.refresh();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArenaView.KEYPRESSED getKey() throws IOException{
        while(true){
            KeyStroke key = this.screen.readInput();
            switch (key.getKeyType()){
                case ArrowUp:
                    return ArenaView.KEYPRESSED.ARROWUP;
                case ArrowDown:
                    return ArenaView.KEYPRESSED.ARROWDOWN;
                case Enter:
                    return ArenaView.KEYPRESSED.ENTER;
            }
        }
    }
}
