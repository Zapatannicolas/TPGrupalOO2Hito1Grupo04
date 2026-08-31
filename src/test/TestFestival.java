package test;

import java.time.LocalDate;

import negocio.FestivalABM;

public class TestFestival {

	public static void main(String[] args) {
		FestivalABM abm = new FestivalABM();
		
		
		
		try {
			abm.agregar("Cosquin Rock", "Primavera", LocalDate.of(2026, 8, 26), LocalDate.of(2026, 8, 27), 500.0, 50.0, 5000.0, 30000.0);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
	}

}