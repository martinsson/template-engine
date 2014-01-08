package roulette;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

public class RouletteTest {

    private static final int UPPERLIMIT_FOR_RANDOM_36 = 38;

    @Test public void 
    test_behaviour_of_random() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            int nextInt = new Random().nextInt(UPPERLIMIT_FOR_RANDOM_36);
            list.add(nextInt);
            assertThat(nextInt).isGreaterThanOrEqualTo(0);
            assertThat(nextInt).isLessThanOrEqualTo(37);
        }
        assertThat(list).contains(36);
        assertThat(list).contains(0);
    }
    
    private Random mock = mock(Random.class);
    BallDelay ballDelay = mock(BallDelay.class);
    private Roulette roulette = new Roulette(mock, ballDelay);
    
    @Test
    public void it_returns_a_result_that_can_be_0() {
        when(mock.nextInt(UPPERLIMIT_FOR_RANDOM_36)).thenReturn(0);
        assertEquals(result("0"), roulette.play());
    }

    private Result result(String string) {
        return new Result(string);
    }

    @Test
    public void it_returns_a_result_number_that_can_be_37() {
        when(mock.nextInt(UPPERLIMIT_FOR_RANDOM_36)).thenReturn(36);
        assertEquals(result("36"), roulette.play());
    }
    
    @Test 
    public void it_returns_a_result_that_can_be_00() {
        when(mock.nextInt(38)).thenReturn(37);
        assertEquals(result("00"), roulette.play());
    }
    
    @Test public void 
    the_ball_rolls_for_a_while_before_stopping() throws Exception {
        roulette.play();
        verify(ballDelay).waitForBall();
    }

}
