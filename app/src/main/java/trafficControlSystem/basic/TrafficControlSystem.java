package trafficControlSystem.basic;

public class TrafficControlSystem {
    State state ;

    public TrafficControlSystem() {
        this.state = new YellowState();
    }
    public void adjustState(int adjustBy) {
        this.state.adjustState(adjustBy);
        System.out.println("Signal duration has been adjusted by "+adjustBy);
    }

    public void setRedSignal(int duration) {        
        if (this.state.getState() == Signal.RED) {
            System.out.println("Signal is Red already");
        } else {
            this.state = new RedState();
            this.state.setState(duration);
            System.out.println("Signal has been set to " + this.state.getState());
        }
    }

    public void setGreenSignal(int duration) {
        
        if (state.getState() == Signal.GREEN) {
            System.out.println("Signal is Green already");
        }
        else {
            this.state = new GreenState();
            this.state.setState(duration);
            System.out.println("Signal has been set to "+this.state.getState());
        }
    }

    public void setYellowSignal(int duration) {
        
        if (state.getState() == Signal.YELLOW) {
            System.out.println("Signal is Yellow already");
        }
        else {
            this.state = new YellowState();
            this.state.setState(duration);
            System.out.println("Signal has been set to "+this.state.getState());
        }
    }
}
