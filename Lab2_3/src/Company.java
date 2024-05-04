import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Company {
    private ArrayList<Employee> employees = new ArrayList<>();
    private double basicSalary;

    public Company() {

    }

    public Company(int basicSalary) {
        this.basicSalary = basicSalary;
    }


    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            Employee e = new Employee();
            e.setBasicSalary(this.basicSalary);
            e.inputEmployee();
            employees.add(e);
        }
    }

    public void output() {
        for (Employee e : employees) {
            e.print();
        }
    }


    public void highestSalaryEmployee() {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e2.getSalary(), e1.getSalary());
            }
        });

        System.out.println("Employee with highest Salary: " + employees.get(0).getFullName() + " | Salary: " + employees.get(0).getSalary());
    }

    public void printEmployeesBySalary() {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e2.getSalary(), e1.getSalary());
            }
        });

        // Print out sorted employees
        System.out.println("Sorting by descending Salary");
        for (Employee employee : employees) {
            System.out.println("Employee name: " + employee.getFullName() + " | Salary: " + employee.getSalary());
        }
    }
}
