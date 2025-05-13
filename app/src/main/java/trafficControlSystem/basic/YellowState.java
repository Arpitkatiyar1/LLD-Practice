package trafficControlSystem.basic;

public class YellowState implements State{
    int duration;

    YellowState() {
        this.duration = 30;
    }

    @Override
    public void setState(int duration) {
        this.duration = duration;
    }

    @Override
    public Signal getState() {
        return Signal.YELLOW;
    }

    @Override
    public void adjustState(int adjustBy) {
        this.duration += adjustBy;
    }   
}
