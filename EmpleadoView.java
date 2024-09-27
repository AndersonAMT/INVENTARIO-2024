package Otro;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmpleadoView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    // debo tener los botones CRUD
    private JButton loadButton;
    private JButton addButton;  
    private JButton editButton;
    private JButton deleteButton;  
    private JButton saveButton;  
 
    public EmpleadoView() {
        // voy a implementar un Jframe que tiene
        setTitle("Empleados de Futbol");
        setSize(640,480); // RESOLUCION VGA     qvga  vga svga 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Java Maneja Design Layout 
        setLocationRelativeTo(null);
        // responsive, que se acomodan los objetos segun la pantalla

        tableModel = new DefaultTableModel( new Object[] { "id", "nombre","sueldo" },0 );
        // tengo data en memoria, que es capaz de salir por la JTABLE

        table = new JTable(tableModel);
        // ahora si hago visual mi tabla
        JScrollPane scrollPane= new JScrollPane(table);   
        
        loadButton = new JButton("Leer CSV");
        addButton = new JButton("Agregar");  
        editButton = new JButton("Editar");
        deleteButton = new JButton("Eliminar");  
        saveButton = new JButton("Guardar CSV");        
        
        // Para agrupar algunos componentes se utilizan Panel
        JPanel ConjuntoDeBotones = new JPanel();
        ConjuntoDeBotones.add(loadButton);
        ConjuntoDeBotones.add(addButton);
        ConjuntoDeBotones.add(editButton);
        ConjuntoDeBotones.add(deleteButton);
        ConjuntoDeBotones.add(saveButton);
        
        add(scrollPane, BorderLayout.CENTER);
        add(ConjuntoDeBotones, BorderLayout.SOUTH);
    }

   //LISTENERs DE LOS BOTONES, PERO SIN IMPLEMENTAR CODIGO
   public void addLoadButtonListener(ActionListener listener) {
      loadButton.addActionListener(listener);
   }

   public void addaddButtonListener(ActionListener listener) {
    addButton.addActionListener(listener);
   }   

   public void addeditButtonListener(ActionListener listener) {
    editButton.addActionListener(listener);
   }   
  
   public void adddeleteButtonListener(ActionListener listener) {
    deleteButton.addActionListener(listener);
   }   
  
   public void addsaveButtonListener(ActionListener listener) {
    saveButton.addActionListener(listener);
   }     

   // FUNCIONES PARA EL MANEJO DE LA TABLA EN PANTALLA
   // esta funcion saca datos a partir de una arreglo filas columnas  
   public void setTableData(Object[][] data) {
        tableModel.setRowCount(0);
        for(Object[] row : data) {
            tableModel.addRow(row);
        }
    }
   // esta funcion obtiene el indice de lo que este presionando
   public int getSelectedRow(){
    return table.getSelectedRow();    
   } 
   // esta funcion obtiene una arreglo lineal con las columnas que existan
   public Object[] getRowData(int row) {
     int NroColumnas = tableModel.getColumnCount();  // PAra el examen NO CAMBIAR
     Object[] rowdata = new Object[NroColumnas];
    for (int i=0; i<NroColumnas; i++){
        rowdata[i]=tableModel.getValueAt(row,i);
    } 
    return rowdata;
   }

   public String getInput(String message){
       return JOptionPane.showInputDialog(this,message);
   }

   public String getInput(String message, String DefaultValue){
    return JOptionPane.showInputDialog(this,message, DefaultValue);
   }
   
   public void showMessage(String message) {
      JOptionPane.showMessageDialog(this, message);
   }

}
