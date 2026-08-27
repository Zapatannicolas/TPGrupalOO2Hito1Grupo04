package datos;

public class PuestoDesarmable extends UnidadVenta{
	private int cantidad;
	private int tiempoMontaje;
	
	public PuestoDesarmable() {};
	
	public PuestoDesarmable(String nombreComercial, double superficie, String codigoUnico, Persona responsable, int cantidad, int tiempoMontaje) {
		super(nombreComercial,superficie,codigoUnico,responsable);
		this.cantidad = cantidad;
		this.tiempoMontaje = tiempoMontaje;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getTiempoMontaje() {
		return tiempoMontaje;
	}

	public void setTiempoMontaje(int tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}

	@Override
	public String toString() {
		return "PuestoDesarmable [cantidad=" + cantidad + ", tiempoMontaje=" + tiempoMontaje + "]";
	} 
	
}
