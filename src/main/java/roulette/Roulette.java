package roulette;

import java.util.Random;

public class Roulette {

    private Random random;
    private BallDelay delay;

    public Roulette(Random random, BallDelay ballDelay) {
        this.random = random;
        delay = ballDelay;
    }

    public Result play() {
        Integer result = getResult();
        return new Result(translateResult(result));
    }

    public String translateResult(Integer result) {
        String translatedResult;
        if (result == 37) {
            translatedResult = "00";
        } else {
            translatedResult = String.valueOf(result);
        }
        return translatedResult;
    }

    private Integer getResult() {
        delay.waitForBall();
        return random.nextInt(38);
    }
    
}