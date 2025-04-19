package app.src.main.java.lld_practice.stackOverFlow;

public class Vote {
    private final User user;
    private final int value;

    Vote(User user, int value) {
        this.user = user;
        this.value = value;
    }

    public User getUser() {
        return user;
    }
    public int getValue() {
        return value;
    }
}
