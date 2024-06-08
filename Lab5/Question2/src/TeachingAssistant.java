import java.util.ArrayList;
import java.util.Scanner;

public class TeachingAssistant extends Staff {
    private ArrayList<String> subjectsAssist = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    @Override
    public double calculateSalary() {
        return this.salary = this.subjectsAssist.size() * 0.3 * 18000;
    }

    @Override
    public void edit() {
        int option = 0;
        while (option < 5) {
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
                    this.editSubjectsAssist();
                    break;
            }
        }
    }

    public void editSubjectsAssist() {
        subjectsAssist.clear();
        System.out.print("Enter number of assist subject: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter subject name: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            String subject = sc.nextLine();
            subjectsAssist.add(subject);
        }
    }

    public void typeOfInformation() {
        super.typeOfInformation();
        System.out.println("4. Subjects Assist");
    }

    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of assist subject: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter subject name: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            String subject = sc.nextLine();
            subjectsAssist.add(subject);
        }
    }
}
