package Behavioural.Observer;

public class Runner {
    public static void main(String[] args) {
        YtChannel funxway = new YtChannel();
        User u1 = new User("Nikhil");
        User u2 = new User("Devesh");
        User u3 = new User("Samay");

        funxway.subscribe(u1);
        funxway.subscribe(u3);

        funxway.uploadVideo("How I lost 10lakh rupees");
    }
}
