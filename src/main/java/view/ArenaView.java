package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.screen.Screen;
import model.ArenaModel;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import com.googlecode.lanterna.input.KeyStroke;
import model.Position;
import model.SnakeModel;

import java.io.IOException;
import java.util.Date;

import static java.lang.StrictMath.round;

public class ArenaView {
    private Screen screen;
    private SnakeView snake;
    private AppleView apple;
    private BonusView bonus;

    public enum KEYPRESSED {ARROWRIGHT, ARROWLEFT, ARROWDOWN, ARROWUP, CONTINUEMOV, ENTER, P}

    public ArenaView(Screen screen, SnakeView snake, AppleView apple, BonusView bonus) throws IOException {
        this.snake = snake;
        this.apple = apple;
        this.bonus = bonus;
        this.screen = screen;
    }

    public void updateSnakeModel(SnakeModel snake){
        this.snake.updateSnakeModel(snake);
    }

    public Screen getScreen() {
        return screen;
    }

    public void drawTime(ArenaModel arena, TextGraphics graphics){
        Date now = new Date();
        long diff = now.getTime()-arena.getTime().getTime();
        long diffSecs = diff /1000 %60;
        long diffMinutes = diff /(60*1000)%60;
        String minStr;
        if(diffMinutes < 10){
            minStr = "0" + diffMinutes;
        }
        else
            minStr = String.valueOf(diffMinutes);
        String secsStr;
        if(diffSecs < 10){
            secsStr = "0" + diffSecs;
        }
        else
            secsStr = String.valueOf(diffSecs);
        String strTime = minStr + ":" + secsStr;
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(arena.getWidth()-12,arena.getHeight()+1), "Time: ");
        graphics.putString(new TerminalPosition(arena.getWidth()-6,arena.getHeight()+1), strTime);
    }

    public void draw(ArenaModel arena){
        try{
            TextGraphics graphics = screen.newTextGraphics();
            screen.clear();
            graphics.setBackgroundColor(TextColor.Factory.fromString("#393489"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');
            for (int i = 0; i < arena.getWalls().size() ; i++) {
                graphics.setForegroundColor(TextColor.Factory.fromString("#0000FF"));
                graphics.enableModifiers(SGR.BOLD);
                graphics.putString(new TerminalPosition(arena.getWalls().get(i).getPosition().getX(), arena.getWalls().get(i).getPosition().getY()), "W");
            }
            this.snake.draw(graphics);
            if(arena.getApple().getPosition().equals(arena.getSnake().getBody().get(0))){
                while(arena.checkApplePosition()){
                    arena.getApple().setPosition(arena.getWidth(),arena.getHeight());
                }
                arena.snakeGrow(new Position(arena.getSnake().getBody().get(arena.getSnake().getBodySize()-1).getX()-1,arena.getSnake().getBody().get(arena.getSnake().getBodySize()-1).getY()));
                arena.getScore().incrementScore(1);
            }
            this.apple.draw(graphics);
            if(arena.getBonus().getPosition().equals(arena.getSnake().getBody().get(0)) && arena.getBonus().isDisplay()){
                arena.snakeGrow(new Position(arena.getSnake().getBody().get(arena.getSnake().getBodySize()-1).getX()-1,arena.getSnake().getBody().get(arena.getSnake().getBodySize()-1).getY()));
                arena.getScore().incrementScore(arena.getBonus().getValue());
                arena.createBonus(arena.getBonus().getValue());
                this.bonus.setBonus(arena.getBonus());
            }
            if(arena.checkBonusPosition() && arena.getBonus().isDisplay()){
                arena.createBonus(arena.getBonus().getValue());
                this.bonus.setBonus(arena.getBonus());
            }
            this.bonus.draw(graphics);
            if(this.bonus.getBonus().getShowTime() == 0){
                arena.createBonus(arena.getBonus().getValue());
                this.bonus.setBonus(arena.getBonus());
            }
            graphics.disableModifiers(SGR.BLINK);
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(0,arena.getHeight()+1), "Score: ");
            graphics.putString(new TerminalPosition((int) round(0.16*arena.getWidth()),arena.getHeight()+1), String.valueOf(arena.getScore().getValue()));
            drawTime(arena,graphics);
            screen.refresh();
            long sleep = 100-round(0.5*arena.getScore().getValue());
            if(sleep < 50){
                sleep = 50;
            }
            Thread.sleep(sleep);
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public KEYPRESSED getKey() throws IOException{
        while(true){
            KeyStroke key = this.screen.pollInput();
            if((key == null)){
                return KEYPRESSED.CONTINUEMOV;
            }
            switch (key.getKeyType()){
                case ArrowUp:
                    return KEYPRESSED.ARROWUP;
                case ArrowDown:
                    return KEYPRESSED.ARROWDOWN;
                case ArrowRight:
                    return KEYPRESSED.ARROWRIGHT;
                case ArrowLeft:
                    return KEYPRESSED.ARROWLEFT;
                case Character:
                    if(key.getCharacter() == 'p')
                        return KEYPRESSED.P;
                    else
                        return KEYPRESSED.CONTINUEMOV;
            }
        }
    }
}
