package model;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SnakeTest {
    @Test
    public void testPosition(){
        SnakeModel snake1 = new SnakeModel(new Position(15,15));

        assertEquals(new Position(15,15), snake1.getBody().get(0));
        assertEquals(new Position(14,15), snake1.getBody().get(1));
        assertEquals(new Position(13,15), snake1.getBody().get(2));

        SnakeModel snake2 = new SnakeModel(new Position(40,30));

        assertEquals(new Position(40,30), snake2.getBody().get(0));
        assertEquals(new Position(39,30), snake2.getBody().get(1));
        assertEquals(new Position(38,30), snake2.getBody().get(2));

    }

    @Test
    public void testAddPosition(){
        SnakeModel snake = new SnakeModel(new Position(37,25));
        snake.addPosition(new Position(34,25));

        assertEquals(4, snake.getBodySize());
        assertEquals(new Position(34,25), snake.getBody().get(3));
    }

    @Test
    public void testRemoveBackToFront(){
        SnakeModel snake = new SnakeModel(new Position(46,50));
        Position p = new Position(47,50);
        snake.removeFromBackToFront(p);

        assertEquals(3, snake.getBodySize());
        assertEquals(p, snake.getBody().get(0));
    }

    @Test
    public void testCheckBodyCollision(){
        SnakeModel snake = new SnakeModel(new Position(46,50));

        assertEquals(false, snake.checkBodyCollision());

        Position p = new Position(46,50);
        snake.addPosition(p);

        assertEquals(true, snake.checkBodyCollision());

    }
}

