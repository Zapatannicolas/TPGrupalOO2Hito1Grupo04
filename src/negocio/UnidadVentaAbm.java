package negocio;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import dao.UnidadVentaDao;
import datos.UnidadVenta;
import datos.Cajero;
import datos.Cocinero;
import datos.Festival;
import datos.FoodTruck;
import datos.Pedido;
import datos.Persona;
import datos.PuestoDesarmable;

public class UnidadVentaAbm {
	
	UnidadVentaDao dao = new UnidadVentaDao();
	
	public int agregarFoodTruck(String nombreComercial, double superficie, String codigoUnico, Persona responsable, Festival festival, String patente, boolean usaLuz) throws Exception{
        if(traer(codigoUnico)!=null) throw new Exception("ERROR ya existe un food Truck con el mismo codigo");
		return dao.agregar(new FoodTruck(nombreComercial, superficie, codigoUnico, responsable, festival, patente, usaLuz));
	};
	
	public int agregarPuestoDesarmable(String nombreComercial, double superficie, String codigoUnico, Persona responsable, Festival festival, int cantidad, int tiempoMontaje) throws Exception {
        if(traer(codigoUnico)!=null) throw new Exception("ERROR ya existe un puesto desarmable con el mismo codigo");
		return dao.agregar(new PuestoDesarmable(nombreComercial, superficie, codigoUnico, responsable, festival, cantidad, tiempoMontaje));
	};
	
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
		return dao.traerUnidadVentaYPedidos(idUnidadVenta);
	}

	public UnidadVenta traerUnidadVentaYStaff(long idUnidadVenta) {
		return dao.traerUnidadVentaYStaff(idUnidadVenta);
	}
	
	public void modificar(UnidadVenta u) throws Exception{
		UnidadVenta encontrada = traer(u.getIdUnidadVenta());
		if(encontrada !=null && encontrada.getIdUnidadVenta() != u.getIdUnidadVenta()) throw new Exception ("ERROR el codigo unico ya esta en uso");
		dao.actualizar(u);
	}


	public void eliminar(long idUnidadVenta) throws Exception {
		UnidadVenta u = dao.traer(idUnidadVenta);
		if(u == null) throw new Exception ("ERROR unidad de venta no encontrada");
		dao.eliminar(u);
	}
	
	public void agregarStaffAUnidadVenta(UnidadVenta unidadVenta, Persona persona) throws Exception {
	    if (unidadVenta == null) {
	        throw new Exception("La Unidad de Venta no puede ser nula.");
	    }
	    if (persona == null) {
	        throw new Exception("La Persona no puede ser nula.");
	    }

	    // Llamamos al DAO para que agregue a la lista en memoria y actualice la BD
	    dao.agregarStaffAUnidadVenta(unidadVenta, persona);
	}

	public void agregarPedidosAUnidadVenta(UnidadVenta unidadVenta, Pedido pedido) throws Exception {
	    if (unidadVenta == null) {
	        throw new Exception("La Unidad de Venta no puede ser nula.");
	    }
	    if (pedido == null) {
	        throw new Exception("El pedido no puede ser null.");
	    }

	    // Llamamos al DAO para que agregue a la lista en memoria y actualice la BD
	    dao.agregarPedidosAUnidadVenta(unidadVenta, pedido);
	}
	
	public List<Cajero> traerCajerosPorSueldo(long idUnidadVenta, float sueldo) {

        return dao.traerCajerosPorSueldo(idUnidadVenta, sueldo);

    }
	
	 public List<Cocinero> traerCocineroPorIngreso(long idUnidadVenta, LocalDate fecha){
		 
		 return dao.traerCocineroPorIngreso(idUnidadVenta, fecha);
	 }
	
}
