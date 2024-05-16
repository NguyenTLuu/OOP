import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {

    public void showMenu() {
        System.out.println("1. Add Full-time Employee (ArrayList)");
        System.out.println("2. Add Part-time Employee (ArrayList)");
        System.out.println("3. Show all Full-time Employee");
        System.out.println("4. Show all Part-time Employee");
        System.out.println("5. Show all Employee");
        System.out.println("6. Search Employee by Id");
        System.out.println("7. Delete Employee by Id ");
        System.out.println("8. Edit Employee information by Id ");
        System.out.println("9. Search Employee by payment");
        System.out.println("10. Sort Full-time Employee and Part-Time employee in ascending order by age, payment");
        System.out.println("11. Exit");
    }

    public void option() {
        int choice = 0;
        FullTimeEmployee fte = new FullTimeEmployee();
        PartTimeEmployee pte = new PartTimeEmployee();
        Scanner sc = new Scanner(System.in);
        while (choice != 11) {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            String id;
            switch (choice) {
                case 1:
                    fte.inputFullTimeList();
                    break;
                case 2:
                    pte.inputPartTimeList();
                    break;
                case 3:
                    fte.displayFullTimeEmployeeList();
                    break;
                case 4:
                    pte.displayPartTimeEmployeeList();
                    break;
                case 5:
                    fte.displayFullTimeEmployeeList();
                    System.out.println();
                    pte.displayPartTimeEmployeeList();
                    break;
                case 6:
                    System.out.println("Search Employee by ID: ");
                    id = sc.nextLine();
                    fte.searchFtById(id);
                    pte.searchPtByID(id);
                    break;
                case 7:
                    System.out.println("Delete Employee by ID: ");
                    id = sc.nextLine();
                    fte.deleteEmployee(id);
                    pte.deletePtByID(id);
                    break;
                case 8:
                    System.out.println("Edit Employee information by ID: ");
                    id = sc.nextLine();
                    fte.editEmployee(id);
                    pte.editPtByID(id);
                    break;
                case 9:
                    System.out.println("Enter Payment: ");
                    int payment = sc.nextInt();
                    fte.searchBySalary(payment);
                    pte.searchPtPayment(payment);
                    break;
                case 10:
                    fte.sortByAge_Payment();
                    pte.sortByAge_Payment();
                    break;
                case 11:
                    break;
            }
        }
    }
}
