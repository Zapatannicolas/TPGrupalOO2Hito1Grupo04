package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.ItemPedido;
import datos.Pedido;

public class PedidoDao {

	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	
	public int agregar(Pedido objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}
	
	
	public void actualizar(Pedido objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}
	
	
	public void eliminar(Pedido objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}
	
	
	public Pedido traer(int idPedido) {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (Pedido) session.get(Pedido.class, idPedido);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	public List<Pedido> traer() {
		List<Pedido> lista = new ArrayList<Pedido>();
		try {
			iniciaOperacion();
			Query<Pedido> query = session.createQuery("from Pedido p order by p.fecha asc", Pedido.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
	
	
	// Consulta HQL
	// Traer lista items por pedido.
	public List<ItemPedido> traerItems(int idPedido) {
	    List<ItemPedido> lista = new ArrayList<ItemPedido>();
	    
	    try {
	        iniciaOperacion();

	        Query<ItemPedido> query = session.createQuery("from ItemPedido i " + "join fetch i.plato " + "where i.pedido.idPedido = :idPedido", ItemPedido.class);
	        query.setParameter("idPedido", idPedido);
	        lista = query.getResultList();

	    } finally {
	        session.close();
	    }
	    return lista;
	}
}
