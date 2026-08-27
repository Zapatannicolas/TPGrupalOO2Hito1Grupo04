package datos;

import java.time.LocalDate;

public class Cajero extends Persona{
	private String turno;
	
	public Cajero() {
	}


	public Cajero(String turno, int dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			float sueldoBase, LocalDate fechaEgreso, Festival festival) throws Exception {
		super(dni, nombre, apellido, fechaNacimiento, fechaIngreso, sueldoBase, fechaEgreso, festival);
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}


	public void setTurno(String turno) {
		this.turno = turno;
	}


	@Override
	public String toString() {
		return super.toString()+"Cajero [turno=" + turno + "]";
	}

	

	

	
	
}
