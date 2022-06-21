import java.util.ArrayList;

public class Appointment {

    String day;
    String hour;
    int duration;
    ArrayList<String> userArrayList;
    String id;

    public Appointment(String day, String hour, int duration, ArrayList<String> userArrayList, String id) {
        this.day = day;
        this.hour = hour;
        this.duration = duration;
        this.userArrayList = userArrayList;
        this.id = id;
    }



}
