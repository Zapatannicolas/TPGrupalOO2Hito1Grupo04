package datos;

import java.util.Objects;

public class Plato {
	private int idPlato;
	private String nombre;
	private float precio;
	private float costo;
	private UnidadVenta unidadVenta;
	
	public Plato() {
	}
	
	public Plato(String nombre, float precio, float costo, UnidadVenta unidadVenta) {
		this.nombre = nombre;
		this.precio = precio;
		this.costo = costo;
		this.unidadVenta = unidadVenta;
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
	
	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(Float.valueOf(costo), Integer.valueOf(idPlato), nombre, Float.valueOf(precio), unidadVenta);
	}

	// Equals
	public boolean equals(Plato plato) {
		return (plato.getNombre().equalsIgnoreCase(this.nombre) 
				&& plato.getPrecio() == this.precio 
				&& plato.getCosto() == this.costo);
	}

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precio=" + precio + ", costo=" + costo + "]";
	}
}
