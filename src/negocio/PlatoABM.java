package negocio;

import java.util.List;
import dao.PlatoDao;
import datos.Plato;

	public class PlatoABM {
		PlatoDao dao = new PlatoDao();

		public Plato traer(int idPlato) {
			return dao.traer(idPlato);
		}

		public int agregar(Plato plato)throws Exception {
				return dao.agregar(plato);
		}

		public void modificar(Plato plato) throws Exception {
				dao.actualizar(plato);
		}

		public void eliminar(int idPlato) throws Exception {
			Plato p = dao.traer(idPlato);
				if(p == null)throw new Exception("Este plato no existe");
					dao.eliminar(p);
			}

		public List<Plato> traer() {
			return dao.traer();
		}
	}	