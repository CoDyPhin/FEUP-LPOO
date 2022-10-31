package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import model.ScoreModel;

import java.io.IOException;


public class GameOverView {
    private Screen screen;

    public GameOverView(Screen screen){
        this.screen = screen;
    }

    public void draw(int width, int height, ScoreModel score){
        try{
            TextGraphics graphics = screen.newTextGraphics();
            screen.clear();
            graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width,height), ' ');
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(19, 4), "GAME OVER");
            graphics.putString(new TerminalPosition(15,6), " Your Score was: ");
            graphics.putString(new TerminalPosition(22,8), String.valueOf(score.getValue()));
            graphics.putString(new TerminalPosition(7, 10), "Press 'ENTER' To Return To Main Menu");
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
                case Enter:
                    return ArenaView.KEYPRESSED.ENTER;
            }
        }
    }
}
