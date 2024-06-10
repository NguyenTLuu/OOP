import java.io.*;
import java.util.ArrayList;

public final class StudentManager implements Serializable {
    private static StudentManager instance;

    private ArrayList<Student> studentList = new ArrayList<>();

    private StudentManager() {

    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public boolean addStudent(Student student) {
        for (Student stud : studentList)
            if (stud.getId().equals(student.getId()))
                return false;
        studentList.add(student);
        return true;
    }

    public void deleteStudent(String studentID) {
        for(Student s : studentList) {
            if (s.getId().equalsIgnoreCase(studentID)) {
                studentList.remove(s);
                outputToFile();
                break;
            }
        }
    }

    public void outputToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("Student.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Student student : studentList) {
                oos.writeObject(student);
            }
            oos.writeObject(null);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            studentList.clear();
            FileInputStream fis = new FileInputStream("Student.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student student;
            while ((student = (Student) ois.readObject()) != null) {
                studentList.add(student);
            }
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
//            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error Read file");
//            e.printStackTrace();
        }
    }


    public ArrayList<Student> getListStudent() {
        return studentList;
    }
}
