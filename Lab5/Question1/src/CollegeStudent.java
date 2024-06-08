import java.util.Scanner;

public class CollegeStudent extends Student {
    private double graduationScore;


    public CollegeStudent(String studentNumber, String fullName, int creditEarns, double averageScore, double graduationScore) {
        super(studentNumber, fullName, creditEarns, averageScore);
        this.graduationScore = graduationScore;
    }

    public CollegeStudent() {

    }

    static Scanner sc = new Scanner(System.in);

    public void inputStudent() {
        super.inputStudent();
        System.out.print("Enter graduation score: ");
        this.graduationScore = sc.nextDouble();
    }

    public String toString() {
        return super.toString()
                + "Graduation Score: " + this.graduationScore + "\n";
    }

    public boolean checkGraduate() {
        if (creditEarns >= 100) return true;
        return super.checkGraduate();
    }

}
