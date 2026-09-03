package test;

import java.time.LocalDate;
import java.util.List;

import negocio.PedidoABM;
import negocio.PersonaABM;
import negocio.PlatoABM;
import negocio.FestivalABM;
import negocio.UnidadVentaAbm;

public class TestCargaDatos {

	public static void main(String[] args) {
		
		PedidoABM pedidoABM = new PedidoABM();
		FestivalABM festivalABM = new FestivalABM();
		PlatoABM platoABM = new PlatoABM();
		UnidadVentaAbm unidadVentaABM = new UnidadVentaAbm();
		PersonaABM personaABM = new PersonaABM();
		
		try {
			
			personaABM.agregarCajero(11111111,"Juan", "Perez", LocalDate.of(1990, 5, 10), LocalDate.of(2024, 1, 1), 500000, LocalDate.of(2024, 8, 5),"Noche");
			personaABM.agregarCajero(22222222, "Carlos", "Diaz", LocalDate.of(1992, 6, 15), LocalDate.of(2023, 3, 2), 1500000, LocalDate.of(2025, 7, 10), "Tarde");
			personaABM.agregarCajero(33333333, "Pepe", "Vance", LocalDate.of(1994, 7, 20), LocalDate.of(2022, 5, 3), 2500000, LocalDate.of(2026, 6, 15), "Mañana");
			personaABM.agregarCocinero(44444444, "Tito", "Vazquez", LocalDate.of(1996, 8, 25), LocalDate.of(2021, 7, 4), 3500000, LocalDate.of(2027, 5, 20), "Parilla", 400000);
			personaABM.agregarCocinero(55555555, "Roberto", "Gonzalez", LocalDate.of(1998, 5, 30), LocalDate.of(2020, 9, 5), 3500000, LocalDate.of(2028, 4, 30) ,"Pastas", 350000);
			
			festivalABM.agregar("Festival Uno", "Verano", LocalDate.of(2026, 7, 20), LocalDate.of(2026, 7, 30), 30000, 90000, 75000, 1500000);
			festivalABM.agregar("Festival Dos", "Invierno", LocalDate.of(2026, 7, 20), LocalDate.of(2026, 7, 30), 30000, 90000, 75000, 1500000);
			festivalABM.agregar("Festival Tres", "Otoño", LocalDate.of(2026, 7, 20), LocalDate.of(2026, 7, 30), 30000, 90000, 75000, 1500000);
			
			
			unidadVentaABM.agregarFoodTruck("Pollos", 2000, "1234", personaABM.traer(1), festivalABM.traer(1), "ABC123", true);
			unidadVentaABM.agregarFoodTruck("Carnes", 3000, "5678", personaABM.traer(2), festivalABM.traer(2), "DEF456", false);
			unidadVentaABM.agregarFoodTruck("Hamburguesas", 2500, "1111", personaABM.traer(4), festivalABM.traer(1), "FT001", true);
			unidadVentaABM.agregarFoodTruck("Pizzas", 3000, "1112", personaABM.traer(5), festivalABM.traer(1), "FT002", false);
			
			unidadVentaABM.agregarPuestoDesarmable("Refrigerios", 4000, "91011", personaABM.traer(3), festivalABM.traer(3), 2, 10);
			
			unidadVentaABM.agregarStaffAUnidadVenta(unidadVentaABM.traer(1), personaABM.traer(4));
			unidadVentaABM.agregarStaffAUnidadVenta(unidadVentaABM.traer(1), personaABM.traer(5));
			unidadVentaABM.agregarStaffAUnidadVenta(unidadVentaABM.traer(1), personaABM.traer(1));
			unidadVentaABM.agregarStaffAUnidadVenta(unidadVentaABM.traer(1), personaABM.traer(2));
			
			platoABM.agregarPlato("Hamburguesa", 15000, 14000, unidadVentaABM.traer(2));
			platoABM.agregarPlato("Pollo", 15000, 14000, unidadVentaABM.traer(1));
			
			pedidoABM.agregarPedido(LocalDate.of(2026, 8, 15), unidadVentaABM.traer(1));
			pedidoABM.agregarPedido(LocalDate.of(2026, 8, 20), unidadVentaABM.traer(2));
			pedidoABM.agregarPedido(LocalDate.of(2026, 8, 25), unidadVentaABM.traer(3));
			
			pedidoABM.agregarItem(pedidoABM.traer(1), platoABM.traer(1), 2);
			pedidoABM.agregarItem(pedidoABM.traer(2), platoABM.traer(2), 3);
			pedidoABM.agregarItem(pedidoABM.traer(3), platoABM.traer(1), 5);
			
		
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
	}

}
