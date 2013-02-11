package roulette;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

public class ResultTest {

    @Test
    public void equality_is_based_on_the_given_string() {
        assertEquals(result("1"), result("1"));
        assertThat(result("3")).isNotEqualTo(result("1"));
    }
    
    private Result result(String string) {
        return new Result(string);
    }

}
