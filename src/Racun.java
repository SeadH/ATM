import java.util.Scanner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.*;

public class Racun {

	private String ime;
	private int broj;
	private double stanje;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;

	}

	public double getStanje() {
		return stanje;
	}

	public void setStanje(double stanje) {
		this.stanje = stanje;
	}

	static Scanner unos = new Scanner(System.in);
	static ArrayList<Racun> racuni = new ArrayList<>();

	public static Racun kreirajRacun(ArrayList<Racun>racuni, Scanner unos) throws IOException {

		File file = new File("Accounts");
		file.mkdir();
		file.createNewFile();
		
		Racun racun = new Racun();

		System.out.print("Ime: ");
		racun.setIme(unos.next());
		
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(racun.getIme() +".txt"))){
		
		bw.write("Ime:"+racun.getIme()+" ~ ");
		
		
		
		try{
		System.out.print("Broj racuna: ");
		racun.setBroj(unos.nextInt());
		while(provjeraBroj(racuni, racun.broj) || racun.broj<0){
			System.out.println("Neispravan broj raèuna. Molimo vas unesite ponovo: ");
			racun.setBroj(unos.nextInt());
	
		}
	
		}catch(Exception e){
			System.out.println("Decimalni broj nije dozvoljen: "+e);
			System.out.println("SHUT DOWN!");
			System.exit(1);
		
		}
			
		
		
		
		
		
		bw.write("ID:"+racun.getBroj()+" ~ ");

		
		
		System.out.println("Unesite iznos koji uplaæujete na svoj racun: ");
		racun.setStanje(unos.nextDouble());
		
		while(racun.getStanje()<0){
			System.out.println("Iznos je negativan!\nUnesite iznos koji uplaæujete na svoj raèun: ");
			racun.setStanje(unos.nextDouble());
		
		}
		
		
		bw.write("Stanje na raèunu: "+racun.getStanje() + " KM");
		
		racuni.add(racun);
		
		
	FileOutputStream fos = new FileOutputStream("Racuni.txt");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
				
	oos.writeObject(racuni);
				
	oos.close(); 
		
	
		
		}
		
			
		catch(Exception e){
			e.getMessage();
		}
		finally{
			System.out.println("Korisnik je kreiran.");
		}
		
		
		
		return racun;

	}

	public static boolean provjeraBroj(ArrayList<Racun> racuni, int broj) {
		for (Racun r : racuni) {
			if (r.getBroj() == broj) {
				return true;
			}
		}

		return false;
	}
	
	public static void stanjeRacuna(ArrayList<Racun>racuni, Scanner unos){
		int broj;
		System.out.println("Unesite vaš broj raèuna: ");
		broj=unos.nextInt();
		boolean provjera = true;
		Racun source = new Racun();
		while(provjera)
		{
			for(int i = 0; i<racuni.size();i++)
			{
				if(broj==racuni.get(i).getBroj())
				{
					source=racuni.get(i);
					provjera = false;
					break;
					
				}
			}
			if(provjera){
				System.out.println("Unijeli ste neispravan broj raèuna!\nMolimo vas unesite ponovo: ");
				broj=unos.nextInt();
				
			}
		}
		
		System.out.println("=======================================\nStanje racuna\n================");
		System.out.println("Ime: "+source.ime+"\nStanje racuna: "+source.getStanje()+" KM\n=======================================");
		}	

public static void transakcija(ArrayList<Racun>racuni, Scanner unos) throws IOException{
		
	
	
	int sourceNo;
	int targetNo;
	double iznos;
	boolean provjera = true;
	
	Racun source = new Racun();
	Racun target = new Racun();
	
	Racun racun = new Racun();
		
		System.out.println("Unesite vaš broj raèuna: ");
		sourceNo=unos.nextInt();
		
		while(provjera)
		{
			for(int i=0; i<racuni.size();i++)
			{
				if(sourceNo==racuni.get(i).getBroj())
				{
					source=racuni.get(i);
					provjera=false;
					break;
					
				}
			}
			if(provjera){
				System.out.println("Unijeli ste nepostojeæi broj raèuna!\nMolimo vas unesite ponovo: ");
				sourceNo=unos.nextInt();
			}
		}
		
		provjera = true;
	System.out.println("Unesite broj raèuna na koji prebacujete novac: ");
	targetNo=unos.nextInt();
	
	while(provjera){
		for(int i = 0; i<racuni.size();i++)
		{
			if(targetNo==racuni.get(i).getBroj())
			{
				target=racuni.get(i);
				provjera=false;
				break;
				
			}
		}
		if(provjera){
			System.out.println("Unijeli ste nepostojeæi broj raèuna!\nMolimo vas unesite ponovo: ");
			targetNo=unos.nextInt();
		}
	}
		
	System.out.println("Unesite iznos novca koji prebacujete: ");
	iznos=unos.nextDouble();
	
	if(iznos < 0 || iznos > source.getStanje()){
		System.out.println("Transkacija onemoguæena. Unesite drugi iznos: ");
		iznos=unos.nextDouble();
	}
	try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(racun.getIme() +".txt"))){
//Files.newBufferedWriter(Paths.get(racun.getIme() +".txt"
	source.setStanje(source.getStanje()-iznos);
	target.setStanje(target.getStanje()+iznos);
	
	bw.write((int) source.getStanje());
	bw.write((int) target.getStanje());
	
	}	
	
	
	}
	
}
