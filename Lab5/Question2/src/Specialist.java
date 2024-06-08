import java.util.ArrayList;
import java.util.Scanner;

public class Specialist extends Staff {
    private int yearWorkExperience;
    private ArrayList<String> educationalProjectCode = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public void input() {
        super.input();
        System.out.print("Enter year work experience: ");
        this.yearWorkExperience = sc.nextInt();
        System.out.println("Enter number of educational projects: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Project " + (i + 1) + ": ");
            String projectCode = sc.nextLine();
            educationalProjectCode.add(projectCode);
        }
    }

    public int countProject_T() {
        int count = 0;
        for (String r : educationalProjectCode)
            if (r.substring(0, 1).equalsIgnoreCase("T"))
                count++;
        return count;
    }

    @Override
    public double calculateSalary() {
        return this.salary = (yearWorkExperience * 4 + countProject_T()) * 18000;
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
                    this.setYearWorkExperience(sc.nextInt());
                    break;
                case 5:
                    this.editEducationalProject();
                    break;
            }
        }
    }

    public void editEducationalProject() {
        System.out.println("Enter number of educational projects: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Project " + (i + 1) + ": ");
            String projectCode = sc.nextLine();
            educationalProjectCode.add(projectCode);
        }
    }


    public void typeOfInformation() {
        super.typeOfInformation();
        System.out.print("4. Year work experience");
        System.out.print("5. Educational projects");
    }

    public void setYearWorkExperience(int yearWorkExperience) {
        this.yearWorkExperience = yearWorkExperience;
    }
}
