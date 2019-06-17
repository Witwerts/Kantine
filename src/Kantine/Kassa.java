package Kantine;

import java.util.*;

/**
 * Deze klasse zorgt voor de creatie en werking van een kassa.
 * @author Albert Witwerts
 * @author Gerwin Terpstra
 * @version 1.1
 */
public class Kassa {
	private KassaRij kassarij;
	private int gescandeArtikelen;
	private double bedragInKassa;
	
	/**
     * Constructor waarmee een nieuwe kassa wordt aangemaakt.     * 
     * @param Kassarij
     */	
	public Kassa(KassaRij kassarij) {
		this.kassarij = kassarij;
		
		this.resetKassa();
	}
	
	/**
     * Methode waarmee je het aantal artikelen en de totaalprijs opvraagt.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.     *
     * @param klant
     */	
	public void rekenAf(Dienblad klant) {
		if(klant == null)
			return;
		
		this.gescandeArtikelen += klant.getAantalArtikelen();
		
		double totaalprijs = this.getTotaalPrijs(klant);
		
		if(klant.getKlant() instanceof KortingskaartHouder) {
			KortingskaartHouder kaarthouder = (KortingskaartHouder)klant.getKlant();
			
			double korting = (totaalprijs * (1 - kaarthouder.geefKortingsPercentage()));
			
			if(kaarthouder.heeftMaximum() && kaarthouder.geefMaximum() > korting)
				korting = kaarthouder.geefMaximum();
			
			totaalprijs -= korting;
		}
		
		try {
			if(klant.getKlant().getBetaalwijze().betaal(totaalprijs)) 
				this.bedragInKassa += this.getTotaalPrijs(klant);
			else {
				throw new TeWeinigGeldException();
			}
		}
		catch (TeWeinigGeldException e) {
			System.out.println("Klant " + klant.getKlant().getBsn() + " kan niet betalen!");
		}
	}
	
	/**
     * Deze methode geeft het aantal artikelen dat de kassa heeft gepasseerd
     * vanaf het moment dat de methode resetWaarden is aangeroepen.     *
     * @return aantalartikelen
     */	
	public int aantalArtikelen() {
		return this.gescandeArtikelen;
	}
	
	/**
     * Deze methode geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode resetKassa is aangeroepen.    
     * @return hoeveelheid geld in de kassa
     */	
	public double hoeveelheidGeldInKassa() {
		return this.bedragInKassa;
	}
	
	/**
     * Deze methode reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */	
	public void resetKassa() {
		this.gescandeArtikelen = 0;
		this.bedragInKassa = 0.00;
	}
	
	/**
	 * Deze methode is de getter van de totaalprijs
	 * @param klant
	 * @return totaalprijs in double
	 */
	public double getTotaalPrijs(Dienblad klant) {
		double totaal = 0.00;
		Stack<Artikel> artikelen = klant.getArtikelen();
		
		for(Artikel artikel : artikelen) {
			if(artikel == null)
				continue;
			
			totaal += artikel.getPrijs();
		}
		
		return totaal;
	}
}
