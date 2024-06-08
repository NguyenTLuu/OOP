import java.util.ArrayList;
import java.util.Scanner;

public class Researcher extends Staff {
    private int yearResearchExperience;
    private ArrayList<String> researchProjectCode = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public void input() {
        super.input();
        System.out.print("Enter year research experience: ");
        this.yearResearchExperience = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter number of research projects: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter research project code: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Project " + (i + 1) + ": ");
            String project = sc.nextLine();
            researchProjectCode.add(project);
        }
    }

    public int countProject_D() {
        int count = 0;
        for (String r : researchProjectCode)
            if (r.substring(0, 1).equalsIgnoreCase("D"))
                count++;
        return count;
    }

    @Override
    public double calculateSalary() {
        return this.salary = (this.yearResearchExperience * 2 + countProject_D()) * 20000;
    }

    @Override
    public void edit() {
        int option = 0;
        while (option < 6) {
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
                    this.setYearResearchExperience(sc.nextInt());
                    break;
                case 5:
                    this.editProjects();
                    break;

            }
        }
    }

    public void editProjects() {
        researchProjectCode.clear();
        System.out.print("Enter number of research projects: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter research project code: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Project " + (i + 1) + ": ");
            String project = sc.nextLine();
            researchProjectCode.add(project);
        }
    }

    public void typeOfInformation() {
        super.typeOfInformation();
        System.out.print("4. Year Research Experience");
        System.out.println("5. Research Projects");
    }

    public void setYearResearchExperience(int yearResearchExperience) {
        this.yearResearchExperience = yearResearchExperience;
    }
}
