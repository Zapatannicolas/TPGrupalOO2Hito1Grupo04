package datos;

public class Plato {
	private int idPlato;
	private String nombre;
	private float precio;
	private float costo;
	
	public Plato() {
	}
	
	public Plato(String nombre, float precio, float costo) {
		this.nombre = nombre;
		this.precio = precio;
		this.costo = costo;
	}

	public int getIdPlato() {
		return idPlato;
	}

	protected void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precio=" + precio + ", costo=" + costo + "]";
	}

	// Equals
	public boolean equals(Plato plato) {
		return (plato.getNombre().equalsIgnoreCase(this.nombre) && plato.getPrecio() == this.precio);
	}
}
