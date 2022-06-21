import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        Driver driver=new Driver();
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] data2=data.split(" ");
                if(!data.equals("")) {System.out.println("COMMAND:"+data);}

                if(data2[0].equals("SAVE")) {
                    if(data2[1].equals("USER")) {
                        String[] data3=data.split(data2[2]+" ");
                        driver.saveUser(data2[2],data3[1]);

                    }

                    else if(data2[1].equals("ANNIVERSARY")) {
                        String[] data3=data.split(data2[4]+" ");
                        driver.setAnniversaries(data2[2],data2[3],data2[4],data3[1]);

                    }

                    else if(data2[1].equals("BIRTHDAY")) {
                        String[] data3=data.split(data2[4]+" ");
                        driver.setBirthdays(data2[2],data2[3],data2[4],data3[1]);

                    }

                }

                else if (data2[0].equals("ARRANGE")) {
                    if(data2[1].equals("COURSE")) {
                        String[] data3=data.split(data2[5]+" ");
                        driver.arrangeCourse(Integer.parseInt(data2[2]),data2[3],data2[4],data2[5],data3[1]);

                    }
                    if(data2[1].equals("CONCERT")) {
                        String[] data3=data.split(data2[5]+" ");
                        driver.arrangeConcert(Integer.parseInt(data2[2]),data2[3],data2[4],data2[5],data3[1]);

                    }
                    if(data2[1].equals("THEATER")) {
                        String[] data3=data.split(data2[5]+" ");
                        driver.arrangeTheater(Integer.parseInt(data2[2]),data2[3],data2[4],data2[5],data3[1]);

                    }
                    if(data2[1].equals("SPORT")) {
                        String[] data3=data.split(data2[5]+" ");
                        driver.arrangeSport(Integer.parseInt(data2[2]),data2[3],data2[4],data2[5],data3[1]);

                    }

                    if(data2[1].equals("MEETING")) {
                        ArrayList<String> users=new ArrayList<>();
                        String[] data4=data2[5].split(",");
                        for(int i=0;i< data4.length;i++) {
                            users.add(data4[i]);


                        }


                        driver.arrangeMeeting(data2[2],data2[3],Integer.parseInt(data2[4]),users,data2[data2.length-1],data2[5]);

                    }

                    if(data2[1].equals("APPOINTMENT")) {
                        ArrayList<String> users=new ArrayList<>();
                        String[] data4=data2[5].split(",");
                        for(int i=0;i< data4.length;i++) {

                            users.add(data4[i]);


                        }


                        driver.arrangeAppointment(data2[2],data2[3],Integer.parseInt(data2[4]),users,data2[data2.length-1],data2[5]);

                    }




                }

                else if (data2[0].equals("CANCEL")) {
                    if(data2[1].equals("APPOINTMENT")) {
                        driver.cancel(data2[2],data2[1]);

                    }

                    if(data2[1].equals("MEETING")) {
                        driver.cancel(data2[2],data2[1]);
                    }

                    if(data2[1].equals("EVENT")) {
                        driver.cancel(data2[2],data2[1]);
                    }

                    if(data2[1].equals("COURSE")) {
                        driver.cancel(data2[2],data2[1]);
                    }


                }

                else if (data2[0].equals("ATTEND")) {
                    if(data2[1].equals("COURSE")) {
                        driver.attendCourse(data2[2],data2[3]);


                    }
                    if (data2[1].equals("EVENT")) {
                        driver.attendEVENT(data2[2],data2[3]);


                    }


                }

                else if (data2[0].equals("LIST")) {  if(data2[1].equals("DAILY")) {
                   driver.daily(data2[2],data2[3]);

                }
                    if(data2[1].equals("ATTENDANCE")) {
                    driver.attendance(data2[2],data2[3]);

                    }

                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
