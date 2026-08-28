package datos;

import java.util.Set;

public abstract class UnidadVenta {

	private long idUnidadVenta;
	protected String nombreComercial;
	protected double superficie;
	protected String codigoUnico;
	protected Persona responsable; 
	private Set<Persona> staff;
	private Set<Plato> platos;
	private Set<Pedido> pedidos;

	public UnidadVenta() {}

	
	
	public UnidadVenta(String nombreComercial, double superficie, String codigoUnico, Persona responsable) {
		super();
		this.nombreComercial = nombreComercial;
		this.superficie = superficie;
		this.codigoUnico = codigoUnico;
		this.responsable = responsable;
	}


	public long getIdUnidadVenta() {
		return idUnidadVenta;
	}

	protected void setIdUnidadVenta(long idUnidadVenta) {
		this.idUnidadVenta = idUnidadVenta;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public String getCodigoUnico() {
		return codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public Set<Persona> getStaff() {
		return staff;
	}

	public void setStaff(Set<Persona> staff) {
		this.staff = staff;
	}

	public Set<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(Set<Plato> platos) {
		this.platos = platos;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	@Override
	public String toString() {
		return "UnidadVenta [idUnidadVenta=" + idUnidadVenta + ", nombreComercial=" + nombreComercial + ", superficie="
				+ superficie + ", codigoUnico=" + codigoUnico + "]";
	};
	
	
}
