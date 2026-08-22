package datos;

import java.util.Date;

public class Festival {
	
	private Long id;
    private String nombre;
    private String temporada;
    private Date fechaInicio;
    private Date fechaFin;
    private Set<UnidadVenta> unidadesVenta;
    private Set<Pedido> pedidos;
    
    public Festival() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
    
	
	public Set<UnidadVenta> getUnidadesVenta() {
		return unidadesVenta;
	}

	public void setUnidadesVenta(Set<UnidadVenta> unidadesVenta) {
		this.unidadesVenta = unidadesVenta;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Festival [id=" + id + ", nombre=" + nombre
				+ ", temporada=" + temporada + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + "]";
	}

}
