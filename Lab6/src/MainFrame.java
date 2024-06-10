import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    private JButton checkStudent, newStudent, refresh_button, export_button, delete_button;
    private StudentManager student = StudentManager.getInstance();
    private StudentTableModel studentTableModel;


    public MainFrame() {
        this.studentTableModel = new StudentTableModel();
        this.setSize(550, 550);
        this.setTitle("Student Management");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void init() {
        JPanel panel = new JPanel(new FlowLayout());

        checkStudent = new JButton("Check Total Student");
        checkStudent.setFocusable(false);
        checkStudent.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "There are " + student.getListStudent().size() + " student(s) in the database", "Message", JOptionPane.INFORMATION_MESSAGE);

        });

        newStudent = new JButton("New Student");
        newStudent.setFocusable(false);
        newStudent.addActionListener(e -> {
            NewStudent newStudent = new NewStudent(this);
        });

        refresh_button = new JButton("Refresh");
        refresh_button.setFocusable(false);
        refresh_button.addActionListener(e -> {
            studentTableModel.fillStudentTable(StudentManager.getInstance().getListStudent());
        });

        panel.add(checkStudent);
        panel.add(newStudent);
        panel.add(refresh_button);

        export_button = new JButton("Export to File");
        export_button.setFocusable(false);
        export_button.addActionListener(e -> {
            student.outputToFile();
            JOptionPane.showMessageDialog(null, "Export successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
        });

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(export_button);

        delete_button = new JButton("Delete");
        delete_button.setFocusable(false);
        delete_button.addActionListener(e -> {
            studentTableModel.deleteStudent();
            studentTableModel.fillStudentTable(StudentManager.getInstance().getListStudent());
        });
        panel.add(delete_button);

        this.add(panel, BorderLayout.NORTH);
        this.add(studentTableModel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
