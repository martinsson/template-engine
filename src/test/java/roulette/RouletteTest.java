package roulette;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class RouletteTest {

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
    
    @Test
    public void it_returns_a_random_number_that_can_be_0() {
        Random mock = mock(Random.class);
        when(mock.nextInt(UPPERLIMIT_FOR_RANDOM_36)).thenReturn(0);
        Roulette roulette = new Roulette(mock);
        
        Integer expected = 0;
        assertEquals(expected, roulette.play());
    }
    
    @Test
    public void it_returns_a_random_number_that_can_be_37() {
        Random mock = mock(Random.class);
        when(mock.nextInt(UPPERLIMIT_FOR_RANDOM_36)).thenReturn(36);
        Roulette roulette = new Roulette(mock);
        
        Integer expected = 36;
        assertEquals(expected, roulette.play());
    }
    
    public static class Roulette {

        private Random random;

        public Roulette(Random random) {
            this.random = random;
        }

        public Integer play() {
            return random.nextInt(37);
        }
        
    }

}
