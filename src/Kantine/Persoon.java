package Kantine;

public class Persoon {
	private int bsn;
	private String voornaam;
	private String achternaam;
	private Datum geboortedatum;
	private char geslacht;
	
	/**
     * Constructor
     * 
     * Hier wordt een volledig nieuwe Persoon aangemaakt.
     */
	
	public Persoon() {
		this.bsn = 0;
		this.voornaam = "";
		this.achternaam = "";
		this.geboortedatum = new Datum();
		this.geslacht = 0;
	}
	
	/**
     * Constructor
     * 
     * Hier wordt een Persoon aangemaakt op basis van de gegeven parameters, waaronder bsn, voornaam, achternaam, geboortedatum en geslacht
     * 
     * @param bsn, voornaam, achternaam, 
     */
	
	public Persoon(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
		this.bsn = bsn;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;

		this.setGeslacht(geslacht);
	}
	
	/**
     * Methode om de bsn-nummer van de Persoon op te vragen
     *
     * @return bsn
     */
	
	public int getBsn() {
		return bsn;
	}
	
	/**
     * Methode om de bsn-nummer van de Persoon aan te kunnen passen
     *
     * @param bsn
     */
	
	public void setBsn(int bsn) {
		this.bsn = bsn;
	}

	/**
     * Methode om de voornaam van de Persoon op te vragen
     *
     * @return voornaam
     */
	
	public String getVoornaam() {
		return voornaam;
	}
	
	/**
     * Methode om de voornaam van de Persoon aan te kunnen passen
     *
     * @param voornaam
     */

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	/**
     * Methode om de achternaam van de Persoon op te kunnen vragen
     *
     * @return achternaam
     */
	
	public String getAchternaam() {
		return achternaam;
	}

	/**
     * Methode om de achternaam van de Persoon aan te kunnen passen
     *
     * @param achternaam
     */
	
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	/**
     * Methode om de geboortedatum van de Persoon op te vragen
     *
     * @return geboortedatum
     */
	
	public Datum getGeboortedatum() {
		return geboortedatum;
	}

	/**
     * Methode om de geboortedatum van de Persoon aan te kunnen passen
     *
     * @param geboortedatum
     */
	
	public void setGeboortedatum(Datum geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	/**
     * Hier kan de volledige naam van het geslacht van de Persoon opgevraagd worden.
     * Niet als 'm' of 'v', maar als 'Man' of 'Vrouw'
     * Wanneer er geen geslacht bekend is, zal er 'Onbekend' terug gestuurd worden.
     *
     * @return geslacht van de Persoon (String)
     */
	
	public String getGeslacht() {
		if(this.geslacht == 'm')
				return "Man";
		else if(this.geslacht == 'v')
			return "Vrouw";
		
		return "Onbekend";
	}

	/**
     * Methode om het geslacht van de Persoon aan de kunnen passen
     * Wanneer er geen (geldige) geslacht bekend is en dus aangepast kan worden, zal er een foutmelding in de log weergegeven worden.
     * 
     * @param geslacht (char)
     */
	
	public void setGeslacht(char geslacht) {
		if(geslacht == 'm' || geslacht == 'v')
			this.geslacht = geslacht;
		else
			System.out.println("Error: Persoon kon niet geslacht worden!");
	}
	
	/**
     * Methode om alle (bekende) gegevens van de Persoon als String te sturen.
     * Dit zodat het wellicht later gelogd kan worden.
     *
     * @return Alle gegevens van de Persoon (String)
     */
	
	public String toString() {
		return "BSN: " + this.getBsn() + " Naam: " + this.getVoornaam() + " " + this.getAchternaam() + " Geboortedatum: " + this.getGeboortedatum() + " Geslacht: " + this.getGeslacht();
	}
}
