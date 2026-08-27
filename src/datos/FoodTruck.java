package datos;

public class FoodTruck extends UnidadVenta{
	private String patente;
	private boolean usaLuz;
	
	
	public FoodTruck() {};
	
	public FoodTruck(String nombreComercial, double superficie, String codigoUnico, Persona responsable, String patente, boolean usaLuz) {
		super(nombreComercial, superficie, codigoUnico, responsable);
		this.patente = patente;
		this.usaLuz = usaLuz;
	}
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public boolean isUsaLuz() {
		return usaLuz;
	}
	public void setUsaLuz(boolean usaLuz) {
		this.usaLuz = usaLuz;
	}

	@Override
	public String toString() {
		return "FoodTruck [patente=" + patente + ", usaLuz=" + usaLuz + "]";
	}
	
	
}
