import java.io.*;
import java.util.ArrayList;

public class Serialize {
    public static void Write(ArrayList obj, String fn){
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fn)));
            out.writeObject(obj);
        } catch ( IOException ex ) {
            Logger.getInstance().Warn("Ошибка сериализации");
        } finally {
            if ( out != null ) {
                try {
                    out.close();
                    Logger.getInstance().Info("Cериализация файла " + fn + " прошла успешно");
                } catch (IOException ex) {
                    Logger.getInstance().Warn("Ошибка закрытия файла");
                }
            }
        }
    }

    public static ArrayList Read(String fn){
        ObjectInputStream in = null;
        ArrayList obj = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fn)));
            obj = (ArrayList)in.readObject();
        } catch (IOException ex ) {
            Logger.getInstance().Warn("Ошибка десериализации");
        } catch (ClassNotFoundException e) {
            Logger.getInstance().Warn("Файл "+fn+" не найден");
        } finally {
            if ( in != null ) {
                try {
                    in.close();
                    Logger.getInstance().Info("Десериализация файла " + fn + " прошла успешно");
                } catch (IOException ex) {
                    Logger.getInstance().Warn("Ошибка закрытия файла");
                }
            }
        }
        return obj;
    }
}
