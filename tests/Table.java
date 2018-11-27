import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

class Table extends JFrame {
    
    private Table() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        Object rowData = new Object[][]
                {
                        {"Дядя Фёдор", "6 лет"},
                        {"Матроскин", "2 года"},
                        {"Шарик", "3 года"},
                        {"Почтальон Печкин", "57 лет"}
                };
        
        Object columnNames = new Object[] {"Name", "Age"};
        
        JTable table = new JTable(new AbstractTableModel() {
            public String getColumnName(int column) {
                return ((Object[]) columnNames)[column].toString();
            }
    
            public int getRowCount() {
                return ((Object[]) rowData).length;
            }
    
            public int getColumnCount() {
                return ((Object[]) columnNames).length;
            }
    
            public Object getValueAt(int row, int col) {
                return ((Object[][]) rowData)[row][col];
            }
    
            public boolean isCellEditable(int row, int column) {
                return false;
            }
    
            public void setValueAt(Object value, int row, int col) {
                ((Object[][]) rowData)[row][col] = value;
                fireTableCellUpdated(row, col);
            }
        });
    
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("Arial", Font.ITALIC, 20));
        TableColumn column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(200);
        
        panel.add(table);
        add(panel);
        
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    public static void main(String[] args) {
        new Table();
    }
}
