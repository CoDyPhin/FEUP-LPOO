package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.SnakeModel;

public class SnakeView {
    private SnakeModel snake;
    public SnakeView(SnakeModel snake){
        this.snake = snake;
    }

    public void updateSnakeModel(SnakeModel snake){
        this.snake = snake;
    }

    public void draw(TextGraphics graphics){
        for (int i = 0; i < this.snake.getBodySize() ; i++) {
            graphics.setForegroundColor(TextColor.Factory.fromString("#08AF08"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(this.snake.getBody().get(i).getX(), this.snake.getBody().get(i).getY()), "O");
        }
    }
}
