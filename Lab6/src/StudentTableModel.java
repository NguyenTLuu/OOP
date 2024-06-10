import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class StudentTableModel extends JScrollPane {
    private DefaultTableModel model;
    private JTable table;
    private StudentManager studentManager = StudentManager.getInstance();

    public StudentTableModel() {
        init();
        this.setVisible(true);
    }

    public void init() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Gender");
        model.addColumn("School Stage");
        table = new JTable(model);
        fillStudentTable(StudentManager.getInstance().getListStudent());
        setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false);

    }


    public void fillStudentTable(ArrayList<Student> students) {
        model.setRowCount(0);
        for (Student student : students) {
            model.addRow(new String[]{student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getGender(),
                    student.getSchoolStage()
            });
        }
    }

    public void deleteStudent() {
        int row = table.getSelectedRow();
        if (row != -1) {
            String id = (String) model.getValueAt(row, 0);
            studentManager.deleteStudent(id);
            model.removeRow(row);
        }
    }
}
