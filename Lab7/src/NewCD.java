import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCD extends JDialog implements ActionListener {

    private JComboBox collection_box;
    private JTextField title_txt, price_txt;
    private JRadioButton cd, vcd;
    private ButtonGroup bg;
    private JButton add_button, cancel_button, clear_button;
    private CD_Store cdStore = CD_Store.getInstance();

    public NewCD(Frame parent) {
        setTitle("Add new CD");
        setSize(400, 300);
        setLayout(new GridLayout(4, 1));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        init();
        setResizable(false);
        setVisible(true);
    }

    public void init() {
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new FlowLayout());

        JLabel title_lable = new JLabel("CD Title");
        title_txt = new JTextField(10);
        panel1.add(title_lable);
        panel1.add(title_txt);

        JLabel collection_lable = new JLabel("CD Collection");
        JLabel type = new JLabel("CD Type");
        String[] collection = {"Music", "Game", "Movie"};
        collection_box = new JComboBox(collection);
        cd = new JRadioButton("CD");
        vcd = new JRadioButton("VCD");
        bg = new ButtonGroup();
        bg.add(cd);
        bg.add(vcd);
        panel2.add(collection_lable);
        panel2.add(collection_box);
        panel2.add(type);
        panel2.add(cd);
        panel2.add(vcd);

        JLabel price_lable = new JLabel("CD Price");
        price_txt = new JTextField(10);
        panel3.add(price_lable);
        panel3.add(price_txt);

        add_button = new JButton("Add");
        add_button.setFocusable(false);
        add_button.addActionListener(e -> {
            String cdTitle = title_txt.getText();
            String cdCollection = collection_box.getSelectedItem().toString();
            String cdType = "";
            if (cd.isSelected())
                cdType = "CD";
            if (vcd.isSelected())
                cdType = "VCD";
            int cdPrice = Integer.parseInt(price_txt.getText());
            CD cd = new CD(cdTitle, cdCollection, cdType, cdPrice);
            if (cdStore.addCD(cd))
                JOptionPane.showMessageDialog(this, "CD Added");
            else
                JOptionPane.showMessageDialog(this, "Title Existed");
        });

        cancel_button = new JButton("Cancel");
        cancel_button.setFocusable(false);
        cancel_button.addActionListener(e -> {
            this.dispose();
        });

        clear_button = new JButton("Clear");
        clear_button.setFocusable(false);
        clear_button.addActionListener(e -> {
            title_txt.setText("");
            price_txt.setText("");
            collection_box.setSelectedIndex(0);
            bg.clearSelection();
        });

        panel4.add(add_button);
        panel4.add(clear_button);
        panel4.add(cancel_button);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
