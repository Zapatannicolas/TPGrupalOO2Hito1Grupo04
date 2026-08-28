package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.UnidadVenta;

public class UnidadVentaDao{
	
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
	
/*  LE HACEMOS EL NORMAL O PATRON SINGLETON??¿¿*/

	public int agregar(UnidadVenta objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(UnidadVenta objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(UnidadVenta objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public UnidadVenta traer(long idUnidadVenta) {
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			objeto = (UnidadVenta) session.get(UnidadVenta.class, idUnidadVenta);
		} finally {
			session.close();
		}
		return objeto;
	}

	public UnidadVenta traer(String codigoUnico) {
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			objeto = (UnidadVenta) session.createQuery("from UnidadVenta u where u.codigoUnico=:codigoUnico")
						.setParameter("codigoUnico", codigoUnico).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	public List<UnidadVenta> traer() throws HibernateException {
		List<UnidadVenta> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from UnidadVenta u order by u.idUnidadVenta asc", UnidadVenta.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	 
    public UnidadVenta traerUnidadVentaYPedidos(long idUnidadVenta) throws HibernateException {
        UnidadVenta objeto = null;
        try {
            iniciaOperacion();            
            String hql = "from UnidadVenta u where u.idUnidadVenta=:idUnidadVenta";            
            objeto=(UnidadVenta) session.createQuery(hql).setParameter("idUnidadVenta", idUnidadVenta).uniqueResult();
            Hibernate.initialize(objeto.getPedidos());
        }
 		finally {
 			session.close();
        }
        return objeto;
    }
    
}