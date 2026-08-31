package test;

import java.time.LocalDate;

import datos.Cajero;
import datos.Cocinero;
import datos.Festival;
import datos.FoodTruck;
import datos.Pedido;
import datos.Persona;
import datos.Plato;
import datos.PuestoDesarmable;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PersonaABM;
import negocio.PlatoABM;
import negocio.UnidadVentaAbm;

public class TestGeneral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FestivalABM abmFestival = new FestivalABM();
		PersonaABM abmPersona = new PersonaABM();
		PedidoABM abmPedido = new PedidoABM();
		PlatoABM abmPlato = new PlatoABM();
		UnidadVentaAbm abmUnidadVenta = new UnidadVentaAbm();
		
		abmFestival.agregar("Cosquin Rock", "Primavera", LocalDate.of(2026, 8, 26), LocalDate.of(2026, 8, 27), 500.0, 50.0, 5000.0, 30000.0);
		
		try {
			abmPersona.agregar(new Cajero("Noche",43389181, "Maximiliano", "Bruni", LocalDate.of(2001, 3, 30), 
					LocalDate.of(2020, 5, 21), 1500000f, LocalDate.of(2026, 8, 23), abmFestival.traer(1)));
			abmPersona.agregar(new Cocinero("Panchos", 1000 ,38742121, "Francisco", "Jordans", 
					LocalDate.of(1999, 3, 11), LocalDate.of(2020, 5, 20), 1500000f, LocalDate.of(2026, 8, 23), abmFestival.traer(1)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			abmUnidadVenta.agregar(new FoodTruck("El Buen Sabor", 18.5, "FT-2026-047", abmPersona.traer(1), "AB123CD", true));
			abmUnidadVenta.agregar(new PuestoDesarmable("La Hamburgueseria", 20.5, "FT-4821", abmPersona.traer(2), 6, 45));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			abmPersona.agregarPersonal(abmUnidadVenta.traer(1), 2);
			abmPersona.agregarPersonal(abmUnidadVenta.traer(2), 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			abmPedido.agregar(new Pedido(LocalDate.of(2024, 2, 12), abmUnidadVenta.traer(1), abmFestival.traer(1)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			abmPlato.agregar(new Plato("Hamburguesa Completa", 8500.0f, 3200.0f, abmUnidadVenta.traer(1)));
			abmPlato.agregar(new Plato("Pizza Especial", 12000.0f, 4500.0f, abmUnidadVenta.traer(2)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			abmPedido.agregarItem(abmPedido.traer(1), abmPlato.traer(1), 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
