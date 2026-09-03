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

public class TestCUZapata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FestivalABM festivalABM = new FestivalABM();
		try {
		// Nico CU
		// Trae cantidad de Foodtrucks que tiene un Festival
			Festival festival = festivalABM.traer(1L);
			System.out.println("\nCU NICOLAS: ");
			System.out.println("------------------------------------------");
			System.out.println("Food Trucks: " + festivalABM.cantidadFoodTrucks(1L));
			System.out.println("Festival: " + festival.getNombre());
		}catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}

	}

}
