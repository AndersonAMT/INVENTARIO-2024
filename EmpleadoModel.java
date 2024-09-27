package Otro;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoModel {
    private List<Empleado> empleados;

    public EmpleadoModel() {
       empleados = new ArrayList<>();
    }

    // Los datos tienen Origen
    public void loadFromCSV(String NombreArchivo) {
      empleados.clear();         // Limpio la lista de empleados antes de leer un CSV
      try(BufferedReader br= new BufferedReader(new FileReader(NombreArchivo))) {
        String linea;
        while ( (linea = br.readLine()) != null  ) {  // mientras pueda sacarle una linea al CSV
            // arreglar aca para el Examen :)
            String[] datos = linea.split("\\|");
            int _id = Integer.parseInt(datos[0]);
            String _nombre = datos[1];
            double _sueldo = Double.parseDouble(datos[2]);
            empleados.add( new Empleado(_id, _nombre, _sueldo) );
        }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }


    // Los datos tiene Destino, consejo podriar usar constantes para el separador
    public void saveToCSV(String NombreArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(NombreArchivo))) {
            for (Empleado empleado : empleados) {
                // aqui editar para el examen
                pw.println( empleado.getId() + "|" +
                            empleado.getNombre() + "|" +
                            empleado.getSueldo() + "|" 
                );
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    //implemento las funciones para CRUD
    // private List<Empleado> empleados;
    //agregar
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);  // OJO SE ESTA AGREGANDO EL OBJETO EMPLEADO QUE CONTIENE ID,NOMBRE,SUELDO
    }

    //actualizar
    public void updateEmpleado(int index,Empleado empleado) {
        empleados.set(index, empleado); // pone en el indice el contenido objetivo ID,NOMBRE,SUELDO
    }                                  

    //Eliminar
    public void deleteEmpleado(int index) {
        empleados.remove(index);   // quito el objeto de la lista mediante su indice.
    }    

    //Obtener los datos del empleado
    public List<Empleado> getEmpleados(){
        return empleados;
    }

}
