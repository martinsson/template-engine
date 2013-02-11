package roulette;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Test;

public class RouletteTest {

    @Test
    public void it_returns_a_random_number_that_can_be_0() {
        Random mock = mock(Random.class);
        when(mock.nextInt()).thenReturn(0);
        Roulette roulette = new Roulette(mock);
        
        Integer expected = 0;
        assertEquals(expected, roulette.play());
    }
    @Test
    public void it_returns_a_random_number_that_can_be_37() {
        Random mock = mock(Random.class);
        when(mock.nextInt()).thenReturn(36);
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
            return random.nextInt();
        }
        
    }

}
