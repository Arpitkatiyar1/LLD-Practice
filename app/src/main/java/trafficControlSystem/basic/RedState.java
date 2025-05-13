package trafficControlSystem.basic;

public class RedState implements State{
    int duration;

    RedState() {
        this.duration = 30;
    }

    @Override
    public void setState(int duration) {
        this.duration = duration;
    }

    @Override
    public Signal getState() {
        return Signal.RED;
    }

    @Override
    public void adjustState(int adjustBy) {
        this.duration += adjustBy;
    }

}