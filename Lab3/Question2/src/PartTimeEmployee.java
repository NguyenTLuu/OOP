import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.time.Year;


public class PartTimeEmployee extends Employee {
    private int workingHours;
    private float payRate;
    private ArrayList<PartTimeEmployee> PTem = new ArrayList<>();
    private float payment;
    private int age;

    public PartTimeEmployee(String employeeId, String employeeName, int yearOfBirth, String address, String phone, int workingHours, float payRate) {
        super(employeeId, employeeName, yearOfBirth, address, phone);
        this.workingHours = workingHours;
        this.payRate = payRate;
    }

    public PartTimeEmployee(int workingHours, float payRate) {
        this.workingHours = workingHours;
        this.payRate = payRate;
    }

    public PartTimeEmployee() {

    }

    public void inputPartTimeList() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Emter number of PT employee: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
            partTimeEmployee.inputPartTimeEmployee();
            PTem.add(partTimeEmployee);
        }
    }

    public void inputPartTimeEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        this.employeeId = sc.nextLine();
        System.out.println("Enter Employee Name: ");
        this.employeeName = sc.nextLine();
        System.out.println("Enter Year of Birth: ");
        this.yearOfBirth = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Address: ");
        this.address = sc.nextLine();
        System.out.println("Enter Phone Number: ");
        this.phone = sc.nextLine();
        System.out.println("Enter WorkingHours: ");
        this.workingHours = sc.nextInt();
        sc.nextLine();
        this.payRate = 0.8f;
        this.payment = this.payRate * this.workingHours;
        this.age = Year.now().getValue() - this.yearOfBirth;
    }

    public void display() {
        System.out.println("Employee ID: " + this.employeeId);
        System.out.println("Employee Name: " + this.employeeName);
        System.out.println("Employee Year of Birth: " + this.yearOfBirth);
        System.out.println("Employee Address: " + this.address);
        System.out.println("Employee Phone: " + this.phone);
        System.out.println("Employee WorkingHours: " + this.workingHours);
        System.out.println("Employee Pay Rate: " + this.payRate);
    }

    public void displayPartTimeEmployeeList() {
        for (PartTimeEmployee pt : PTem) {
            pt.display();
        }
    }

    public void searchPtByID(String id) {
        String searchId = id;
        for (PartTimeEmployee pt : PTem) {
            if (pt.employeeId.equalsIgnoreCase(searchId))
                pt.display();
        }
    }

    public void deletePtByID(String id) {
        String deleteId = id;
        for (PartTimeEmployee pt : PTem) {
            if (pt.employeeId.equalsIgnoreCase(deleteId))
                PTem.remove(pt);
        }
    }

    public void editPtByID(String id) {
        Scanner sc = new Scanner(System.in);
        String editId = id;
        for (PartTimeEmployee pt : PTem) {
            if (pt.employeeId.equalsIgnoreCase(editId)) {
                System.out.print("Enter Employee Name: ");
                this.employeeName = sc.nextLine();
                System.out.print("Enter Year of Birth: ");
                this.yearOfBirth = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Address: ");
                this.address = sc.nextLine();
                System.out.print("Enter Phone Number: ");
                this.phone = sc.nextLine();
                System.out.print("Enter WorkingHours: ");
                this.workingHours = sc.nextInt();
                sc.nextLine();
                this.payment = this.payRate * this.workingHours;
                this.age = Year.now().getValue() - this.yearOfBirth;
            }
        }
    }

    public void searchPtPayment(float payment) {
        Float searchPayment = payment;
        for (PartTimeEmployee pt : PTem) {
            if (pt.payment <= searchPayment)
                pt.display();
        }
    }

    static Comparator<PartTimeEmployee> compareByAge_Payment = new Comparator<PartTimeEmployee>() {
        public int compare(PartTimeEmployee p1, PartTimeEmployee p2) {
            if (p1.age > p2.age)
                return 1;
            else if (p1.age < p2.age)
                return -1;
            else {
                if (p1.payment > p2.payment)
                    return 1;
                else if (p1.payment < p2.payment)
                    return -1;
                else return 0;
            }
        }
    };

    public void sortByAge_Payment() {
        Collections.sort(PTem, compareByAge_Payment);
    }

    public ArrayList<PartTimeEmployee> getPTem() {
        return PTem;
    }

    @Override
    public String getInfo() {
        return "";
    }

    @Override
    public float getSalary() {
        return payRate * workingHours;
    }
}
