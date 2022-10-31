package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArenaFactoryTest {
    @Test
    public void testShowTimeValue(){
        ArenaFactory factory = new ArenaFactory();
        ArenaModel arena1 = factory.createArena(50,25,1);

        assertNotNull(arena1);
        assertEquals(2,arena1.getBonus().getValue());
        assertEquals(0, arena1.getWalls().size());

        ArenaModel arena2 = factory.createArena(50,25,2);
        assertNotNull(arena2);
        assertEquals(4,arena2.getBonus().getValue());
        assertNotEquals(0, arena2.getWalls().size());

        ArenaModel arena3 = factory.createArena(50,25,3);
        assertNotNull(arena3);
        assertEquals(6,arena3.getBonus().getValue());
        assertNotEquals(0, arena3.getWalls().size());
    }
}
