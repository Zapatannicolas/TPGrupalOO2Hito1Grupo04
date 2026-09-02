package test;

import java.time.LocalDate;

import datos.Cajero;
import datos.Cocinero;
import datos.FoodTruck;
import datos.Persona;
import datos.PuestoDesarmable;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.PersonaABM;
import negocio.UnidadVentaAbm;

public class TestPersona {

	public static void main(String[] args) {
		PersonaABM abmPersona = new PersonaABM();

		try {
			abmPersona.agregarCajero(43389181, "Maximiliano", "Bruni", LocalDate.of(2001, 3, 30),
					LocalDate.of(2020, 5, 21), 850000f, LocalDate.of(2026, 8, 23), "Noche");
			abmPersona.agregarCajero(38967421, "Lucia", "Fernandez", LocalDate.of(1995, 11, 3),
					LocalDate.of(2023, 7, 20), 920000f, LocalDate.of(2026, 9, 1), "Mañana");
			abmPersona.agregarCajero(45123987, "Martin", "Rodriguez", LocalDate.of(2001, 2, 27),
					LocalDate.of(2025, 1, 15), 780000f, LocalDate.of(2026, 7, 30), "Noche");
			abmPersona.agregarCocinero(38742121, "Francisco", "Jordans", LocalDate.of(1999, 3, 11),
					LocalDate.of(2020, 5, 20), 920000f, LocalDate.of(2026, 8, 23), "Parrilla", 200000);
			abmPersona.agregarCocinero(43215678, "Juan", "Gomez", LocalDate.of(1998, 5, 12),
					LocalDate.of(2024, 3, 10), 850000f, LocalDate.of(2026, 8, 15),	"Cocina", 150000);
			abmPersona.agregarCocinero(36784512, "Sofia", "Martinez", LocalDate.of(1992, 8, 19),
					LocalDate.of(2022, 5, 2), 1100000f, LocalDate.of(2026, 6, 18), "Reposteria", 250000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			abmPersona.agregarCocinero(38742121, "Francisco", "Jordans", LocalDate.of(1999, 3, 11),
					LocalDate.of(2020, 5, 20), 920000f, LocalDate.of(2026, 8, 23), "Parrilla", 200000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(abmPersona.traerPersonaYUnidadDeVenta(4));

	}

}