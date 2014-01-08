package roulette;

public class BallDelay {

    private int delay;

    public BallDelay(int milliseconds) {
        this.delay = milliseconds;
    }

    public void waitForBall() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}