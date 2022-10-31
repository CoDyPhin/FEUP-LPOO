package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BonusTest {
    @Test
    public void testShowTimeValue(){
        BonusModel bonus = new BonusModel(1,50,25);
        assertEquals(40, bonus.getShowTime());
    }

    @Test
    public void testDecrementShowTime(){
        BonusModel bonus = new BonusModel(1,50,25);

        bonus.decrementShowTime();

        assertEquals(39, bonus.getShowTime());

        bonus.decrementShowTime();
        bonus.decrementShowTime();
        bonus.decrementShowTime();

        assertEquals(36, bonus.getShowTime());
    }
}
