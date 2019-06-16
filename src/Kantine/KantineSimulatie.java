package Kantine;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Deze klasse zorgt voor de simulatie van het project Kantine.
 * @author Albert Witwerts
 * @author Gerwin Terpstra
 * @version 1.1
 */
public class KantineSimulatie {
	// kantine
	private Kantine kantine;
	
	// kantineaanbod
	private KantineAanbod kantineaanbod;
	
	// adminstratie
	private Administratie administratie;
	
	// random generator
	private Random random;
	
	// aantal artikelen
	private static final int AANTAL_ARTIKELEN = 4;
	
	// aantal dagen
	public static final int DAGEN = 7;
	
	// artikelen
	private static final String[] artikelnamen = new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};
	
	//prijzen
	private static double[] artikelprijzen = new double[]{1.50, 2.10, 1.65, 1.65};
	
	// minimum en maximum aantal artikelen per soort
	private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
	private static final int MAX_ARTIKELEN_PER_SOORT = 20000;
	
	// minimum en maximum aantal personen per dag
	private static final int MIN_PERSONEN_PER_DAG = 50;
	private static final int MAX_PERSONEN_PER_DAG = 100;
	
	// minimum en maximum artikelen per persoon
	private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
	private static final int MAX_ARTIKELEN_PER_PERSOON = 4;
	
	//constructor
	public KantineSimulatie() {
		kantine = new Kantine();
		random = new Random();
		
		int[] hoeveelheden = getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
		kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);
		
		administratie = new Administratie();
		
		kantine.setKantineAanbod(kantineaanbod);
	}

	/**
	* Methode om een array van random getallen liggend tussen
	* min en max van de gegeven lengte te genereren	*
	* @param lengte
	* @param min
	* @param max
	* @return De array met random getallen
	*/	
	private int[] getRandomArray(int lengte, int min, int max) {
		int[] temp = new int[lengte];
	
		for(int i = 0; i < lengte ;i++) {
			temp[i] = getRandomValue(min, max);
		}
	
		return temp;
	}
	
	/**
	* Methode om een random getal tussen min(incl)
	* en max(incl) te genereren.	*
	* @param min
	* @param max
	* @return Een random getal
	*/	
	private int getRandomValue(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}
	
	/**
	* Methode om op basis van een array van indexen voor de array
	* artikelnamen de bijhorende array van artikelnamen te maken	*
	* @param indexen
	* @return De array met artikelnamen
	*/	
	private String[] geefArtikelNamen(int[] indexen) {
		String[] artikelen = new String[indexen.length];
	
		for(int i = 0; i < indexen.length; i++) {
			artikelen[i] = artikelnamen[indexen[i]];
		}
	
		return artikelen;
	}
	
	/**
	* Deze methode simuleert een aantal dagen
	* in het verloop van de kantine	
	* @param dagen
	*/
	
	public void Simuleer(int dagen) {
		Kassa kassa = this.kantine.getKassa();
		
		// bedenk hoeveel personen vandaag binnen lopen
		int aantalpersonen;
		
		double[] omzet;
		int[] aantal;
		
		if(dagen < 0)
			dagen = this.DAGEN;
		
		omzet = new double[dagen*MAX_PERSONEN_PER_DAG];
		aantal = new int[dagen];
		
		for(int i = 0; i < dagen; i++) {
			aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
			
			for(int j = 0; j < aantalpersonen; j++) {
				Persoon persoon;
				int rnd = this.getRandomValue(1, 100);
				
				//kans berekening
				if(rnd == 100) {
					persoon = new KantineMedewerker(j+1, "Voornaam", "Achternaam", new Datum(1, 1, 1970), 'm', 123, true, new Pinpas());
				}
				else if(rnd > 89) {
					persoon = new Docent(j+1, "Voornaam", "Achternaam", new Datum(1, 1, 1970), 'm', "ABCD", "ICT", new Contant());
				}
				else {
					persoon = new Student(j+1, "Voornaam", "Achternaam", new Datum(1, 1, 1970), 'm', 12345, "ICT", new Pinpas());
				}
				
				// print type persoon (Student, Docent of Kantine Medewerker)
				System.out.println("Klant " + (j+1) + ": " + persoon.toString());
				
				// maak persoon en dienblad aan, koppel ze
				// en bedenk hoeveel artikelen worden gepakt
				int aantalartikelen = this.getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
				Dienblad dienblad = new Dienblad(persoon);
				
				// genereer de "artikelnummers", dit zijn indexen
				// van de artikelnamen array
				int[] tepakken = getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN-1);
				
				// vind de artikelnamen op basis van
				// de indexen hierboven
				String[] artikelen = geefArtikelNamen(tepakken);
				
				// loop de kantine binnen, pak de gewenste
				// artikelen, sluit aan
				kantine.loopPakSluitAan(dienblad, artikelen);
				
				//omzet opslaan
				omzet[j*dagen+i] = kassa.getTotaalPrijs(dienblad);
			}
			
			// verwerk rij voor de kassa
			kantine.verwerkRijVoorKassa();
			
			// toon dagtotalen (artikelen en geld in kassa)
			System.out.println();
			System.out.println("## Dag " + (i + 1) + " ##");
			System.out.println("Aantal artikelen: " + kassa.aantalArtikelen());
			System.out.println("Geld in kassa: €" + (String.format("%.2f", kassa.hoeveelheidGeldInKassa())));
			System.out.println();
			
			//aantal opslaan
			aantal[i] = kassa.aantalArtikelen();
			
			// reset de kassa voor de volgende dag
			kassa.resetKassa();
		}
		
		System.out.println("Gemiddeld aantal gescande artikelen: " + (String.format("%.2f", this.administratie.berekenGemiddeldAantal(aantal))));
		System.out.println("Gemiddeld omzet: €" + (String.format("%.2f", this.administratie.berekenGemiddeldeOmzet(omzet))));
		
		double[] dOmzet = this.administratie.berekenDagOmzet(omzet);
		
		for(int i = 1; i <= dOmzet.length; i++) {
			System.out.println("Gemiddelde dagelijkse omzet #dag " + i + ": €" + (String.format("%.2f", dOmzet[i-1])));
		}
	}
	
	/*
	* Start een simulatie
	*/	
	public static void main(String[] args) {
		int dagen;
		
		if(args.length == 0) {
			dagen = DAGEN;
		} else {
			dagen = Integer.parseInt(args[0]);
		}
		
		new KantineSimulatie().Simuleer(dagen);
	}
}
