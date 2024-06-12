import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame extends JFrame implements ActionListener {
    private JButton new_button, backup_button, delete_button, refresh_button, restore_button, search_button, saveResult_button;
    private JTextField search_txt;
    private NewCD newCD;
    private TableCD tableCD = new TableCD();
    private CD_Store cdStore;

    public MainFrame() {
        setTitle("CD Store");
        cdStore = CD_Store.getInstance();
        setLayout(new BorderLayout());
        setSize(550, 550);
        init();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init() {
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();

        new_button = new JButton("New CD");
        new_button.setFocusable(false);
        new_button.addActionListener(e -> {
            newCD = new NewCD(this);
        });

        backup_button = new JButton("Backup");
        backup_button.setFocusable(false);
        backup_button.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView());
            int r = chooser.showSaveDialog(this);
            System.out.println(r);
            if (r == JFileChooser.APPROVE_OPTION) {
                cdStore.outputToFile(chooser.getSelectedFile().getAbsolutePath());
                cdStore.getFilePath(chooser.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(MainFrame.this, "Saved to " + chooser.getSelectedFile().getAbsolutePath());
            }
        });

        delete_button = new JButton("Delete");
        delete_button.setFocusable(false);
        delete_button.addActionListener(e -> {
            tableCD.delete();
            tableCD.load();
        });

        refresh_button = new JButton("Refresh");
        refresh_button.setFocusable(false);
        refresh_button.addActionListener(e -> {
            tableCD.load();
        });

        restore_button = new JButton("Restore");
        restore_button.setFocusable(false);
        restore_button.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView());
            int r = chooser.showOpenDialog(this);
            if (r == JFileChooser.APPROVE_OPTION) {
                cdStore.readFromFile(chooser.getSelectedFile().getAbsolutePath());
                cdStore.getFilePath(chooser.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(MainFrame.this, "Imported data from " + chooser.getSelectedFile().getAbsolutePath());
            }
            tableCD.load();
        });

        search_button = new JButton("Search");
        search_button.setFocusable(false);
        search_button.addActionListener(e -> {
            if (search_txt.getText().isEmpty())
                JOptionPane.showMessageDialog(MainFrame.this, "Search Box cannot be empty");
            else {
                String keyword = search_txt.getText();
                cdStore.searchCD(keyword);
                tableCD.loadResult();
            }
        });

        panel.add(new_button);
        panel.add(backup_button);
        panel.add(restore_button);
        panel.add(refresh_button);
        panel.add(delete_button);

        search_txt = new JTextField(20);
        saveResult_button = new JButton("Save result");
        saveResult_button.setFocusable(false);
        saveResult_button.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView());
            int r = chooser.showSaveDialog(this);
            if (r == JFileChooser.APPROVE_OPTION) {
                cdStore.outputResultToFile(chooser.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(MainFrame.this, "Saved result to " + chooser.getSelectedFile().getAbsolutePath());
            }
        });

        panel2.add(search_txt);
        panel2.add(search_button);
        panel2.add(saveResult_button);

        this.add(panel, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.SOUTH);
        this.add(tableCD, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
