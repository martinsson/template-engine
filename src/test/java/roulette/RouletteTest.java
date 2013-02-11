package roulette;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class RouletteTest {

    public static class BallDelay {

        public void waitForBall() {
            // TODO Auto-generated method stub
            
        }

    }

    private static final int UPPERLIMIT_FOR_RANDOM_36 = 37;

    @Test public void 
    test_behaviour_of_random() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            int nextInt = new Random().nextInt(UPPERLIMIT_FOR_RANDOM_36);
            list.add(nextInt);
            assertThat(nextInt).isGreaterThanOrEqualTo(0);
            assertThat(nextInt).isLessThanOrEqualTo(36);
        }
        assertThat(list).contains(36);
        assertThat(list).contains(0);
    }
    
    private Random mock = mock(Random.class);
    BallDelay ballDelay = mock(BallDelay.class);
    private Roulette roulette = new Roulette(mock, ballDelay);
    
    @Test
    public void it_returns_a_random_number_that_can_be_0() {
        when(mock.nextInt(UPPERLIMIT_FOR_RANDOM_36)).thenReturn(0);
        Integer expected = 0;
        assertEquals(expected, roulette.play());
    }

    @Test
    public void it_returns_a_random_number_that_can_be_37() {
        when(mock.nextInt(UPPERLIMIT_FOR_RANDOM_36)).thenReturn(36);
        Integer expected = 36;
        assertEquals(expected, roulette.play());
    }
    
    @Test public void 
    the_ball_rolls_for_a_while_before_stopping() throws Exception {
        roulette.play();
        verify(ballDelay).waitForBall();
    }
    
    public static class Roulette {

        private Random random;
        private BallDelay delay;

        public Roulette(Random random, BallDelay ballDelay) {
            this.random = random;
            delay = ballDelay;
        }

        public Integer play() {
            delay.waitForBall();
            return random.nextInt(37);
        }
        
    }

}
