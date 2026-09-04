package datos;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Festival {
	
	private Long id;
    private String nombre;
    private String temporada;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoSuperficie;
    private double costoMontaje;
    private double plusElectricidad;
    private double sueldoBase;
    private Set<UnidadVenta> unidadesVenta;
    
    public Festival() {
    	
    }
    

	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, double costoSuperficie,
			double costoMontaje, double plusElectricidad, double sueldoBase) {
		super();
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costoSuperficie = costoSuperficie;
		this.costoMontaje = costoMontaje;
		this.plusElectricidad = plusElectricidad;
		this.sueldoBase = sueldoBase;
	}

	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
    
	
	public Set<UnidadVenta> getUnidadesVenta() {
		return unidadesVenta;
	}

	public void setUnidadesVenta(Set<UnidadVenta> unidadesVenta) {
		this.unidadesVenta = unidadesVenta;
	}
	
	
	public double getCostoSuperficie() {
		return costoSuperficie;
	}

	public void setCostoSuperficie(double costoSuperficie) {
		this.costoSuperficie = costoSuperficie;
	}

	public double getCostoMontaje() {
		return costoMontaje;
	}

	public void setCostoMontaje(double costoMontaje) {
		this.costoMontaje = costoMontaje;
	}

	public double getPlusElectricidad() {
		return plusElectricidad;
	}

	public void setPlusElectricidad(double plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Festival other = (Festival) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Festival [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", costoSuperficie=" + costoSuperficie + ", costoMontaje=" + costoMontaje
				+ ", plusElectricidad=" + plusElectricidad + ", sueldoBase=" + sueldoBase + "]";
	}

	

}
