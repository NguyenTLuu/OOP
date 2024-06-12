import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableCD extends JScrollPane {
    private JTable table;
    private DefaultTableModel model;
    private CD_Store cdStore;

    public TableCD() {
        cdStore = CD_Store.getInstance();
        init();
        setVisible(true);
    }

    public void init() {
        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Title");
        model.addColumn("Collection");
        model.addColumn("Type");
        model.addColumn("Price");
        table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        setViewportView(table);

    }

    public void load() {
        model.setRowCount(0);
        for (CD cd : cdStore.getCdList()) {
            model.addRow(new Object[]{cd.getTitle(),
                    cd.getCollection(),
                    cd.getType(),
                    cd.getPrice()});
        }
    }

    public void loadResult() {
        model.setRowCount(0);
        for (CD cd : cdStore.getCdResultList()) {
            model.addRow(new Object[]{cd.getTitle(),
                    cd.getCollection(),
                    cd.getType(),
                    cd.getPrice()});
        }
    }

    public void delete(){
        int row = table.getSelectedRow();
        if (row != -1) {
            String title = (String) model.getValueAt(row, 0);
            cdStore.deleteCD(title);
            model.removeRow(row);
        }
    }
}
