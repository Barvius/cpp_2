import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Teacher extends People implements Serializable {
    private String Subject;
    private String Rank;
    private int Experience;

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    @Override
    public String toString() {
        return "Преподаватель:\n"+
                "Звание:        " + this.Rank + "\n" +
                "Предмет:       " + this.Subject + "\n" +
                "Стаж:          " + this.Experience + "\n" +
                "Имя:           " + this.getFirstName() + "\n"+
                "Фамилия:       " + this.getLastName() + "\n"+
                "Отчество:      " + this.getThirdName() + "\n"+
                "Дата рождения: " + new SimpleDateFormat("yyyy-MM-dd").format(this.getDayOfBirth()) + "\n"+
                "Пол:           " + this.getGender() + "\n\n";
    }
}
