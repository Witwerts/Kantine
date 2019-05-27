package Kantine;

public class Kassa {
	private KassaRij kassarij;
	private int gescandeArtikelen;
	private double bedragInKassa;
	
	/**
     * Constructor
     * 
     * Hier wordt een volledig nieuwe kassa aangemaakt.
     * 
     * @param De rij van de kassa (KassaRij)
     */
	
	public Kassa(KassaRij kassarij) {
		this.kassarij = kassarij;
		
		this.resetKassa();
	}
	
	/**
     * Vraag het aantal artikelen en de totaalprijs op.
     * Tel deze gegevens op bij de controletotalen die voor
     * de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
	
	public void rekenAf(Dienblad klant) {
		if(klant == null)
			return;
		
		this.bedragInKassa = klant.getTotaalPrijs();
	}
	
	/**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd,
     * vanaf het moment dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
	
	public int aantalArtikelen() {
		return this.gescandeArtikelen;
	}
	
	/**
     * Geeft het totaalbedrag van alle artikelen die de kass
     * zijn gepasseerd, vanaf het moment dat de methode
     * resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
	
	public double hoeveelheidGeldInKassa() {
		return this.bedragInKassa;
	}
	
	/**
     * reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */
	
	public void resetKassa() {
		this.gescandeArtikelen = 0;
		this.bedragInKassa = 0.00f;
	}
}
