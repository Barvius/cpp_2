import java.io.Serializable;
import java.util.Date;

public class People implements Serializable {
    public enum GenderDescription{Мужской,Женский};
    private GenderDescription Gender;
    private Date DayOfBirth;
    private String FirstName;
    private String LastName;
    private String ThirdName;

    public GenderDescription getGender() {
        return Gender;
    }

    public void setGender(GenderDescription gender) {
        Gender = gender;
    }

    public Date getDayOfBirth() {
        return DayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        DayOfBirth = dayOfBirth;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getThirdName() {
        return ThirdName;
    }

    public void setThirdName(String thirdName) {
        ThirdName = thirdName;
    }
}
