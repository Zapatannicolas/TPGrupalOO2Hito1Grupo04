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

		Festival festival = new Festival(nombre, temporada, fechaInicio, fechaFin, costoSuperficie, costoMontaje, plusElectricidad, sueldoBase);

		return dao.agregar(festival);
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
	
	public Long cantidadFoodTrucks(long idFestival) {
	    return dao.cantidadFoodTrucks(idFestival);
	}

	
}