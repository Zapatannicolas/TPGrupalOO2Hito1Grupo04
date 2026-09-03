package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.Cajero;
import datos.Cocinero;
import datos.Festival;
import datos.ItemPedido;
import negocio.FestivalABM;
import negocio.PedidoABM;
import negocio.PersonaABM;
import negocio.UnidadVentaAbm;

public class TestCU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaAbm unidadVentaABM = new UnidadVentaAbm();
		
		List<Cocinero> cocinero = new ArrayList<>();

		List<Cajero> cajero = new ArrayList<>();
		FestivalABM festivalABM = new FestivalABM();
		
		try {	
		
			//Nacho CU
			//Trae listas de cajeros filtrados cuyo sueldo sea mayor al sueldo base ingresado por parametro
			cajero = unidadVentaABM.traerCajerosPorSueldo(1,500000);
			
			System.out.println("\nCU NACHO: ");
			
			for(Cajero c: cajero) {
				
				System.out.println("------------------------------------------");
	            System.out.println("ID Persona : " + c.getIdPersona());
	            System.out.println("Nombre     : " + c.getNombre() + " " + c.getApellido());
	            System.out.println("DNI        : " + c.getDni());
	            System.out.println("Sueldo        : " + c.getSueldoBase());
			}
			
			System.out.println("\nCU MAXIMILIANO: ");
			
			//Maxi CU
			//Trae una lista de cocineros filtrados por el ingreso solicitado por parametro
			cocinero = unidadVentaABM.traerCocineroPorIngreso(2,LocalDate.of(2020, 1, 1));
			
			for(Cocinero c: cocinero) {
			
				System.out.println("------------------------------------------");
	            System.out.println("ID Persona : " + c.getIdPersona());
	            System.out.println("Nombre     : " + c.getNombre() + " " + c.getApellido());
	            System.out.println("DNI        : " + c.getDni());
	            System.out.println("Ingreso        : " + c.getFechaIngreso());
			}
			
			
			// Nico CU
			// Trae cantidad de Foodtrucks que tiene un Festival
			Festival festival = festivalABM.traer(1L);
			System.out.println("\nCU NICOLAS: ");
			System.out.println("------------------------------------------");
			System.out.println("Food Trucks: " + festivalABM.cantidadFoodTrucks(1L));
			System.out.println("Festival: " + festival.getNombre());
			
			
			
			// Rodri  CU
			//Traer los items del Pedido con sus platos.
			System.out.println("\nCU RODRIGO: ");
			
			PedidoABM pedidoABM = new PedidoABM();
			List<ItemPedido> items = pedidoABM.traerItemsPorPedido(2);
			
			System.out.println("\nÍtems del pedido: \n");
			for (ItemPedido item : items) {
			    System.out.println(
			        "Plato: " + item.getPlato().getNombre() +
			        " | Cantidad: " + item.getCantidad()
			    );
			}
			
			
			// Rodri CU
			// Traer cocineros entre fechas teniendo en cuenta su ingreso.
			PersonaABM personaABM = new PersonaABM();
			LocalDate desde = LocalDate.of(2020, 1, 1);
			LocalDate hasta = LocalDate.of(2022, 12, 31);
			List<Cocinero> cocineros = personaABM.traerCocinerosEntreFechas(desde, hasta);
	
			System.out.println("\nCocineros ingresados entre " + desde + " y " + hasta + ":\n");
			for (Cocinero c : cocineros) {
			    System.out.println(
			        "- " + c.getNombre() + " " + c.getApellido() +
			        " | Ingreso: " + c.getFechaIngreso() +
			        " | Especialidad: " + c.getEspecialidad()
			    );
			} 

		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
	}

}
