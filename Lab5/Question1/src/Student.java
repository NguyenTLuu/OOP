import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    protected String studentNumber;
    protected String fullName;
    protected int creditEarns;
    protected double averageScore;

    public Student(String studentNumber, String fullName, int creditEarns, double averageScore) {
        this.studentNumber = studentNumber;
        this.fullName = fullName;
        this.creditEarns = creditEarns;
        this.averageScore = averageScore;
    }

    public Student() {
    }

    static Scanner sc = new Scanner(System.in);

    public void inputStudent() {
        System.out.print("Enter student number: ");
        studentNumber = sc.nextLine();
        System.out.print("Enter full name: ");
        fullName = sc.nextLine();
        System.out.print("Enter credit earns: ");
        creditEarns = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter average score: ");
        averageScore = sc.nextDouble();
        sc.nextLine();
    }

    public String toString() {
        return "Student Number: " + studentNumber + "\n"
                + "Full Name: " + fullName + "\n"
                + "Credit Earns: " + creditEarns + "\n"
                + "Average Score: " + averageScore + "\n";
    }

    public boolean checkGraduate() {
        if (averageScore >= 5) return true;
        return false;
    }

    public String getFullName(){
        return fullName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
}
