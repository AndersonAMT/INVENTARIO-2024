package Otro;

// una aplicacion swing debe correr desde un contenedor RunAble

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        System.out.print("Nuevo mensaje");
        System.out.print("PRUEBA DE CAMBIOS");
         SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                EmpleadoModel model = new EmpleadoModel();
                EmpleadoView view = new EmpleadoView();
                EmpleadoController controller = new EmpleadoController(model, view);
                view.setVisible(true);
            }            
         });
    }
}
