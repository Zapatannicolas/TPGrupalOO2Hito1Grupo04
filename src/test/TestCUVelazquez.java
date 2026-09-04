package test;

import java.time.LocalDate;
import java.util.List;

import datos.Cocinero;
import datos.ItemPedido;
import negocio.PedidoABM;
import negocio.PersonaABM;

public class TestCUVelazquez {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PedidoABM pedidoABM = new PedidoABM();
		PersonaABM personaABM = new PersonaABM();
		
		try {	
			
			// Consulta
			// Traer los items del Pedido con sus platos.
			List<ItemPedido> items = pedidoABM.traerItemsPorPedido(2);

			System.out.println("\nÍtems del pedido: \n");
			for (ItemPedido item : items) {
			    System.out.println(
			        "Plato: " + item.getPlato().getNombre() +
			        " | Cantidad: " + item.getCantidad()
			    );
			}

			
			// Traer cocineros entre fechas teniendo en cuenta su ingreso.
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
