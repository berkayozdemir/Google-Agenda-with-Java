import java.text.ParseException;
import java.util.ArrayList;

public class User {
    String id;
    String name;
    Birthday birthday;
    Anniversary anniversary;
    ArrayList<Course> courseArrayList=new ArrayList<>();
    ArrayList<Event> eventArrayList=new ArrayList<>();
    ArrayList<Meeting> meetingArrayList=new ArrayList<>();
    ArrayList<Appointment> appointmentArrayList=new ArrayList<>();



    public User(String id,String name) {
        this.name = name;
        this.id = id;
    }

    public boolean checkdate(String a,String b,int duration,String type) throws ParseException {
        boolean check=true;

        if(!type.equals("course")) {
        for(int i=0;i<courseArrayList.size();i++) {
            if(courseArrayList.get(i).day.equals(DateConverter.findDay(a))) {
                check=DateConverter.checkinterval(courseArrayList.get(i).saat,courseArrayList.get(i).duration,b,duration);
                break;
            }}

            for(int i=0;i<eventArrayList.size();i++) {
            if(eventArrayList.get(i).tarih.equals(a)) {
                check=DateConverter.checkinterval(eventArrayList.get(i).saat,eventArrayList.get(i).duration,b,duration);
                break;
            }}
        for(int i=0;i<meetingArrayList.size();i++) {
            if(meetingArrayList.get(i).day.equals(a)) {
                check=DateConverter.checkinterval(meetingArrayList.get(i).hour,meetingArrayList.get(i).duration,b,duration);
                break;
            }}
        for(int i=0;i<appointmentArrayList.size();i++) {
            if(appointmentArrayList.get(i).day.equals(a)) {
                check=DateConverter.checkinterval(appointmentArrayList.get(i).hour,appointmentArrayList.get(i).duration,b,duration);
                break;
            }} }

        else
        {
            for(int i=0;i<courseArrayList.size();i++) {
                if(courseArrayList.get(i).day.equals(DateConverter.findDay(a))) {
                    check=DateConverter.checkinterval(courseArrayList.get(i).saat,courseArrayList.get(i).duration,b,duration);
                    break;
                }}

            for(int i=0;i<eventArrayList.size();i++) {
                if(DateConverter.findDay(eventArrayList.get(i).tarih).equals(DateConverter.findDay(a))) {
                    check=DateConverter.checkinterval(eventArrayList.get(i).saat,eventArrayList.get(i).duration,b,duration);
                    break;
                }}
            for(int i=0;i<meetingArrayList.size();i++) {
                if(DateConverter.findDay(meetingArrayList.get(i).day).equals(DateConverter.findDay(a))) {
                    check=DateConverter.checkinterval(meetingArrayList.get(i).hour,meetingArrayList.get(i).duration,b,duration);
                    break;
                }}
            for(int i=0;i<appointmentArrayList.size();i++) {
                if(DateConverter.findDay(appointmentArrayList.get(i).day).equals(DateConverter.findDay(a))) {

                    check=DateConverter.checkinterval(appointmentArrayList.get(i).hour,appointmentArrayList.get(i).duration,b,duration);

                    break;
                }} }





        return check;
    }
}
