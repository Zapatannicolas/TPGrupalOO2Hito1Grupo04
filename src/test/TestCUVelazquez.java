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

public class TestCUVelazquez {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {			
						
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
