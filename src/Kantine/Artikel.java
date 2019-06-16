package Kantine;

/**
 * Deze klasse zorgt voor de creatie en werking van een artikel.
 * @author Albert Witwerts
 * @author Gerwin Terpstra
 * @version 1.1
 */
public class Artikel {
	private String naam;
	private Double prijs;
	
	/** 
	 * Constructor
     * 
     * Hier wordt een volledig nieuwe artikel aangemaakt, dus het heeft nog geen naam en prijs.
	 */	
	public Artikel() {
		this.naam = "";
		this.prijs = 0.00;
	}
	
	/**
     * Constructor
     * 
     * Hier wordt een nieuwe artikel aangemaakt met naam en prijs
     * 
     * @param naam, prijs
     */
	
	public Artikel(String naam, Double prijs) {
		this.naam = naam;
		this.prijs = prijs;
	}

	/**
     * Methode om de naam van het artikel op te vragen
     *
     * @return Naam van het artikel
     */
	
	public String getNaam() {
		return naam;
	}

	/**
     * Methode om de naam van het artikel aan te kunnen passen.
     *
     * @param Naam
     */
	
	public void setNaam(String naam) {
		this.naam = naam;
	}

	/**
     * Methode om de prijs van het artikel op te vragen
     *
     * @return Prijs van het artikel
     */
	
	public Double getPrijs() {
		return prijs;
	}

	/**
     * Methode om de prijs van het artikel aan te kunnen passen
     *
     * @param (Nieuwe) prijs van het artikel
     */
	
	public void setPrijs(Double prijs) {
		this.prijs = prijs;
	}
	
	/**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Alle informatie (naam & prijs) van het artikel in een String
     */
	
	public String toString() {
		return "Naam: " + this.getNaam() + " Prijs: " + this.getPrijs();
	}
}
