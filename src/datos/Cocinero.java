package datos;

import java.time.LocalDate;

public class Cocinero extends Persona{
	private int idCocinero;
	private String especialidad;
	private int plusCategoria;
	
	
	public Cocinero() {
	}
	
	public Cocinero(String especialidad, int plusCategoria, int dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			float sueldoBase, LocalDate fechaEgreso) throws Exception {
		super(dni, nombre, apellido, fechaNacimiento, fechaIngreso, sueldoBase, fechaEgreso);
		this.especialidad = especialidad;
		this.plusCategoria = plusCategoria;
	}
	
	public int getIdCocinero() {
		return idCocinero;
	}

	protected void setIdCocinero(int idCocinero) {
		this.idCocinero = idCocinero;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getPlusCategoria() {
		return plusCategoria;
	}

	public void setPlusCategoria(int plusCategoria) {
		this.plusCategoria = plusCategoria;
	}

	@Override
	public String toString() {
		return super.toString()+"Cocinero [especialidad=" + especialidad + ", plusCategoria=" + plusCategoria + "]";
	}
	
	
}
