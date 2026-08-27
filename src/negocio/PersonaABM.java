package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PersonaDao;
import datos.Cajero;
import datos.Cocinero;
import datos.Persona;
import datos.UnidadVenta;

public class PersonaABM {
	PersonaDao dao = new PersonaDao();

	public Persona traer(long idPersona) {
		return dao.traer(idPersona);
	}

	public int agregar(Persona persona)throws Exception {
		if(validarDni(persona.getDni()) == true)throw new Exception("Esta persona ya existe");
		
		this.calcularSueldo(persona);
		
		return dao.agregar(persona);
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
		if(validarDni(persona.getDni()) == true)throw new Exception("Esta persona ya existe");
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
	
	public void agregarPersonal(UnidadVenta unidadVenta, long idPersonal) throws Exception{
		Persona persona = dao.traer(idPersonal);
		
		persona.setUnidadVenta(unidadVenta);
		
		dao.actualizar(persona);
	}
}
