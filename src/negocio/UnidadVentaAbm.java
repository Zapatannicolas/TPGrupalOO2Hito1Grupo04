package negocio;
import java.time.LocalDate;
import java.util.List;

import dao.UnidadVentaDao;
import datos.UnidadVenta;
import datos.FoodTruck;
import datos.PuestoDesarmable;

public class UnidadVentaAbm {
	
	UnidadVentaDao dao = new UnidadVentaDao();

	public int agregarFoodTruck(String nombreComercial, double superficie, String codigoUnico, Persona responsable, String patente, boolean usaLuz) throws Exception{
		if(traer(codigoUnico)!= null) throw new Exception("Ya existe una unidad de venta con el mismo codigo");
		UnidadVenta u = new FoodTruck(nombreComercial,superficie,codigoUnico,responsable,patente,usaLuz );
	    return dao.agregar(u);
	}

	public int agregarPuestoDesarmable(String nombreComercial, double superficie, String codigoUnico, Persona responsable, int cantidad, int tiempoMontaje) throws Exception{
		if(traer(codigoUnico)!= null) throw new Exception("Ya existe una unidad de venta con el mismo codigo");
		UnidadVenta u = new PuestoDesarmable(nombreComercial,superficie,codigoUnico,responsable,cantidad,tiempoMontaje);
	    return dao.agregar(u);
	}
	
	public UnidadVenta traer(long idUnidadVenta) {
		return dao.traer(idUnidadVenta);
	}

	public UnidadVenta traer(String codigoUnico) {
		return dao.traer(codigoUnico);
	}
	
	public List<UnidadVenta> traer() {
		return dao.traer();
	}
	
	public UnidadVenta traerUnidadVentaYPedidos(long idUnidadVenta) {
		return dao.traer(idUnidadVenta);
	}

	public void modificar(UnidadVenta u) throws Exception{
		UnidadVenta encontrada = traer(u.getCodigoUnico());
		if(encontrada !=null && encontrada.getIdUnidadVenta() != u.getIdUnidadVenta()) throw new Exception ("ERROR el codigo unico ya esta en uso");
		dao.actualizar(u);
	}


	public void eliminar(long idUnidadVenta) throws Exception {
		UnidadVenta u = dao.traer(idUnidadVenta);
		if(u == null) throw new Exception ("ERROR unidad de venta no encontrada");
		dao.eliminar(u);
	}
	
	
}

