package Kantine;

import java.util.*;

/**
 * Deze klasse zorgt voor de creatie en werking van een dienblad.
 * @author Albert Witwerts
 * @author Gerwin Terpstra
 * @version 1.1
 */
public class Dienblad {
	private Stack<Artikel> artikelen;
	private Persoon klant;
	
	/**
     * Constructor zonder parameters waarmee een nieuw dienblad wordt aangemaakt met de instantievariabelen null.
     */	
	public Dienblad() {
		this.artikelen = new Stack<Artikel>();
		this.klant = null;
	}
	
	/**
     * Constructor met parameters waarmee een nieuw dienblad met een bekende klant aangemaakt wordt.
     * @param klant
     */
	
	public Dienblad(Persoon klant) {
		this.artikelen = new Stack<Artikel>();
		this.klant = klant;
	}
	
	/**
     * Methode om artikel aan dienblad toe te voegen     *
     * @param artikel
     */	
	public void voegToe(Artikel artikel) {
		if(artikel == null)
			return;
		
		this.artikelen.add(artikel);
	}
	
	/**
	 * Deze methode is de getter van artikelen.
	 * @return artikelen
	 */
	public Stack<Artikel> getArtikelen(){
		return this.artikelen;
	}
	
	/**
     * Methode om aantal artikelen op dienblad te tellen     *
     * @return Het aantal artikelen
     */	
	public int getAantalArtikelen() {
		return this.artikelen.size();
	}
	
	/**
     * Methode om de Klant van het dienblad op te vragen     *
     * @return klant
     */	
	public Persoon getKlant() {
		return this.klant;
	}
	
	/**
     * Methode om een nieuwe klant aan het dienblad te geven     *
     * @param klant
     */	
	public void setKlant(Persoon klant) {
		this.klant = klant;
	}	
}
