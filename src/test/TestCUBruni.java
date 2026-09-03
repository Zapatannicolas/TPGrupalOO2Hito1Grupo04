package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.Cocinero;
import negocio.UnidadVentaAbm;

public class TestCUBruni {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaAbm unidadVentaABM = new UnidadVentaAbm();
		
		List<Cocinero> cocinero = new ArrayList<>();

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
	}

}
