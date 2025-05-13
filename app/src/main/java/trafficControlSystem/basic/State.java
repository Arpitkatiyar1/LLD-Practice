package trafficControlSystem.basic;

public interface State {
    void setState(int duration);
    Signal getState();
    void adjustState(int adjustBy);
}
