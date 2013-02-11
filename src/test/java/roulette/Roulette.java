package roulette;

import java.util.Random;

import roulette.RouletteTest.BallDelay;

public class Roulette {

    private Random random;
    private BallDelay delay;

    public Roulette(Random random, BallDelay ballDelay) {
        this.random = random;
        delay = ballDelay;
    }

    public Result play2() {
        return new Result(String.valueOf(play()));
    }

    private Integer play() {
        delay.waitForBall();
        return random.nextInt(37);
    }
    
}