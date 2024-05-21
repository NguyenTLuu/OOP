import java.util.Scanner;

public class UniversityStudent extends Student {
    private String thesisName;
    private double thesisScore;


    public UniversityStudent(String studentNumber, String fullName, int creditEarns, double averageScore, String thesisName, double thesisScore) {
        super(studentNumber, fullName, creditEarns, averageScore);
        this.thesisName = thesisName;
        this.thesisScore = thesisScore;
    }

    public UniversityStudent() {

    }

    static Scanner sc = new Scanner(System.in);

    public void inputStudent() {
        super.inputStudent();
        System.out.print("Enter Thesis Name: ");
        thesisName = sc.nextLine();
        System.out.print("Enter Thesis Score: ");
        thesisScore = sc.nextDouble();
        sc.nextLine();
    }

    public String toString() {
        return super.toString()
                + "Thesis Name: " + thesisName + "\n"
                + "Thesis Score: " + thesisScore + "\n";
    }

    public boolean checkGraduate() {
        if (creditEarns >= 150) return true;
        if (thesisScore >= 5) return true;
        return super.checkGraduate();
    }
}
