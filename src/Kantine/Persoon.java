package Kantine;

/**
 * Deze klasse zorgt voor de creatie van een persoon.
 * @author Albert Witwerts
 * @author Gerwin Terpstra
 * @version 1.1
 */
public class Persoon {
	private int bsn;
	private String voornaam;
	private String achternaam;
	private Datum geboortedatum;
	private char geslacht;
	
	/**
     * Constructor zonder parameters waarmee een nieuw persoon wordt aangemaakt
     * met alle instantievariabelen op 0 of null.
     */	
	public Persoon() {
		this.bsn = 0;
		this.voornaam = "";
		this.achternaam = "";
		this.geboortedatum = new Datum();
		this.geslacht = 0;
	}
	
	/**
     * Constructor met parameters waarmee een persoon wordt aangemaakt waarvan de gegevens bekend zijn.
     * @param bsn
     * @param voornaam 
     * @param achternaam 
     * @param geboortedatum
     * @param gesclaht
     */	
	public Persoon(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
		this.bsn = bsn;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;

		this.setGeslacht(geslacht);
	}
	
	/**
     * Deze methode is de getter van bsn
     * @return bsn
     */	
	public int getBsn() {
		return bsn;
	}
	
	/**
	 * Deze methode is de getter van voornaam.
	 * @return voornaam
	 */
	public String getVoornaam() {
		return voornaam;
	}
	
	/**
	 * Deze methode is de getter van achternaam.
	 * @return achternaam
	 */
	public String getAchternaam() {
		return achternaam;
	}
	/**
	 * Deze methode is de getter van  geboortedatum.
	 * @return geboortedatum
	 */
	public Datum getGeboortedatum() {
		return geboortedatum;
	}
	
	/**
	 * Deze methode controleert eerst of het gegeven geslacht geldig is en geeft dan het geslacht terug. 
	 * @return geslacht
	 */
	public String getGeslacht() {
		if(this.geslacht == 'm')
				return "Man";
		else if(this.geslacht == 'v')
			return "Vrouw";
		
		return "Onbekend";
	}

	/**
     * Deze methode is de setter van geslacht.
     * Eerst wordt er gekeken of het gegeven geslacht wel geldig is.
     * @param geslacht
     */	
	public void setGeslacht(char geslacht) {
		if(geslacht == 'm' || geslacht == 'v')
			this.geslacht = geslacht;
		else
			System.out.println("Error: Persoon kon niet geslacht worden!");
	}
	
	/**
     * Deze Methode geeft alle gegevens van het persoon terug in string.
     * @return string van alle gegevens.
     */	
	public String toString() {
		return "BSN: " + this.getBsn() + " Naam: " + this.getVoornaam() + " " + this.getAchternaam() + " Geboortedatum: " + this.getGeboortedatum() + " Geslacht: " + this.getGeslacht();
	}
}
