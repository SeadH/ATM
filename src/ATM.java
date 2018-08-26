import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATM extends Racun {

	public static void main(String[] args) throws IOException {
		
		Scanner unos = new Scanner(System.in);
		int izbor = 0;
		ArrayList<Racun> racuni = new ArrayList<>();

		
		
		
		
		
		
		System.out.println("\n==============================\n\tWELCOME TO ATM\n==============================");
		while (izbor != 4) {
			System.out.println("Izaberite koju opciju želite: ");
			System.out.println("==============================\n"
					+ " 1. Kreirati Racun\n 2. Transakcija\n 3. Provjera stanja raèuna\n 4. Izlaz\n==============================\n");
			
			izbor = unos.nextInt();

			switch (izbor) {
			case 1:
				racuni.add(Racun.kreirajRacun(racuni, unos));
				break;
			case 2:
				//Transakcija.transakcija(racuni, unos);
				Racun.transakcija(racuni, unos);
				
				break;
			case 3:
				Racun.stanjeRacuna(racuni, unos);
				break;
			case 4:
				System.out.println("HVALA I DOVIÐENJA");
				break;
			default:
				System.out.println("\nPogrešan unos");
				break;
			}
		}
		
		
	}
	
		
		
		
	}


