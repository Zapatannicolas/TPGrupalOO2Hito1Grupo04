package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {
	private int idPedido;
	private LocalDate fecha;
	private UnidadVenta unidadVenta;
	private Set<ItemPedido> items;
	private boolean terminado;
	private Festival festival;
	
	public Pedido() {
	}

	// Constructor
	public Pedido(LocalDate fecha, UnidadVenta unidadVenta, Festival festival) {
		this.fecha = fecha;
		this.unidadVenta = unidadVenta;
		this.festival = festival;
	}

	// Getters y Setters
	public int getIdPedido() {
		return idPedido;
	}

	protected void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}

	public Set<ItemPedido> getItems() {
		return items;
	}

	public void setItems(Set<ItemPedido> items) {
		this.items = items;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}
	
	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fecha=" + fecha + "]";
	}
}
