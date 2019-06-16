package Kantine;

/**
 * Deze klasse zorgt voor de creatie en werking van een datum.
 * @author Albert Witwerts
 * @author Gerwin Terpstra
 * @version 1.1
 */
public class KantineMedewerker extends Persoon {
	private int medewerkersNummer;
	private boolean magAchterKassa;
	
	// Constructor voor de klasse KantineMedewerker zonder parameters
	public KantineMedewerker() {
		super();
	}
	
	/**
	 * Constructor van de klasse KantineMedewerker die een kantine medewerker aanmaakt met nummer en bepaald
	 * of deze achter de kassa mag
	 * @param medewerkersNummer in int
	 * @param magAchterKassa in boolean
	 */
	public KantineMedewerker(int medewerkersNummer, boolean magAchterKassa) {
		super();
		
		this.medewerkersNummer = medewerkersNummer;
		this.magAchterKassa = magAchterKassa;
	}
	
	/**
	 * Constructor voor de klasse KantineMedewerker die een kantine medewerker aanmaakt met veel informatie
	 * @param bsn
	 * @param voornaam
	 * @param achternaam
	 * @param geboortedatum
	 * @param geslacht
	 * @param medewerkersNummer
	 * @param magAchterKassa
	 */
	public KantineMedewerker(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int medewerkersNummer, boolean magAchterKassa) {
		super(bsn, voornaam, achternaam, geboortedatum, geslacht);
		
		this.medewerkersNummer = medewerkersNummer;
		this.magAchterKassa = magAchterKassa;
	}

	/**
	 * Deze methode geeft het nummer van de medewerker terug
	 * @return medewerkersNummer in int
	 */
	public int getMedewerkersNummer() {
		return medewerkersNummer;
	}

	/**
	 * Deze methode past het nummer van de medewerker aan
	 * @param medewerkersNummer in int
	 */
	public void setMedewerkersNummer(int medewerkersNummer) {
		this.medewerkersNummer = medewerkersNummer;
	}

	/**
	 * Deze methode geeft terug of de medewerker achter de kassa mag
	 * @return magAchterKassa in boolean
	 */
	public boolean isMagAchterKassa() {
		return magAchterKassa;
	}

	/**
	 * Deze methode bepaald of de medewerker achter de kassa mag
	 * @param magAchterKassa in boolean
	 */
	public void setMagAchterKassa(boolean magAchterKassa) {
		this.magAchterKassa = magAchterKassa;
	}

	/**
	 * Deze methode geeft alle informatie van de medewerker terug
	 * @return kantineMedewerker in String
	 */
	public String toString() {
		return "Kantine Medewerker";
	}
}
