import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Student extends People implements Serializable {
    private String Group;
    private int Course;

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public int getCourse() {
        return Course;
    }

    public void setCourse(int course) {
        Course = course;
    }

    @Override
    public String toString() {
        return "Студент:\n"+
                "Группа:        " + this.Group + "\n" +
                "Курс:          " + this.Course + "\n" +
                "Имя:           " + this.getFirstName() + "\n"+
                "Фамилия:       " + this.getLastName() + "\n"+
                "Отчество:      " + this.getThirdName() + "\n"+
                "Дата рождения: " + new SimpleDateFormat("yyyy-MM-dd").format(this.getDayOfBirth()) + "\n"+
                "Пол:           " + this.getGender() + "\n\n";
    }
}
