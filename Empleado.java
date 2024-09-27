package Otro;

public class Empleado{
    private int id;
    private String nombre;
    private double sueldo;

    public Empleado(int _id, String _nombre, double _sueldo) {
        this.id = _id;
        this.nombre = _nombre;
        this.sueldo = _sueldo;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

}