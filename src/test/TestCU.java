package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.Cajero;
import datos.Cocinero;
import datos.Festival;
import datos.Persona;
import negocio.FestivalABM;
import negocio.PersonaABM;
import negocio.UnidadVentaAbm;

public class TestCU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaAbm unidadVentaABM = new UnidadVentaAbm();
		
		List<Cocinero> cocinero = new ArrayList<>();

		List<Cajero> cajero = new ArrayList<>();
		FestivalABM festivalABM = new FestivalABM();
		
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

		
	}

}
