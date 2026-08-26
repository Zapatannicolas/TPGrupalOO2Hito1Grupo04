package datos;

import java.time.LocalDate;

public class Cajero extends Persona{
	private int idCajero;
	private String turno;
	
	public Cajero() {
	}


	public Cajero(String turno, int dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			float sueldoBase, LocalDate fechaEgreso) throws Exception {
		super(dni, nombre, apellido, fechaNacimiento, fechaIngreso, sueldoBase, fechaEgreso);
		this.turno = turno;
	}

	public int getIdCajero() {
		return idCajero;
	}


	protected void setIdCajero(int idCajero) {
		this.idCajero = idCajero;
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
