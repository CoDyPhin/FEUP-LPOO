package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArenaTest {
    @Test
    public void testShowTimeValue(){
        ArenaModel arena = new ArenaModel(50,25);

        assertEquals(50, arena.getWidth());
        assertEquals(25, arena.getHeight());
    }

    @Test
    public void testCreateWalls(){
        ArenaModel arena1 = new ArenaModel(50,25);
        arena1.createWalls();

        assertEquals(198, arena1.getWalls().size());

        ArenaModel arena2 = new ArenaModel(100,50);
        arena2.createWalls();

        assertEquals(398, arena2.getWalls().size());

    }

    @Test
    public void testCreateWallsWithGaps(){
        ArenaModel arena1 = new ArenaModel(50,25);
        arena1.createWallsWithGaps();

        assertEquals(138, arena1.getWalls().size());

        ArenaModel arena2 = new ArenaModel(100,50);
        arena2.createWallsWithGaps();

        assertEquals(288, arena2.getWalls().size());
    }

    @Test
    public void testCreateBonus(){
        ArenaModel arena = new ArenaModel(50,25);
        assertNull(arena.getBonus());

        arena.createBonus(1);
        assertNotNull(arena.getBonus());
    }

    @Test
    public void testCheckWallCollision(){
        ArenaModel arena = new ArenaModel(50,25);
        for (int i = 0; i < 5; i++) {
            arena.getWalls().add(new WallModel(i,0));
        }
        assertEquals(false, arena.checkWallCollision());

        for (int i = 0; i < 5 ; i++) {
            arena.getWalls().add(new WallModel(i,3));
        }
        assertEquals(true, arena.checkWallCollision());
    }

    @Test
    public void testCheckApplePosition(){
        ArenaModel arena = new ArenaModel(50,25);
        arena.createBonus(1);
        arena.getBonus().getPosition().setX(5);
        arena.getBonus().getPosition().setY(5);
        for (int i = 0; i < 5; i++) {
            arena.getWalls().add(new WallModel(i,0));
        }
        arena.getApple().getPosition().setX(6);
        arena.getApple().getPosition().setY(10);

        assertEquals(false, arena.checkApplePosition());

        arena.getApple().getPosition().setX(4);
        arena.getApple().getPosition().setY(0);
        assertEquals(true, arena.checkApplePosition());

        arena.getApple().getPosition().setX(5);
        arena.getApple().getPosition().setY(5);
        assertEquals(true, arena.checkApplePosition());

        arena.getApple().getPosition().setX(2);
        arena.getApple().getPosition().setY(3);
        assertEquals(true, arena.checkApplePosition());
    }

    @Test
    public void testCheckBonusPosition(){
        ArenaModel arena = new ArenaModel(50,25);
        arena.createBonus(1);
        arena.getBonus().getPosition().setX(5);
        arena.getBonus().getPosition().setY(5);
        for (int i = 0; i < 5; i++) {
            arena.getWalls().add(new WallModel(i,0));
        }
        arena.getApple().getPosition().setX(6);
        arena.getApple().getPosition().setY(10);

        arena.getBonus().getPosition().setX(15);
        arena.getBonus().getPosition().setY(7);
        assertEquals(false, arena.checkBonusPosition());

        arena.getBonus().getPosition().setX(4);
        arena.getBonus().getPosition().setY(0);
        assertEquals(true, arena.checkBonusPosition());

        arena.getBonus().getPosition().setX(6);
        arena.getBonus().getPosition().setY(10);
        assertEquals(true, arena.checkBonusPosition());

        arena.getBonus().getPosition().setX(2);
        arena.getBonus().getPosition().setY(3);
        assertEquals(true, arena.checkBonusPosition());
    }
}
