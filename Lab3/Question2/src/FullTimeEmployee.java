import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FullTimeEmployee extends Employee {
    private int salary;
    private int age;
    private ArrayList<FullTimeEmployee> FTem = new ArrayList<>();

    public FullTimeEmployee(String employeeId, String employeeName, int yearOfBirth, String address, String phone, int salary) {
        super(employeeId, employeeName, yearOfBirth, address, phone);
        this.salary = salary;
    }

    public FullTimeEmployee() {

    }

    public void inputFullTimeList() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            FullTimeEmployee em = new FullTimeEmployee();
            em.inputFullTimeEmployee();
            FTem.add(em);
        }
    }

    public void inputFullTimeEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee ID: ");
        this.employeeId = sc.nextLine();
        System.out.println("Enter the employee name: ");
        this.employeeName = sc.nextLine();
        System.out.println("Enter the year of birth: ");
        this.yearOfBirth = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the address: ");
        this.address = sc.nextLine();
        System.out.println("Enter the phone number: ");
        this.phone = sc.nextLine();
        System.out.println("Enter the salary: ");
        this.salary = sc.nextInt();
        sc.nextLine();
        this.age = Year.now().getValue() - this.yearOfBirth;
    }

    public void display() {
        System.out.println("Employee ID: " + this.employeeId);
        System.out.println("Employee Name: " + this.employeeName);
        System.out.println("Employee Year of Birth: " + this.yearOfBirth);
        System.out.println("Employee Address: " + this.address);
        System.out.println("Employee Phone: " + this.phone);
        System.out.println("Employee Salary: " + this.salary);
    }

    public void displayFullTimeEmployeeList() {
        for (FullTimeEmployee pt : FTem) {
            pt.display();
        }
    }

    public void searchFtById(String id) {
        String searchId = id;
        for (FullTimeEmployee ft : FTem) {
            if (ft.employeeId.equals(searchId)) {
                ft.display();
            }
        }
    }

    public void deleteEmployee(String id) {
        String deleteId = id;
        for (Employee ft : FTem) {
            if (ft.employeeId.equals(deleteId))
                FTem.remove(ft);
        }
    }

    public void editEmployee(String id) {
        Scanner sc = new Scanner(System.in);
        String editId = id;
        for (FullTimeEmployee ft : FTem) {
            if (ft.employeeId.equalsIgnoreCase(editId)) {
                System.out.print("Enter the employee name: ");
                this.employeeName = sc.nextLine();
                System.out.print("Enter the year of birth: ");
                this.yearOfBirth = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter the address: ");
                this.address = sc.nextLine();
                System.out.print("Enter the phone number: ");
                this.phone = sc.nextLine();
                System.out.print("Enter the salary: ");
                this.salary = sc.nextInt();
                sc.nextLine();
            }
        }
    }

    public void searchBySalary(int payment) {
        int searchSalary = payment;
        for (FullTimeEmployee ft : FTem) {
            if (ft.salary <= searchSalary)
                ft.display();
        }
    }

    static Comparator<FullTimeEmployee> compareByAge_Payment = new Comparator<FullTimeEmployee>() {
        public int compare(FullTimeEmployee p1, FullTimeEmployee p2) {
            if (p1.age > p2.age)
                return 1;
            else if (p1.age < p2.age)
                return -1;
            else {
                if (p1.salary > p2.salary)
                    return 1;
                else if (p1.salary < p2.salary)
                    return -1;
                else return 0;
            }
        }
    };

    public void sortByAge_Payment() {
        Collections.sort(FTem, compareByAge_Payment);
    }

    public ArrayList<FullTimeEmployee> getFTem() {
        return FTem;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public String getInfo() {
        return "";
    }

    @Override
    public float getSalary() {
        return salary;
    }
}
