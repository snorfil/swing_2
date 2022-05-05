import org.w3c.dom.CDATASection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class design1 extends JFrame {
    private JPanel padre;
    private JButton btn_showall;
    private JButton btn_menor;
    private JButton btn_mayoredad;
    private JButton burcarIdButton;
    private JTable table1;
    private JPanel padre_tabla;
    private JTextArea txt_edittext;

    private ArrayList<String> nombre;
    private ArrayList<ArrayList<Integer>> datos;

    public design1(String title) {
        super(title);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(padre);
        this.pack();

        btn_showall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_edittext.setText("acabo de p");
                table1.addColumn(new TableColumn(5));
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new design1("titulo");
        String[] columnNames = {"Nombre", "Años", "Apto",};
        Object[][] datos = {
                {"Juan", 25, false},
                {"Sonia", 33, true},
                {"Pedro", 42, false}};

        DefaultTableModel dtm = new DefaultTableModel(datos, columnNames);
        final JTable table = new JTable(dtm);

        // Agregar nueva columna
        String[] columnaNueva1 = {"vago", "diestro", "normal",};
        dtm.addColumn("Tipo", columnaNueva1);

        // Agregar nueva fila
        Object[] newRow = {"Maria", 55, false};
        dtm.addRow(newRow);

        // Modificar celda especifica
        dtm.setValueAt("XXX", 3, 3); // Row/Col

        table.setPreferredScrollableViewportSize(new Dimension(250, 100));
        JScrollPane scrollPane = new JScrollPane(table);
        jFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        jFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        jFrame.setVisible(true);

    }
}
