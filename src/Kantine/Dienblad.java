package Kantine;

import java.util.*;

public class Dienblad {
	private Stack<Artikel> artikelen;
	private Persoon klant;
	
	/**
     * Constructor
     * 
     * Hier wordt een volledig nieuwe dienblad aangemaakt, dus met een lege lijst met artikelen
     */
	
	public Dienblad() {
		this.artikelen = new Stack<Artikel>();
		this.klant = null;
	}
	
	/**
     * Constructor
     * 
     * Hier wordt een volledig nieuwe dienblad met Klant aangemaakt, dus een lege lijst met artikelen
     */
	
	public Dienblad(Persoon klant) {
		this.artikelen = new Stack<Artikel>();
		this.klant = klant;
	}
	
	/**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
	
	public void voegToe(Artikel artikel) {
		if(artikel == null)
			return;
		
		this.artikelen.add(artikel);
	}
	
	public Stack<Artikel> getArtikelen(){
		return this.artikelen;
	}
	
	/**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
	
	public int getAantalArtikelen() {
		return this.artikelen.size();
	}
	
	/**
     * Methode om de Klant van het dienblad op te vragen
     *
     * @return klant
     */
	
	public Persoon getKlant() {
		return this.klant;
	}
	
	/**
     * Methode om een nieuwe klant aan het dienblad te geven
     *
     * @param klant
     */
	
	public void setKlant(Persoon klant) {
		this.klant = klant;
	}
	
	/**
     * Methode om de totaalprijs van de artikelen
     * op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
	
	/*public double getTotaalPrijs() {
	double totaal = 0.00f;
	
	for(Artikel artikel : this.artikelen) {
		if(artikel == null)
			continue;
		
		totaal += artikel.getPrijs();
	}
	
	return totaal;
}*/
}
