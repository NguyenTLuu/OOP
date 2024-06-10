import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String lastName;
    private String midName;
    private String firstName;
    private int yearOfBirth;
    private String gender;
    private String schoolStage;

    public Student() {

    }

    public Student(String id, String lastName, String midName, String firstName, int yearOfBirth, String gender, String schoolStage) {
        this.id = id;
        this.lastName = lastName;
        this.midName = midName;
        this.firstName = firstName;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.schoolStage = schoolStage;
    }


    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMidName() {
        return midName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getSchoolStage() {
        return schoolStage;
    }
}
