package negocio;
	
import java.time.LocalDate;
import java.util.List;

import dao.PedidoDao;
import dao.ItemPedidoDao;

import datos.ItemPedido;
import datos.Pedido;
import datos.Plato;
import datos.UnidadVenta;

public class PedidoABM {
	
	PedidoDao dao = new PedidoDao();
	ItemPedidoDao itemDao = new ItemPedidoDao();

	public Pedido traer(int idPedido) {
		return dao.traer(idPedido);
	}

	
	public int agregarPedido(LocalDate fecha, UnidadVenta unidadVenta) throws Exception {

	    if (unidadVenta == null) {
	        throw new Exception("La unidad de venta no existe");
	    }

	    Pedido pedido = new Pedido(fecha, unidadVenta);

	    return dao.agregar(pedido);
	}

	
	public void modificar(Pedido pedido) throws Exception {
		
	    if (pedido == null) {
	        throw new Exception("El pedido no existe");
	    }

	    if (dao.traer(pedido.getIdPedido()) == null) {
	        throw new Exception("El pedido no existe");
	    }

	    if (pedido.getUnidadVenta() == null) {
	        throw new Exception("La unidad de venta no existe");
	    }
		
		dao.actualizar(pedido);
	}
	

	public void eliminar(int idPedido) throws Exception {
		Pedido p = dao.traer(idPedido);
		
			if(p == null)throw new Exception("Este pedido no existe");
				dao.eliminar(p);
		}

	
	public List<Pedido> traer() {
		return dao.traer();
	}
	
	
	// Métodos itemPedido
	public void agregarItem(Pedido pedido, Plato plato, int cantidad) throws Exception {

	    if (pedido == null) {
	        throw new Exception("El pedido no existe");
	    }

	    if (plato == null) {
	        throw new Exception("El plato no existe");
	    }

	    if (cantidad <= 0) {
	        throw new Exception("La cantidad debe ser mayor a 0");
	    }

	    ItemPedido item = new ItemPedido(plato, cantidad, pedido);

	    itemDao.agregar(item);
	}
    
	
    public void modificarItem(ItemPedido item) throws Exception {
    	
        if (item == null) {
            throw new Exception("El item no existe");
        }
    	
        itemDao.actualizar(item);
    }
    
    public void eliminarItem(ItemPedido item) throws Exception {
    	
        if (item == null) {
            throw new Exception("El item no existe");
        }
    	
    	itemDao.eliminar(item);
    }
    
    
    // Consulta HQL
    public List<ItemPedido> traerItemsPorPedido(int idPedido) throws Exception {

        if (dao.traer(idPedido) == null) {
            throw new Exception("El pedido no existe");
        }
        return dao.traerItemsPorPedido(idPedido);
    }
}
