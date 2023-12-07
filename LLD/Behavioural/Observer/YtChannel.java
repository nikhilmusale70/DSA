package Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class YtChannel {
    List<User> users = new ArrayList<>();
    public void subscribe(User user){
        users.add(user);
    }
    public void unSubscribe(User user){
        users.remove(user);
    }

    public void notifyUsers(String videoName){
        for(User u : users){
            System.out.println(u.getName() + " sending notification for " + videoName);
        }
    }

    public void uploadVideo(String videoName){
        System.out.println(videoName+ " is published");
        notifyUsers(videoName);
    }
}
