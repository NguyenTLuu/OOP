import java.util.ArrayList;
import java.util.Scanner;

public class Lecturer extends Staff {
    private String academicRank;
    private String academicDegree;
    private int yearTeachExperience;
    private ArrayList<String> subjectsTeach = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);


    @Override
    public double calculateSalary() {
        return this.salary = this.subjectsTeach.size() * this.yearTeachExperience * 0.12 * 20000;
    }

    @Override
    public void edit() {
        int option = 0;
        while (option < 8) {
            typeOfInformation();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Enter: ");
                    this.setName(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter: ");
                    this.setDayOfBirth(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter: ");
                    this.setId(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter: ");
                    this.setAcademicRank(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter: ");
                    this.setAcademicDegree(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Enter: ");
                    this.setYearTeachExperience(sc.nextInt());
                    break;
                case 7:
                    this.editSubjectsTeach();
                    break;
            }
        }
    }

    public void editSubjectsTeach() {
        System.out.print("Enter number of subjects teach: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter subject name: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            String subject = sc.nextLine();
            subjectsTeach.add(subject);
        }
    }

    public void typeOfInformation() {
        super.typeOfInformation();
        System.out.println("4. Academic Rank");
        System.out.println("5. Academic Degree");
        System.out.println("6. Year Teach Experience");
        System.out.println("7. Subjects Teach");
    }

    public void input() {
        super.input();
        System.out.print("Enter academic rank: ");
        this.academicRank = sc.nextLine();
        System.out.print("Enter academic degree: ");
        this.academicDegree = sc.nextLine();
        System.out.print("Enter year teach experience: ");
        this.yearTeachExperience = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter number of subjects teach: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter subject name: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            String subject = sc.nextLine();
            subjectsTeach.add(subject);
        }
    }

    public void setAcademicRank(String academicRank) {
        this.academicRank = academicRank;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public void setYearTeachExperience(int yearTeachExperience) {
        this.yearTeachExperience = yearTeachExperience;
    }
}
