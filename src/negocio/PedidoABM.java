package negocio;
	
import java.util.List;
import dao.PedidoDao;
import datos.ItemPedido;
import datos.Pedido;
import datos.Plato;

public class PedidoABM {
	PedidoDao dao = new PedidoDao();

	public Pedido traer(int idPedido) {
		return dao.traer(idPedido);
	}

	public int agregar(Pedido Pedido)throws Exception {
		return dao.agregar(Pedido);
	}

	public void modificar(Pedido pedido) throws Exception {
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
        dao.agregarItem(pedido, plato, cantidad);
    }
    
    public void modificarItem(ItemPedido item) throws Exception {
        dao.actualizarItem(item);
    }
    
    public void eliminarItem(Pedido pedido, ItemPedido item) throws Exception {
        dao.eliminarItem(pedido, item);
    }
}
