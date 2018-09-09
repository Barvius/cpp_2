import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        ArrayList student = new ArrayList();
        student = CSV.ParseStudent("student.csv");
        Serialize.Write(student,"student.ser");
        ArrayList a = new ArrayList();
        a = Serialize.Read("student.ser");
        for (Object i:a) {
            System.out.println(i.toString());
        }

        ArrayList teacher = new ArrayList();
        teacher = CSV.ParseTeacher("teacher.csv");
        Serialize.Write(teacher,"teacher.ser");
        ArrayList b = new ArrayList();
        b = Serialize.Read("teacher.ser");
        for (Object i:b) {
            System.out.println(i.toString());
        }

        Logger.getInstance().Close();
    }
}
