package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número Quarto: ");
		int number = sc.nextInt();
		System.out.print("Data de entrada (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de Saída (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Reserva incorreta: Data de saída deve ser posterior a data de entrada");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
			
			System.out.println();
			System.out.println("Altere a data de reserva: ");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Saída (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			
			String erro = reservation.updateDates(checkIn, checkOut);
			if(erro != null) {
				System.out.println("Reserva incorreta: " + erro);
			} else {
				System.out.println("Reserva: " + reservation);
			}
		}
	}
}
