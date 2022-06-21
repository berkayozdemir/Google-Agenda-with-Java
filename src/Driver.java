import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Driver {

    public static ArrayList<User> users= new ArrayList<>();
    public static ArrayList<Anniversary> anniversaries= new ArrayList<>();
    public  static ArrayList<Birthday> birthdays=new ArrayList<>();
    public static ArrayList<Course> courses=new ArrayList<>();
    public  static  ArrayList<Event> events=new ArrayList<>();
    public static ArrayList<Appointment> appointments=new ArrayList<>();
    public static ArrayList<Meeting> meetings=new ArrayList<>();






    public void saveUser(String a,String b) {
        boolean check =true;
        for(int i=0;i<users.size();i++) {

            if(users.get(i).id.equals(a)) {
                check=false;
                System.out.println("DUPLICATED USER ID: "+a+" ALREADY EXISTS");
                break;
            }
        }
  if(check) {User user =new User(a,b);
  users.add(user);
      System.out.println(b+" SAVED");
  }


    }

    public void setAnniversaries(String a,String b,String c,String d) {

        boolean usercheck=false;
        boolean idcheck=true;
        String index="";
        for(int i=0;i<anniversaries.size();i++) {
            if (anniversaries.get(i).an_id.equals(c)) {
                idcheck=false;
                break;
            }
        }

        for(int i=0;i<users.size();i++) {
            if(users.get(i).id.equals(b)) {
                usercheck=true;
                index=users.get(i).id;
            }
        }


        if(usercheck&&idcheck) {
            System.out.println(d+" ADDED TO "+findusername(b).name+"'s AGENDA");
            Anniversary anniversary=new Anniversary(a,b,c,d);
            for(int i=0;i< users.size();i++) {
                if(users.get(i).id.equals(index)) {
                users.get(i).anniversary=anniversary;
                }
            }

            anniversaries.add(anniversary);
        }
        else if(!idcheck) {
            System.out.println("DUPLICATED ANNIVERSARY ID: "+c+" ALREADY EXISTS");
        }
        else {
            System.out.println("USER NOT FOUND: "+b);
        }


    }

    public void setBirthdays(String a,String b,String c,String d) {

        boolean usercheck=false;
        boolean idcheck=true;
        String index="";

        for(int i=0;i<birthdays.size();i++) {
            if (birthdays.get(i).an_id.equals(c)) {
                idcheck=false;
                break;
            }
        }

        for(int i=0;i<users.size();i++) {
            if(users.get(i).id.equals(b)) {
                usercheck=true;
                index=users.get(i).id;
            }
        }


        if(usercheck&&idcheck) {
            System.out.println(d+" ADDED TO "+findusername(b).name+"'s AGENDA");
            Birthday birthday=new Birthday(a,b,c,d);
            for(int i=0;i< users.size();i++) {
                if(users.get(i).id.equals(index)) {
                    users.get(i).birthday=birthday;
                }
            }

            birthdays.add(birthday);
        }
        else if(!idcheck) {
            System.out.println("DUPLICATED BIRTHDAY ID: "+c+" ALREADY EXISTS");
        }
        else {
            System.out.println("USER NOT FOUND: "+b);
        }
    }

    public void arrangeCourse(int a,String b,String c,String d,String e) throws ParseException {
       boolean check=true;

        for(int i=0;i<courses.size();i++) {
           if(courses.get(i).id.equals(d)) {
               check=false;
               System.out.println("DUPLICATED COURSE ID: "+d+ "ALREADY EXISTS");
           }
       }


        if(check) {

            String day=DateConverter.findDay(b);


            Course course=new Course(a,b,c,d,e);
            courses.add(course);
            System.out.println(""+e+" ARRANGED ON "+day.toUpperCase()+" "+c);
        }


    }

    public void arrangeSport(int a,String b,String c,String d,String e) throws ParseException {
        boolean check=true;

        for (int i=0;i< events.size();i++) {
            if(events.get(i).id.equals(d)) {
                check=false;
                System.out.println("DUPLICATED EVENT ID: "+d+" ALREADY EXISTS");
                System.out.println(events.get(i).name);
                return;
            }
        }
        if(check) {
            Sport sport=new Sport(a,b,c,d,e);
            events.add(sport);
            System.out.println(e+" ARRANGED ON "+DateConverter.findDay(b).toUpperCase()+" "+c);
        }


    }

    public void arrangeConcert(int a,String b,String c,String d,String e) throws ParseException {

        boolean check=true;

        for (int i=0;i< events.size();i++) {
            if(events.get(i).id.equals(d)) {
                check=false;
                System.out.println("DUPLICATED EVENT ID: "+d+" ALREADY EXISTS");
                System.out.println(events.get(i).name);
                return;
            }
        }
        if(check) {
            Concert concert=new Concert(a,b,c,d,e);
            events.add(concert);
            System.out.println(e+" ARRANGED ON "+DateConverter.findDay(b).toUpperCase()+" "+c);
        }

    }

    public void arrangeTheater(int a,String b,String c,String d,String e) throws ParseException {

        boolean check=true;

        for (int i=0;i< events.size();i++) {
            if(events.get(i).id.equals(d)) {
                check=false;
                System.out.println("DUPLICATED EVENT ID: "+d+" ALREADY EXISTS");
                System.out.println(events.get(i).id+d);
                return;
            }
        }
        if(check) {
            Theater theater=new Theater(a,b,c,d,e);
            events.add(theater);
            System.out.println(e+" ARRANGED ON "+DateConverter.findDay(b).toUpperCase()+" "+c);
        }

    }

    public void arrangeMeeting(String a,String b,int c,ArrayList<String> d,String e,String f) throws ParseException {


        boolean check=true;
        for(int i=0;i< meetings.size();i++) {
            if(meetings.get(i).id.equals(e)) {
                System.out.println("DUPLICATED MEETING ID: "+e+" ALREADY EXISTS");
                return;
            }

        }




        for(int i=0;i<d.size();i++) {
            User user=findusername(d.get(i));
            if (user==null) {
                System.out.println("USER NOT FOUND: "+d.get(i));
                return;
            }
            boolean check_=user.checkdate(a,b,c,"x");


            if(!check_) {
                System.out.println("INCOMPATIBLE USER: "+d.get(i)+"'S AGENDA IS NOT COMPATIBLE");
                return;
            }
        }
        if(check) {
            Meeting meeting=new Meeting(a,b,c,d,e);
            meetings.add(meeting);
            for(int i=0;i<d.size();i++) {


                for(int j=0;j< users.size();j++) {
                    if(d.get(i).equals(users.get(j).id)) {
                        users.get(j).meetingArrayList.add(meeting);


                    }
                }

            }


            System.out.println("A MEETING ARRANGED FOR "+f+" AT "+a +" "+b);
        }

    }

    public void arrangeAppointment(String a,String b,int c,ArrayList<String> d,String e,String f) throws ParseException {
        boolean check=true;
        for(int i=0;i< appointments.size();i++) {
            if(appointments.get(i).id.equals(e)) {
                System.out.println("DUPLICATED APPOINTMENT ID: "+e+" ALREADY EXISTS");
                return;
            }

        }




        for(int i=0;i<d.size();i++) {
            User user=findusername(d.get(i));
            if (user==null) {
                System.out.println("USER NOT FOUND: "+d.get(i));
                return;
            }
            boolean check_=user.checkdate(a,b,c,"x");


            if(!check_) {
                System.out.println("INCOMPATIBLE USER: "+d.get(i)+"'S AGENDA IS NOT COMPATIBLE");
                return;
            }
        }
        if(check) {
            Appointment appointment=new Appointment(a,b,c,d,e);
            appointments.add(appointment);
            for(int i=0;i<d.size();i++) {

                for(int j=0;j< users.size();j++) {
                    if(d.get(i).equals(users.get(j).id)) {
                        users.get(j).appointmentArrayList.add(appointment);

                    }
                }

            }


            System.out.println("AN APPOINTMENT ARRANGED FOR "+f+" AT "+a +" "+b);
        }

    }

    public void attendCourse(String a, String b) throws ParseException {
        boolean existscheck=false;
        Course course = null;


        for(int i=0;i< courses.size();i++) {
            if(courses.get(i).id.equals(a)) {
                course=courses.get(i);
                existscheck=true;


            }
        }
        if(!existscheck) {
            System.out.println("EVENT NOT FOUND: "+a);

            return;
        }


        ArrayList<String> inside=new ArrayList<>();
        String[] strings=b.split(",");

        for(int i=0;i<strings.length;i++) {

            User user=findusername(strings[i]);
            if(user==null) {
                System.out.println("USER NOT FOUND: "+strings[i]);
            }


            for(int j=0;j< users.size();j++) {
            if(users.get(j).id.equals(strings[i])) {


               boolean check= users.get(j).checkdate(course.tarih,course.saat,course.duration,"course");


               if(!check) {
                   System.out.println("UNAVAILABLE USER: "+strings[i]);
               }

               else if(check && course.mevcut<course.kota) {inside.add(strings[i]); course.mevcut++;
               }
               else {
                   System.out.println("QUOTA FULL: "+strings[i]);
               }




            }

            }
        }

        System.out.println(inside.size()+" USERS ADDED TO ATTEDANCE LIST OF "+ course.name);

        for(int i=0;i< users.size();i++) {

            for(int j=0;j<inside.size();j++) {

                if(users.get(i).id.equals(inside.get(j))) {
                    users.get(i).courseArrayList.add(course);
                }
            }
        }

        for(int i=0;i<courses.size();i++) {

            if(courses.get(i).id.equals(course.id)) {
                courses.remove(i);
                courses.add(course);
            }
        }

    }

    public void attendEVENT(String a, String b) throws ParseException {
        boolean existscheck=false;
        Event event = null;


        for(int i=0;i< events.size();i++) {
            if(events.get(i).id.equals(a)) {
                event=events.get(i);
                existscheck=true;


            }
        }
        if(!existscheck) {
            System.out.println("EVENT NOT FOUND: "+a);

            return;
        }


        ArrayList<String> inside=new ArrayList<>();
        String[] strings=b.split(",");

        for(int i=0;i<strings.length;i++) {

            User user=findusername(strings[i]);
            if(user==null) {
                System.out.println("USER NOT FOUND: "+strings[i]);
            }


            for(int j=0;j< users.size();j++) {
                if(users.get(j).id.equals(strings[i])) {


                    boolean check= users.get(j).checkdate(event.tarih,event.saat,event.duration,"xd");


                    if(!check) {
                        System.out.println("UNAVAILABLE USER: "+strings[i]);
                    }

                    else if(check && event.mevcut<event.kota) {inside.add(strings[i]); event.mevcut++;
                    }
                    else {
                        System.out.println("QUOTA FULL: "+strings[i]);
                    }




                }

            }
        }

        System.out.println(inside.size()+" USERS ADDED TO ATTEDANCE LIST OF "+ event.name);

        for(int i=0;i< users.size();i++) {

            for(int j=0;j<inside.size();j++) {

                if(users.get(i).id.equals(inside.get(j))) {
                    users.get(i).eventArrayList.add(event);
                }
            }
        }

        for(int i=0;i<events.size();i++) {

            if(events.get(i).id.equals(event.id)) {
                events.remove(i);
                events.add(event);
            }
        }

    }


    public void daily(String a,String b) {
        ArrayList<String> hoursList = new ArrayList<>();
        Anniversary anniversary=null;
        Birthday birthday=null;
        int index=0;
        boolean check=false;
        for(int i=0;i<users.size();i++) {

            if(users.get(i).id.equals(b)) {
                anniversary=users.get(i).anniversary;
                birthday=users.get(i).birthday;
                check=true;
                index=i;
                for(int j=0;j<users.get(i).courseArrayList.size();j++) {
                    if(users.get(i).courseArrayList.get(j).tarih.equals(a)) {
                    hoursList.add(users.get(i).courseArrayList.get(j).saat);}
                }

                for(int j=0;j<users.get(i).meetingArrayList.size();j++) {
                    if(users.get(i).meetingArrayList.get(j).day.equals(a)) {
                    hoursList.add(users.get(i).meetingArrayList.get(j).hour);
                }}

                for(int j=0;j<users.get(i).eventArrayList.size();j++) {
                    if(users.get(i).eventArrayList.get(j).tarih.equals(a)) {
                    hoursList.add(users.get(i).eventArrayList.get(j).saat);
                }}

                for(int j=0;j<users.get(i).appointmentArrayList.size();j++) {
                    if(users.get(i).appointmentArrayList.get(j).day.equals(a)) {
                    hoursList.add(users.get(i).appointmentArrayList.get(j).hour);
                }}

            }
        }
        if(!check) {
            System.out.println("USER NOT FOUND: "+b);
            return;
        }

        Collections.sort(hoursList);
        if(anniversary!=null&& anniversary.date.equals(a)) {
            System.out.println("ANNIVERSARY:"+anniversary.desc+" "+a);
        }
        if(birthday!=null&& birthday.date.equals(a)) {
            System.out.println("BIRTHDAY:"+birthday.desc+" "+a);
        }

        for (int i=0;i<hoursList.size();i++) {

            for(int j=0;j<courses.size();j++) {
                if(hoursList.get(i).equals(courses.get(j).saat)) {
                    System.out.println(courses.get(i).name+ " AT "+courses.get(i).saat);
                }
            }
            for(int j=0;j<meetings.size();j++) {
                if(hoursList.get(i).equals(meetings.get(j).hour)) {
                    System.out.println("MEETING"+ " AT "+meetings.get(i).hour);
                }
            }

            for(int j=0;j<appointments.size();j++) {
                if(hoursList.get(i).equals(appointments.get(j).hour)) {
                    System.out.println("APPOINTMENT AT "+courses.get(i).saat);
                }
            }

            for(int j=0;j<events.size();j++) {
                if(hoursList.get(i).equals(events.get(j).saat)) {
                    System.out.println(events.get(i).name+ " AT "+events.get(i).saat);
                }
            }


        }



    }

    public User findusername(String id) {
        for(int i=0;i< users.size(); i++) {
            if (users.get(i).id.equals(id)) {
                return users.get(i);
            }
        }
        return null;
    }

    public void attendance(String type,String id) {
        String empty="";
        if(type.equals("COURSE")) {
            boolean check=false;
            for(int i=0;i<courses.size();i++) {
                if(id.equals(courses.get(i).id)) {
                    check=true;return;
                }
            }
            if(!check) {
                System.out.println("COURSE NOT FOUND: "+id );
            }
            for(int i=0;i<users.size();i++) {
                for(int j=0;j<users.get(i).courseArrayList.size();j++) {
                    if(users.get(i).courseArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).courseArrayList.get(j).name+",";
                    }
                }
                for(int j=0;j<users.get(i).eventArrayList.size();j++) {
                    if(users.get(i).eventArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                for(int j=0;j<users.get(i).appointmentArrayList.size();j++) {
                    if(users.get(i).appointmentArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                for(int j=0;j<users.get(i).meetingArrayList.size();j++) {
                    if(users.get(i).meetingArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                empty=empty.substring(0,empty.length()-1);
                System.out.println(empty);





            }



        }

        if(type.equals("APPOINTMENT")) {
            boolean check=false;
            for(int i=0;i<appointments.size();i++) {
                if(id.equals(appointments.get(i).id)) {
                    check=true;return;
                }
            }
            if(!check) {
                System.out.println("APPOINTMENT NOT FOUND: "+id );
            }
            for(int i=0;i<users.size();i++) {
                for(int j=0;j<users.get(i).courseArrayList.size();j++) {
                    if(users.get(i).courseArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).courseArrayList.get(j).name+",";
                    }
                }
                for(int j=0;j<users.get(i).eventArrayList.size();j++) {
                    if(users.get(i).eventArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                for(int j=0;j<users.get(i).appointmentArrayList.size();j++) {
                    if(users.get(i).appointmentArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                for(int j=0;j<users.get(i).meetingArrayList.size();j++) {
                    if(users.get(i).meetingArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                empty=empty.substring(0,empty.length()-1);
                System.out.println(empty);





            }



        }

        if(type.equals("MEETING")) {
            boolean check=false;
            for(int i=0;i<meetings.size();i++) {
                if(id.equals(meetings.get(i).id)) {
                    check=true;return;
                }
            }
            if(!check) {
                System.out.println("MEETING NOT FOUND: "+id );
            }
            for(int i=0;i<users.size();i++) {
                for(int j=0;j<users.get(i).courseArrayList.size();j++) {
                    if(users.get(i).courseArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).courseArrayList.get(j).name+",";
                    }
                }
                for(int j=0;j<users.get(i).eventArrayList.size();j++) {
                    if(users.get(i).eventArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                for(int j=0;j<users.get(i).appointmentArrayList.size();j++) {
                    if(users.get(i).appointmentArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                for(int j=0;j<users.get(i).meetingArrayList.size();j++) {
                    if(users.get(i).meetingArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                empty=empty.substring(0,empty.length()-1);
                System.out.println(empty);





            }



        }

        if(type.equals("EVENT")) {
            boolean check=false;
            for(int i=0;i<events.size();i++) {
                if(id.equals(events.get(i).id)) {
                    check=true;return;
                }
            }
            if(!check) {
                System.out.println("EVENT NOT FOUND: "+id );
            }
            for(int i=0;i<users.size();i++) {
                for(int j=0;j<users.get(i).courseArrayList.size();j++) {
                    if(users.get(i).courseArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).courseArrayList.get(j).name+",";
                    }
                }
                for(int j=0;j<users.get(i).eventArrayList.size();j++) {
                    if(users.get(i).eventArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                for(int j=0;j<users.get(i).appointmentArrayList.size();j++) {
                    if(users.get(i).appointmentArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                for(int j=0;j<users.get(i).meetingArrayList.size();j++) {
                    if(users.get(i).meetingArrayList.get(j).id.equals(id)) {
                        empty+=users.get(i).name+",";
                    }
                }
                empty=empty.substring(0,empty.length()-1);
                System.out.println(empty);





            }



        }
    }
    public void cancel(String id, String type) {
        if(type.equals("COURSE")) {
            for(int i=0;i<courses.size();i++) {
                if(courses.get(i).id.equals(id)) {
                    for(int j=0;j<users.size();j++) {
                        for(int k=0;k< users.get(j).courseArrayList.size();k++) {

                            if(users.get(j).courseArrayList.get(k).id.equals(id)) {
                                users.get(j).courseArrayList.remove(k);
                                courses.remove(i);
                                System.out.println("COURSE CANCELLED: "+id);
                                return;
                            }
                        }

                    }
                }

            }

            System.out.println("EVENT NOT FOUND: "+id);


        }

        else if(type.equals("EVENT")) {


            for(int i=0;i<events.size();i++) {
                if(events.get(i).id.equals(id)) {
                    for(int j=0;j<users.size();j++) {
                        for(int k=0;k< users.get(j).eventArrayList.size();k++) {

                            if(users.get(j).eventArrayList.get(k).id.equals(id)) {
                                users.get(j).eventArrayList.remove(k);
                                events.remove(i);
                                System.out.println("EVENT CANCELLED: "+id);
                                return;
                            }
                        }

                    }
                }

            }

            System.out.println("EVENT NOT FOUND: "+id);
        }

        else if(type.equals("MEETING")) {
            for(int i=0;i<meetings.size();i++) {
                if(meetings.get(i).id.equals(id)) {
                    for(int j=0;j<users.size();j++) {
                        for(int k=0;k< users.get(j).meetingArrayList.size();k++) {

                            if(users.get(j).meetingArrayList.get(k).id.equals(id)) {
                                users.get(j).meetingArrayList.remove(k);
                                meetings.remove(i);
                                System.out.println("MEETING CANCELLED: "+id);
                               return;
                            }
                        }

                    }
                }

            }

            System.out.println("EVENT NOT FOUND: "+id);




        }

        else if(type.equals("APPOINTMENT")) {

            for(int i=0;i<appointments.size();i++) {
                if(appointments.get(i).id.equals(id)) {
                    for(int j=0;j<users.size();j++) {
                        for(int k=0;k< users.get(j).appointmentArrayList.size();k++) {

                            if(users.get(j).appointmentArrayList.get(k).id.equals(id)) {
                                users.get(j).appointmentArrayList.remove(k);
                                appointments.remove(i);
                                System.out.println("APPOINTMENT CANCELLED: "+id);
                                return;
                            }
                        }

                    }
                }

            }

            System.out.println("EVENT NOT FOUND: "+id);




        }




    }





}
