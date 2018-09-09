import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private String FileName = "log.txt";
    PrintWriter Stream;
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static volatile Logger instance;

    private Logger() {
        try {
            this.Stream = new PrintWriter(new FileWriter( this.FileName , true));
            this.Info("Программа запущена");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Close() {
        this.Stream.close();
    }

    public void Info(String value){
        this.Stream.println("["+dateFormat.format(new Date()) + "] [ INFO ] " + value);
        System.out.println("["+dateFormat.format(new Date()) + "] " + value);
    }

    public void Warn(String value){
        this.Stream.println("["+dateFormat.format(new Date()) + "] [ WARN ] " + value);
        System.out.println("["+dateFormat.format(new Date()) + "] \u001B[31m" + value + "\u001B[0m");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
}
