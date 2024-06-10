import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewStudent extends JDialog implements ActionListener {
    private Student st;
    private JTextField textField_id, textField_firstName, textField_middleName, textField_lastName, textField_birth;
    private JRadioButton male, female;
    private JComboBox comboBox;
    private ButtonGroup bg;
    private JButton save, clear, cancel;


    public NewStudent(JFrame frame) {
        setTitle("New Student");
        setSize(500, 300);
        setModal(true);
        setLocationRelativeTo(frame);
        init();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1));
        setVisible(true);
    }

    public void init() {
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new FlowLayout());
        JPanel panel5 = new JPanel(new FlowLayout());

        textField_id = new JTextField(10);
        panel1.add(new JLabel("Student ID: "));
        panel1.add(textField_id);

        textField_lastName = new JTextField(10);
        textField_middleName = new JTextField(10);
        textField_firstName = new JTextField(10);
        panel2.add(new JLabel("Last-Mid-First Name: "));
        panel2.add(textField_lastName);
        panel2.add(textField_middleName);
        panel2.add(textField_firstName);

        textField_birth = new JTextField(10);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        panel3.add(new JLabel("Year of Birth: "));
        panel3.add(textField_birth);
        panel3.add(male);
        panel3.add(female);

        String[] schoolStage = {"Elementary School", "Middle School", "High School"};
        comboBox = new JComboBox(schoolStage);
        panel4.add(comboBox);

        save = new JButton("Save");
        save.setFocusable(false);
        save.addActionListener(e -> {
            String id = textField_id.getText();
            String lastName = textField_lastName.getText();
            String middleName = textField_middleName.getText();
            String firstName = textField_firstName.getText();
            int birth = Integer.valueOf(textField_birth.getText());
            String gender = "";
            if (male.isSelected())
                gender = "Male";
            if (female.isSelected())
                gender = "Female";
            String schStage = comboBox.getSelectedItem().toString();
            st = new Student(id, lastName, middleName, firstName, birth, gender, schStage);
            if (StudentManager.getInstance().addStudent(st))
                JOptionPane.showMessageDialog(this, "Student Added");
            else
                JOptionPane.showMessageDialog(this, "Student’s ID is existed");
        });

        clear = new JButton("Clear");
        clear.setFocusable(false);
        clear.addActionListener(e->{
            clearText();
        });

        cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.addActionListener(e -> {
            dispose();
        });
        panel5.add(save);
        panel5.add(clear);
        panel5.add(cancel);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
    }

    public void clearText(){
        textField_id.setText("");
        textField_lastName.setText("");
        textField_middleName.setText("");
        textField_firstName.setText("");
        textField_birth.setText("");
        comboBox.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
