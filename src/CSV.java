import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class CSV {
    private static String SplitBy = ";";

    public static ArrayList ParseStudent(String fn) {
        ArrayList tmp = new ArrayList();
        BufferedReader br = null;
        String line;
        String[] data;
        Student st;
        try {
            br = new BufferedReader(new FileReader(fn));
            while ((line = br.readLine()) != null) {
                data = line.split(CSV.SplitBy);
                st = new Student();
                CSV.ParsePeople(data,st);
                st.setGroup(data[5]);
                st.setCourse(Integer.parseInt(data[6]));
                tmp.add(st);
            }
        } catch (FileNotFoundException e) {
            Logger.getInstance().Warn("Файл" + fn + "не найден");
        } catch (IOException e) {
            Logger.getInstance().Warn("Ошибка при чтении файла " + fn);
        } catch (NumberFormatException e) {
            Logger.getInstance().Warn("Ошибка при парсинге целого числа");
        } finally {
            CSV.Close(br,fn);
        }
        return tmp;
    }

    public static ArrayList ParseTeacher(String fn) {
        ArrayList tmp = new ArrayList();
        BufferedReader br = null;
        String line;
        String[] data;
        Teacher tc;
        try {
            br = new BufferedReader(new FileReader(fn));
            while ((line = br.readLine()) != null) {
                data = line.split(CSV.SplitBy);
                tc = new Teacher();
                CSV.ParsePeople(data, tc);
                tc.setSubject(data[5]);
                tc.setRank(data[6]);
                tc.setExperience(Integer.parseInt(data[7]));
                tmp.add(tc);
            }
        } catch (FileNotFoundException e) {
            Logger.getInstance().Warn("Файл" + fn + "не найден");
        } catch (IOException e) {
            Logger.getInstance().Warn("Ошибка при чтении файла " + fn);
        } catch ( NumberFormatException e) {
            Logger.getInstance().Warn("Ошибка при парсинге целого числа");
        } finally {
            CSV.Close(br,fn);
        }
        return tmp;
    }

    private static void ParsePeople(String data[], People p){
        p.setFirstName(data[0]);
        p.setLastName(data[1]);
        p.setThirdName(data[2]);
        p.setGender(data[4].equals("Мужской") ? People.GenderDescription.Мужской:People.GenderDescription.Женский);
        try {
            p.setDayOfBirth(new SimpleDateFormat("MM.dd.yyyy").parse( data[3] ));
        } catch (ParseException e) {
            Logger.getInstance().Warn("Ошибка при парсинге даты рождения");
        }
    }

    private static void Close(BufferedReader br, String fn){
        if (br != null) {
            try {
                br.close();
                Logger.getInstance().Info("Парсинг CSV "+ fn +" завершен");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

