package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PersonaDao;
import datos.Cajero;
import datos.Cocinero;
import datos.Persona;

public class PersonaABM {
	PersonaDao dao = new PersonaDao();

	public Persona traer(long idPersona) {
		return dao.traer(idPersona);
	}

	public int agregarCajero(int dni, String nombre,  String apellido,  LocalDate fechaNacimiento, 
			LocalDate fechaIngreso, float sueldoBase, LocalDate fechaEgreso, String turno)throws Exception {
		if(validarDni(dni) == true)throw new Exception("Esta persona ya existe");
		
		Persona cajero = new Cajero(dni, nombre, apellido, fechaNacimiento, fechaIngreso, sueldoBase, 
				fechaEgreso, turno);
		
		this.calcularSueldo(cajero);
		
		return dao.agregar(cajero);
	}
	
	public int agregarCocinero(int dni, String nombre,  String apellido,  LocalDate fechaNacimiento, 
			LocalDate fechaIngreso, float sueldoBase, LocalDate fechaEgreso, String especialidad, int plusCategoria)throws Exception {
		if(validarDni(dni) == true)throw new Exception("Esta persona ya existe");
		
		Persona cocinero = new Cocinero(dni, nombre, apellido, fechaNacimiento, fechaIngreso, sueldoBase, 
				fechaEgreso, especialidad, plusCategoria);
		
		this.calcularSueldo(cocinero);
		
		return dao.agregar(cocinero);
	}
	
	private boolean validarDni(int dni) {
		int contador = 0;
		boolean resultado = false;
		List<Persona> listaPersonas = dao.traer();
		
		while(contador < listaPersonas.size() && resultado == false) {
			if(dni == listaPersonas.get(contador).getDni()) {
				resultado = true;
			}
			contador++;
		}
		return resultado;
	}

	public void modificar(Persona persona) throws Exception {
		dao.actualizar(persona);
	}

	public void eliminar(long idPersona) throws Exception {
		Persona p = dao.traer(idPersona);
		if(dao.traer(idPersona) == null)throw new Exception("Esta persona no existe");
		dao.eliminar(p);
	}

	public List<Persona> traer() {
		return dao.traer();
	}
	
	public Persona traerPersonaYUnidadDeVenta(long idPersona) {
		return dao.traerPersonaYUnidadDeVenta(idPersona);
	}
	
	private void calcularSueldo(Persona objeto) {
		
		if(objeto instanceof Cajero) {
			objeto.setSueldoBase(objeto.getSueldoBase() + (calcularAntiguedad(objeto)*5000));
		}else {
			Cocinero cocinero = (Cocinero) objeto;
			objeto.setSueldoBase(objeto.getSueldoBase() + cocinero.getPlusCategoria());  
		}
	}
	
	
	
	private float calcularAntiguedad(Persona objeto) {
		
		long diasIngreso = objeto.getFechaIngreso().toEpochDay();
        long diasActual = LocalDate.now().toEpochDay();

        return (diasActual - diasIngreso) / 365;
	}

	
	// Consulta HQL
	// Traer Cocineros entre fechas teniendo en cuenta el ingreso.
	public List<Cocinero> traerCocinerosEntreFechas(LocalDate desde, LocalDate hasta) {
	    return dao.traerCocinerosEntreFechas(desde, hasta);
	}
}
