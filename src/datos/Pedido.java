package datos;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Pedido {
	private int idPedido;
	private LocalDate fecha;
	private UnidadVenta unidadVenta;
	private Set<ItemPedido> items;
	private boolean terminado;
	
	public Pedido() {
	}

	// Constructor
	public Pedido(LocalDate fecha, UnidadVenta unidadVenta) {
		this.fecha = fecha;
		this.unidadVenta = unidadVenta;
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

	
	@Override
	public int hashCode() {
		return Objects.hash(fecha, Integer.valueOf(idPedido), items, Boolean.valueOf(terminado), unidadVenta);
	}

	// Equals
	public boolean equals(Pedido pedido) {
		return (pedido.getFecha().isEqual(this.fecha) && pedido.getUnidadVenta().equals(this.unidadVenta));
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fecha=" + fecha + "]";
	}
}
