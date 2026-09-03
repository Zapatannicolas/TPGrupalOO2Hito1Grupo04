package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;

public class FestivalDao {

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

	public int agregar(Festival objeto) {
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

	public void actualizar(Festival objeto) {
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

	public void eliminar(Festival objeto) {
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

	public Festival traer(long idFestival) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			objeto = (Festival) session.get(Festival.class, idFestival);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Festival traer(String nombre) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			objeto = (Festival) session.createQuery("from Festival f where f.nombre=:nombre")
					.setParameter("nombre", nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Festival> traer() throws HibernateException {
		List<Festival> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Festival f order by f.nombre asc", Festival.class).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public Festival traerFestivalYUnidades(long idFestival) throws HibernateException {
		Festival objeto = null;
		try {
			iniciaOperacion();

			String hql = "from Festival f where f.id=:idFestival";

			objeto = (Festival) session.createQuery(hql).setParameter("idFestival", idFestival).uniqueResult();

			Hibernate.initialize(objeto.getUnidadesVenta());

		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Long cantidadFoodTrucks(long idFestival) {
	    try {
	        iniciaOperacion();

	        String hql = "select count(u) "
	                   + "from Festival f "
	                   + "join f.unidadesVenta u "
	                   + "where f.id = :idFestival "
	                   + "and type(u) = FoodTruck";

	        return (Long) session.createQuery(hql)
	                .setParameter("idFestival", idFestival)
	                .uniqueResult();

	    } finally {
	        session.close();
	    }
	}
	
}