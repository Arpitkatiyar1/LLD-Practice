package trafficControlSystem.basic;

public class GreenState implements State {
    int duration;

    GreenState() {
        this.duration = 30;
    }

    @Override
    public void setState(int duration) {
        this.duration = duration;
    }

    @Override
    public Signal getState() {
        return Signal.GREEN;
    }

    @Override
    public void adjustState(int adjustBy) {
        this.duration += adjustBy;
    }
    
}
