import java.io.Serializable;
import java.util.Scanner;

public abstract class Staff implements Serializable {
    protected String name;
    protected String dayOfBirth;
    protected String id;
    protected double salary;

    public abstract double calculateSalary();

    public abstract void edit();

    public void typeOfInformation(){
        System.out.println("Which information would you like to edit?");
        System.out.println("1. Name");
        System.out.println("2. Date of Birth");
        System.out.println("3. ID");
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter day of birth (dd/mm/yyyy): ");
        this.dayOfBirth = sc.nextLine();
        System.out.print("Enter ID: ");
        this.id = sc.nextLine();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
