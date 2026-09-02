package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FestivalDao;
import datos.Festival;

public class FestivalABM {

	FestivalDao dao = new FestivalDao();

	public Festival traer(long id) {
		return dao.traer(id);
	}

	public Festival traer(String nombre) {
		return dao.traer(nombre);
	}

	public int agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
			double costoSuperficie, double costoMontaje, double plusElectricidad, double sueldoBase) {

		Festival f = new Festival();

		f.setNombre(nombre);
		f.setTemporada(temporada);
		f.setFechaInicio(fechaInicio);
		f.setFechaFin(fechaFin);
		f.setCostoSuperficie(costoSuperficie);
		f.setCostoMontaje(costoMontaje);
		f.setPlusElectricidad(plusElectricidad);
		f.setSueldoBase(sueldoBase);

		return dao.agregar(f);
	}

	public void modificar(Festival f) {
		dao.actualizar(f);
	}

	public void eliminar(long id) {
		Festival f = dao.traer(id);
		dao.eliminar(f);
	}

	public List<Festival> traer() {
		return dao.traer();
	}

	public Festival traerFestivalYUnidades(long id) {
		return dao.traerFestivalYUnidades(id);
	}

	
}