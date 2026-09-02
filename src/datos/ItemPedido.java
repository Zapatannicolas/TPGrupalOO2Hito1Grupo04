package datos;

import java.util.Objects;

public class ItemPedido {
	private int idItemPedido;
	private Plato plato;
	private int cantidad;
	private Pedido pedido;
	
	public ItemPedido() {
	}
	
	// Constructor
	public ItemPedido(Plato plato, int cantidad, Pedido pedido) {
		this.plato = plato;
		this.cantidad = cantidad;
		this.pedido = pedido;
	}
	

	// Getters y Setters
	public int getIdItemPedido() {
		return idItemPedido;
	}

	protected void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Plato getPlato() {
		return plato;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(cantidad), Integer.valueOf(idItemPedido), pedido, plato);
	}

	// Equals
	public boolean equals(ItemPedido item) {
		return (item.getPlato().equals(this.plato) && item.getPedido().equals(this.pedido));
	}
	
	@Override
	public String toString() {
		return "ItemPedido [idItemPedido=" + idItemPedido + ", plato=" + plato + ", cantidad=" + cantidad + "]";
	}
}
