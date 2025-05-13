package trafficControlSystem.basic;

public class Main {
    public void run() {
        TrafficControlSystem instance = new TrafficControlSystem();
        instance.setYellowSignal(10);
        instance.setRedSignal(100);
        instance.setGreenSignal(50);
        instance.setGreenSignal(50);
        instance.adjustState(-15);
           
        return ;
    }
}
