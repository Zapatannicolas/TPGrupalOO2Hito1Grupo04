package negocio;
import java.time.LocalDate;
import java.util.List;

import dao.UnidadVentaDao;
import datos.UnidadVenta;
import datos.FoodTruck;
import datos.Persona;
import datos.PuestoDesarmable;

public class UnidadVentaAbm {
	
	UnidadVentaDao dao = new UnidadVentaDao();

	public int agregar(UnidadVenta objeto) throws Exception{
		if(traer(objeto.getIdUnidadVenta())!= null) throw new Exception("Ya existe una unidad de venta con el mismo codigo");
	    return dao.agregar(objeto);
	}
	
	public UnidadVenta traer(long idUnidadVenta) {
		return dao.traer(idUnidadVenta);
	}

	public List<UnidadVenta> traer() {
		return dao.traer();
	}
	
	public UnidadVenta traerUnidadVentaYPedidos(long idUnidadVenta) {
		return dao.traer(idUnidadVenta);
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
	
	
}

