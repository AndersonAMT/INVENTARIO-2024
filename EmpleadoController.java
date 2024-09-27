package Otro;


import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpleadoController {
    private EmpleadoModel model;
    private EmpleadoView view;
    
    public EmpleadoController(EmpleadoModel _model, EmpleadoView _view){
        this.model = _model;
        this.view = _view;

        // IMPLEMENTO LOS LISTENERS MEDIANTE INTERFACE
        this.view.addLoadButtonListener(new LoadButtonListener());
        this.view.addaddButtonListener(new  AddButtonListener());
        this.view.addeditButtonListener(new EditButtonListener());
        this.view.adddeleteButtonListener(new DeleteButtonListener());
        this.view.addsaveButtonListener(new saveButtonListener());


    }

    // Lee el CSV y lo saca a pantall 
    class LoadButtonListener implements ActionListener { // hago referencia a que implemento el Click
       @Override   // sobre escribo el metodo de la clase para el listener
       public void actionPerformed(ActionEvent e) {
          // implemento lo que haga mi click
          model.loadFromCSV("Empleado.csv");
          updateView();
       }
    }

    //
    class AddButtonListener implements ActionListener { // hago referencia a que implemento el Click
        @Override   // sobre escribo el metodo de la clase para el listener
        public void actionPerformed(ActionEvent e) {
           // implemento lo que haga mi click
           // vienen por defecto en formato STRING
           String idStr = view.getInput("Ingrese su ID");
           String nombreStr = view.getInput("Ingrese su nombre");
           String sueldoStr = view.getInput("Ingrese su sueldo");
           
           // hay posibles problemas OJO EXAMEN
           int _id = Integer.parseInt(idStr);
           String _nombre = nombreStr;
           double _sueldo = Double.parseDouble(sueldoStr);

           model.addEmpleado(new Empleado(_id, _nombre, _sueldo));
           updateView();  // MUESTRA A PANTALLA LOS DATOS
        }
     }

     class EditButtonListener implements ActionListener { // hago referencia a que implemento el Click
        @Override   // sobre escribo el metodo de la clase para el listener
        public void actionPerformed(ActionEvent e) {
           // implemento lo que haga mi click
           int selectedRow = view.getSelectedRow();
           if (selectedRow != -1) {
              Object[] rowData = view.getRowData(selectedRow);
              String idStr = view.getInput("Ingrese su ID",rowData[0].toString());
              String nombreStr = view.getInput("Ingrese su nombre",rowData[1].toString());
              String sueldoStr = view.getInput("Ingrese su sueldo",rowData[2].toString());              

              // hay posibles problemas OJO EXAMEN
              int _id = Integer.parseInt(idStr);
              String _nombre = nombreStr;
              double _sueldo = Double.parseDouble(sueldoStr);

              model.updateEmpleado(selectedRow, new Empleado(_id, _nombre, _sueldo));
              updateView();  // MUESTRA A PANTALLA LOS DATOS              
           }
        }
     }
     
     class DeleteButtonListener implements ActionListener { // hago referencia a que implemento el Click
        @Override   // sobre escribo el metodo de la clase para el listener
        public void actionPerformed(ActionEvent e) {
           // implemento lo que haga mi click
           int selectedRow = view.getSelectedRow();
           if (selectedRow != -1) {    
              // deberia confirmar si borrar o no
              model.deleteEmpleado(selectedRow);             
              updateView();
              view.showMessage("Se ha borrado al empleado...");
           }       
        }
     }
     
     class saveButtonListener implements ActionListener { // hago referencia a que implemento el Click
        @Override   // sobre escribo el metodo de la clase para el listener
        public void actionPerformed(ActionEvent e) {
           // implemento lo que haga mi click
           model.saveToCSV("Empleado.csv");
           view.showMessage("Se ha guardado a los empleados"); 
        }
     }     

    /*
     class cambiarClase implements ActionListener { // hago referencia a que implemento el Click
        @Override   // sobre escribo el metodo de la clase para el listener
        public void actionPerformed(ActionEvent e) {
           // implemento lo que haga mi click
 
        }
     } */   
      
    // Esta funcion saca los datos a pantalla 
    private void updateView() {
        List<Empleado> empleados = model.getEmpleados();
        Object[][] data = new Object[ empleados.size()][3]; // 3 columns  Fijarse para el Examen
        for (int i=0; i<empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            // Fijarse para el examen
            data[i][0] = empleado.getId();
            data[i][1] = empleado.getNombre();
            data[i][2] = empleado.getSueldo();
        }
        view.setTableData(data);
    } 
}
