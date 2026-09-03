package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.Cajero;
import datos.Cocinero;
import datos.Persona;
import negocio.PersonaABM;
import negocio.UnidadVentaAbm;

public class TestCU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaAbm unidadVentaABM = new UnidadVentaAbm();
		
		List<Cocinero> cocinero = new ArrayList<>();

		List<Cajero> cajero = new ArrayList<>();
		
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
	}

}
