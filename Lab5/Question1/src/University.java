import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class University {
    private Vector<Student> students = new Vector<>();

    static Scanner sc = new Scanner(System.in);

    public void inputToFile() {
        try {
            FileOutputStream f = new FileOutputStream("C:\\Users\\trong\\OneDrive\\Documents\\GitHub\\OOP\\Lab5\\Question1\\student.data");
            ObjectOutputStream oStream = new ObjectOutputStream(f);
            for (Student student : students) {
                oStream.writeObject(student);
            }
            oStream.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
        }
    }

    public void readFile() {
        try {
            Student st = null;
            FileInputStream f = new FileInputStream("C:\\Users\\trong\\OneDrive\\Documents\\GitHub\\OOP\\Lab5\\Question1\\student.data"); // tao file f tro den student.dat
            ObjectInputStream inStream = new ObjectInputStream(f);
            while ((st = (Student) inStream.readObject()) != null) {
                students.add(st);
            }
            inStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error Read file");
        }
    }


    public void addUniversityStudent() {
        Student s = new UniversityStudent();
        s.inputStudent();
        students.add(s);
        inputToFile();
    }

    public void addCollegeStudent() {
        Student s = new CollegeStudent();
        s.inputStudent();
        students.add(s);
        inputToFile();
    }

    public void removeStudents() {
        System.out.print("Enter remove Id: ");
        String removeId = sc.nextLine();
        for (Student s : students) {
            if (s.getStudentNumber().equalsIgnoreCase(removeId))
                students.remove(s);
        }
        for (Student s : students) {
            inputToFile();
        }
    }

    public void printStudentList() {
        for (Student s : students)
            System.out.println(s.toString());
    }

    public void printGraduateStudentList() {
        int studentGraduate = 0;
        for (Student s : students) {
            if (s.checkGraduate()) {
                System.out.println(s.toString());
                studentGraduate++;
            }
        }
        System.out.println("number of eligible students" + studentGraduate);
    }

    public void sortStudents() {
        Collections.sort(students, compareByType_Code);
        inputToFile();
    }

    static Comparator<Student> compareByType_Code = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {
            String className1 = s1.getClass().getSimpleName();
            String className2 = s2.getClass().getSimpleName();
            int classComparison = className1.compareTo(className2);
            if (classComparison != 0) {
                return classComparison;
            } else {
                int num1 = Integer.parseInt(s1.getStudentNumber());
                int num2 = Integer.parseInt(s2.getStudentNumber());
                return Integer.compare(num1, num2);
            }
        }
    };

    public void findStudent() {
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();
        for (Student s : students) {
            if (s.getFullName().toLowerCase().contains(studentName.toLowerCase())) {
                try {
                    FileOutputStream f = new FileOutputStream("C:\\Users\\trong\\OneDrive\\Documents\\GitHub\\OOP\\Lab5\\Question1\\Result.data");
                    ObjectOutputStream oStream = new ObjectOutputStream(f);
                    oStream.writeObject(s);
                    oStream.close();
                } catch (IOException e) {
                    System.out.println("Error Write file");
                }
            }
        }
    }

    public void showMenu() {
        System.out.println("1. Add a new college student.");
        System.out.println("2. Add a new university student.");
        System.out.println("3. Remove a student from the list with the student code entered from the keyboard.");
        System.out.println("4. Print student list.");
        System.out.println("5. Print the list of students eligible for graduation and indicate the number of eligible students.");
        System.out.println("6. Sort the student list ascending by Student type (College, university) and student code");
        System.out.println("7. Find student list by student's full name (Contains).");
        System.out.println("8. Exit");
    }

    public void pickOption() {
        Student s1 = new CollegeStudent();
        Student s2 = new UniversityStudent();
        int option = 0;
        while (option < 8) {
            showMenu();
            System.out.print("Enter option: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    addCollegeStudent();
                    break;
                case 2:
                    addUniversityStudent();
                    break;
                case 3:
                    removeStudents();
                    break;
                case 4:
                    printStudentList();
                    break;
                case 5:
                    printGraduateStudentList();
                    break;
                case 6:
                    sortStudents();
                    break;
                case 7:
                    findStudent();
                    break;
            }
        }
    }


}
