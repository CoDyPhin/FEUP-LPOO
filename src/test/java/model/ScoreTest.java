package model;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {
    @Test
    public void testScoreValue(){
        ScoreModel score = new ScoreModel();
        assertEquals(0, score.getValue());
    }

    @Test
    public void testIncrementScore(){
        ScoreModel score = new ScoreModel();
        score.incrementScore(1);

        assertEquals(1, score.getValue());

        score.incrementScore(5);

        assertEquals(6, score.getValue());
    }
}
