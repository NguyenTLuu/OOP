import java.util.Scanner;

public class Employee {
    private String code;
    private String fullName;
    private int yearOfSevice;
    private double salaryCoefficient;

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    private double basicSalary;
    private double salary;

    public Employee(String code, String fullName, int yearOfSevice) {
        this.code = code;
        this.fullName = fullName;
        this.yearOfSevice = yearOfSevice;
    }

    public Employee() {
    }

    public void inputEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee code: ");
        code = sc.nextLine();
        System.out.println("Enter employee full name: ");
        fullName = sc.nextLine();
        System.out.println("Enter employee year of sevice: ");
        yearOfSevice = sc.nextInt();
        this.salaryCoefficient = Math.pow(1.10, yearOfSevice);
        this.salary = salaryCoefficient * basicSalary;
    }

    public void print() {
        System.out.println("Fullname: " + fullName);
        System.out.println("Year of sevice: " + yearOfSevice);
        System.out.println("Salary: " + salary);
    }

    public double getSalary() {
        return salary;
    }

    public String getFullName() {
        return fullName;
    }
}
