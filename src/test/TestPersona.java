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
		UnidadVentaAbm abmUnidadVenta = new UnidadVentaAbm();

		/*
		 * try { abmPersona.agregarCajero(43389181, "Maximiliano", "Bruni",
		 * LocalDate.of(2001, 3, 30), LocalDate.of(2020, 5, 21), 1500000f,
		 * LocalDate.of(2026, 8, 23), "Noche"); abmPersona.agregarCocinero(38742121,
		 * "Francisco", "Jordans", LocalDate.of(1999, 3, 11), LocalDate.of(2020, 5, 20),
		 * 1500000f, LocalDate.of(2026, 8, 23), "Panchos", 1000); } catch (Exception e)
		 * { System.out.println("Excepcion: " + e.getMessage()); }
		 * 
		 * 
		 * 
		 * try { abmUnidadVenta .agregar(new FoodTruck("El Buen Sabor", 18.5,
		 * "FT-2026-047", abmPersona.traer(1), "AB123CD", true)); abmUnidadVenta
		 * .agregar(new PuestoDesarmable("La Hamburgueseria", 20.5, "FT-4821",
		 * abmPersona.traer(2), 6, 45)); } catch (Exception e) { // TODO Auto-/generated
		 * catch block e.printStackTrace(); }
		 */

		
		System.out.println(abmPersona.traerPersonaYUnidadDeVenta(1)); 
		
		
		
		//abmPersona.traer(1).setUnidadVenta(abmUnidadVenta.traer(1));
		
		//abmPersona.traer(1).setUnidadVenta(abmUnidadVenta.traer(2));
		
		
		//System.out.println(abmPersona.traer(1));
	}

}
