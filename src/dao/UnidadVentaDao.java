package dao;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cajero;
import datos.Cocinero;
import datos.Pedido;
import datos.Persona;
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
    
    public UnidadVenta traerUnidadVentaYStaff(long idUnidadVenta) throws HibernateException {
        UnidadVenta objeto = null;
        try {
            iniciaOperacion();            
            String hql = "from UnidadVenta u where u.idUnidadVenta=:idUnidadVenta";            
            objeto=(UnidadVenta) session.createQuery(hql).setParameter("idUnidadVenta", idUnidadVenta).uniqueResult();
            Hibernate.initialize(objeto.getStaff());
        }
 		finally {
 			session.close();
        }
        return objeto;
    }
    
    public void agregarStaffAUnidadVenta(UnidadVenta unidadVenta, Persona persona) throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // 1. Asignamos la FK en la persona
            persona.setUnidadVenta(unidadVenta);
            session.update(persona);

            // 2. Traemos/Refrescamos la UnidadVenta en ESTA sesión
            UnidadVenta uvPersistent = (UnidadVenta) session.get(UnidadVenta.class, unidadVenta.getIdUnidadVenta());
            
            // 3. Inicializamos el proxy de la colección staff
            Hibernate.initialize(uvPersistent.getStaff());

            // 4. Ahora sí podemos agregar el elemento a la colección cargada
            uvPersistent.getStaff().add(persona);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public void agregarPedidosAUnidadVenta(UnidadVenta unidadVenta, Pedido pedido) throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // 1. Asignamos la FK en la persona
            pedido.setUnidadVenta(unidadVenta);
            session.update(pedido);

            // 2. Traemos/Refrescamos la UnidadVenta en ESTA sesión
            UnidadVenta uvPersistent = (UnidadVenta) session.get(UnidadVenta.class, unidadVenta.getIdUnidadVenta());
            
            // 3. Inicializamos el proxy de la colección staff
            Hibernate.initialize(uvPersistent.getPedidos());

            // 4. Ahora sí podemos agregar el elemento a la colección cargada
            uvPersistent.getPedidos().add(pedido);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    
    public List<Cajero> traerCajerosPorSueldo(long idUnidadVenta, float sueldo) throws HibernateException {

        List<Cajero> lista = null;

        try {

            iniciaOperacion();

            String hql = "from Cajero c "
                    + "where c.unidadVenta.idUnidadVenta = :idUnidadVenta "
                    + "and c.sueldoBase > :sueldo";

            lista = session.createQuery(hql, Cajero.class)
                    .setParameter("idUnidadVenta", idUnidadVenta)
                    .setParameter("sueldo", sueldo)
                    .list();

        } finally
        
        {

            session.close();

        }
        return lista;
    }
    
        
        public List<Cocinero> traerCocineroPorIngreso(long idUnidadVenta, LocalDate fecha)
                throws HibernateException {

            List<Cocinero> lista = null;

            try {

                iniciaOperacion();

                String hql = "from Cocinero c "
                        + "where c.unidadVenta.idUnidadVenta = :idUnidadVenta "
                        + "and c.fechaIngreso > :fecha";

                lista = session.createQuery(hql, Cocinero.class)
                        .setParameter("idUnidadVenta", idUnidadVenta)
                        .setParameter("fecha", fecha)
                        .list();

            } finally {

                session.close();

            }

        return lista;
    }
    
}
