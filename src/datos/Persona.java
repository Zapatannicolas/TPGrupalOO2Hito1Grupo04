package datos;

import java.time.LocalDate;


public abstract class Persona {
	protected long idPersona;
	protected int dni;
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaNacimiento;
	protected LocalDate fechaIngreso;
	protected float sueldoBase;
	protected LocalDate fechaEgreso;
	private Festival festival;
	private UnidadVenta unidadVenta;


	public Persona() {
	}

	public Persona(int dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaIngreso,
			float sueldoBase, LocalDate fechaEgreso, Festival festival) throws Exception {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.setFechaNacimiento(fechaNacimiento);
		this.fechaIngreso = fechaIngreso;
		this.sueldoBase = sueldoBase;
		this.fechaEgreso = fechaEgreso;
		this.festival = festival;
	}

	public long getIdPersona() {
		return idPersona;
	}

	// siempre va protected, para que no sea modificado
	protected void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni)throws Exception {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) throws Exception {
		if(LocalDate.now().getYear() - fechaNacimiento.getYear() < 18) throw new Exception("La "
				+ "persona que intenta agregar es menor de edad");
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public LocalDate getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(LocalDate fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	
	public Festival getFestival() {
	    return festival;
	}

	public void setFestival(Festival festival) {
	    this.festival = festival;
	}
	
	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}

	public boolean equals(Persona p) {
		return dni == p.dni;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", fechaIngreso=" + fechaIngreso + ", sueldoBase=" + sueldoBase + ", fechaEgreso="
				+ fechaEgreso + "]";
	}

}
