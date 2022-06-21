import java.text.ParseException;

public class Course {
    int kota;
   int  mevcut=0;
    String tarih;
    String saat;
    String id;
    String name;
    String day;
    int duration=120;
    public Course(int kota, String tarih, String saat, String id, String name) throws ParseException {
        this.kota = kota;
        this.tarih = tarih;
        this.saat = saat;
        this.id = id;
        this.name = name;
        day=DateConverter.findDay(tarih);
    }


}
