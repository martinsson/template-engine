package roulette;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BallDelayTest {
    
    @Test public void 
    waits_for_a_specified_time() throws Exception {
        BallDelay ballDelay = new BallDelay(200); 
        double b4 = System.currentTimeMillis();
        ballDelay.waitForBall();
        double after = System.currentTimeMillis();
        int errorMargin = 20;
        assertEquals(200,  after - b4, errorMargin);
    }

}
