package test;

import java.time.LocalDate;

import datos.Cajero;
import datos.Festival;
import datos.Pedido;
import datos.Persona;
import datos.Plato;
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
		
		abmFestival.agregar("Cosquin Rock", "Primavera",LocalDate.of(2026, 8, 26), LocalDate.of(2026, 8, 27));
		try {
			Persona cajero = new Cajero("Noche",43389181, "Maximiliano", "Bruni", LocalDate.of(2001, 3, 30), LocalDate.of(2020, 5, 21), 1500000f, LocalDate.of(2026, 8, 23), abmFestival.traer(1));
			abmPersona.agregar(cajero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			abmUnidadVenta.agregarFoodTruck("dasd", 1.12, "sadasd", abmPersona.traer(1), "jeje", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			abmPersona.agregarPersonal(abmUnidadVenta.traer(1), 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Pedido pedido1 = new Pedido(LocalDate.of(2024, 2, 12), abmUnidadVenta.traer(1), abmFestival.traer(1));
		
		try {
			abmPedido.agregar(pedido1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Plato plato1 = new Plato("panchoo", 20.00f, 12.000f);
		
		try {
			abmPlato.agregar(plato1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
