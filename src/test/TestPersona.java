package test;

import java.time.LocalDate;

import datos.Cajero;
import datos.Cocinero;
import datos.Persona;
import negocio.PersonaABM;

public class TestPersona {

	public static void main(String[] args) {
		PersonaABM abm = new PersonaABM();
		
		
		
		try {
			Persona cajero = new Cajero("Noche",43389181, "Maximiliano", "Bruni", LocalDate.of(2001, 3, 30), LocalDate.of(2020, 5, 21), 1500000f, LocalDate.of(2026, 8, 23));
			Persona cocinero = new Cocinero("Panchos", 1000 ,38742121, "Francisco", "Jordans", LocalDate.of(1999, 3, 11), LocalDate.of(2020, 5, 20), 1500000f, LocalDate.of(2026, 8, 23));
			abm.agregar(cajero);
			abm.agregar(cocinero);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
	}

}
