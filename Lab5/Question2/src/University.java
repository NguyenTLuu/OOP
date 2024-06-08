import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.Serializable;

public class University implements Serializable {
    private ArrayList<Staff> staffList = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public void outputToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\EiuStaff.eiu");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Staff staff : staffList)
                oos.writeObject(staff);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
            e.printStackTrace();
        }
    }

    public void importFromFile() {
        try {
            Staff staff;
            FileInputStream fis = new FileInputStream("C:\\EiuStaff.eiu");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while ((staff = (Staff) ois.readObject()) != null) {
                staffList.add(staff);
            }
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error Read file");
        }
    }

    public void editStaff() {
        System.out.print("Enter Staff ID: ");
        String findId = sc.nextLine();
        for (Staff staff : staffList)
            if (findId.equalsIgnoreCase(staff.getId())) {
                staff.edit();
                outputToFile();
                break;
            }
    }

    public void removeStaff() {
        System.out.print("Enter Staff ID: ");
        String findId = sc.nextLine();
        for (Staff staff : staffList)
            if (findId.equalsIgnoreCase(staff.getId())) {
                staffList.remove(staff);
                outputToFile();
                break;
            }
    }

    public void outputSalary() {
        double totalSalary = 0;
        for (Staff staff : staffList) {
            totalSalary += staff.calculateSalary();
        }
        try {
            File f = new File("C:\\totalSalary.txt");
            FileWriter fw = new FileWriter(f);
            fw.write("Total salary of all staff: " + totalSalary + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
            e.printStackTrace();
        }
    }

    public void totalSalaryByType() {
        double salaryLecturer = 0;
        double salaryTeachingAssistant = 0;
        double salaryResearcher = 0;
        double salarySpecialist = 0;

        for (Staff staff : staffList) {
            if (staff instanceof Lecturer)
                salaryLecturer += staff.calculateSalary();
            if (staff instanceof TeachingAssistant)
                salaryTeachingAssistant += staff.calculateSalary();
            if (staff instanceof Researcher)
                salaryResearcher += staff.calculateSalary();
            if (staff instanceof Specialist)
                salarySpecialist += staff.calculateSalary();
        }

        try {
            File f = new File("C:\\TotalSalaryByType.txt");
            FileWriter fw = new FileWriter(f);
            fw.write("Total salary of all Lecturers: " + salaryLecturer + "\n");
            fw.write("Total salary of all Teaching Assistants: " + salaryTeachingAssistant + "\n");
            fw.write("Total salary of all Researchers: " + salaryResearcher + "\n");
            fw.write("Total salary of all Specialists: " + salarySpecialist + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
        }
    }

    public void threeHighestPaidStaff() {
        ArrayList<Staff> sortBySalary = new ArrayList<>(staffList);
        Collections.sort(sortBySalary, new Comparator<Staff>() {
            public int compare(Staff staff1, Staff staff2) {
                return Double.compare(staff1.calculateSalary(), staff2.calculateSalary());
            }
        });

        try {
            FileOutputStream fos = new FileOutputStream("C:\\HighestPaidStaff.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < 3; i++)
                oos.writeObject(sortBySalary.get(i));
            oos.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
            e.printStackTrace();
        }


    }


    public void inputStaff() {
        int option = 0;
        while (option < 5) {
            typeOfStaff();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    Staff lecturer = new Lecturer();
                    lecturer.input();
                    staffList.add(lecturer);
                    this.outputToFile();
                    System.out.println("Add successfully");
                    break;
                case 2:
                    Staff assistant = new TeachingAssistant();
                    assistant.input();
                    staffList.add(assistant);
                    this.outputToFile();
                    System.out.println("Add successfully");
                    break;
                case 3:
                    Staff researcher = new Researcher();
                    researcher.input();
                    staffList.add(researcher);
                    this.outputToFile();
                    System.out.println("Add successfully");
                    break;
                case 4:
                    Staff specialist = new Specialist();
                    specialist.input();
                    staffList.add(specialist);
                    this.outputToFile();
                    System.out.println("Add successfully");
                    break;
            }
        }
    }

    public void typeOfStaff() {
        System.out.println("Which type of staff do you want to add?");
        System.out.println("1. Add Lecturer");
        System.out.println("2. Add Assistant");
        System.out.println("3. Add Researcher");
        System.out.println("4. Add Specialist");
        System.out.println("5. Cancel");
    }

    public void menu() {
        int option = 0;
        while (option < 7) {
            chooseOption();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    inputStaff();
                    break;
                case 2:
                    editStaff();
                    break;
                case 3:
                    removeStaff();
                    break;
                case 4:
                    outputSalary();
                    break;
                case 5:
                    totalSalaryByType();
                    break;
                case 6:
                    threeHighestPaidStaff();
                    break;
            }
        }
    }

    public void chooseOption() {
        System.out.print("1. Enter the list of staff.");
        System.out.print("2. Find and edit staff information");
        System.out.print("3. Remove the staff from the list.");
        System.out.print("4. Perform the calculation of the total salary of all staff.");
        System.out.print("5. Statistics of the total salary of staff by type of staff.");
        System.out.print("6. Get a list of the 3 highest paid staff.");


    }
}
