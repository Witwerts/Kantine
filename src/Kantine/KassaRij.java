package Kantine;

import java.util.ArrayList;

public class KassaRij {
	private ArrayList<Dienblad> rij;
	
	/**
     * Constructor
     * 
     * Hier wordt een volledig nieuwe kassarij aangemaakt.
     * 
     * @param De rij van de kassa (KassaRij)
     */
	public KassaRij() {
		this.rij = new ArrayList<Dienblad>();
	}
	
	/**
     * In deze methode wordt de klant (Dienblad) achteraan de rij, oftewel aan de Array toegevoegd.
     *
     * @param dienblad van de klant
     */
	
	public void sluitAchteraan(Dienblad klant) {
		this.rij.add(klant);
	}
	
	/**
     * Geeft de eerste dienblad (klant) in de rij, wanneer er een rij is.
     * Als er nog geen rij is wordt er niks (null) terug gestuurd.
     *
     * @return de eerste klant (Dienblad) in de rij
     */
	
	public Dienblad eerstePersoonInRij() {
		if(this.ErIsEenRij())
			return this.rij.get(0);
	
		return null;
	}
	
	/**
     * Controleert of de rij niet leeg is.
     *
     * @return true/false (boolean)
     */
	
	public boolean ErIsEenRij() {
		return !this.rij.isEmpty();
	}
}
