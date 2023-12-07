package Behavioural.Observer;

public class User {
    private String name;
    YtChannel ch = new YtChannel();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
