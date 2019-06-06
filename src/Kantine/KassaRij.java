package Kantine;

import java.util.*;

/**
 * Deze klasse zorgt voor de werking van een kassarij.
 * @author Gerwin Terpstra
 * @author Albert Witwerts
 * @version 1.1
 */
public class KassaRij {
	private LinkedList<Dienblad> rij;
	
	/**
     * Constructor zonder parameters waarmee een nieuwe kassarij wordt aangemaakt.
     */
	public KassaRij() {
		this.rij = new LinkedList<Dienblad>();
	}
	
	/**
     * In deze methode wordt de klant (Dienblad) achteraan de rij, oftewel aan de Array toegevoegd.     *
     * @param dienblad van de klant
     */
	public void sluitAchteraan(Dienblad klant) {
		this.rij.add(klant);
	}
	
	/**
     * Geeft de eerste dienblad (klant) in de rij, wanneer er een rij is.
     * Als er nog geen rij is wordt er niks (null) terug gestuurd.     *
     * @return Dienblad
     */	
	public Dienblad eerstePersoonInRij() {
		if(this.ErIsEenRij())
			return this.rij.removeFirst();
	
		return null;
	}
	
	/**
     * Deze methode controleert of de rij niet leeg is.     *
     * @return boolean
     */	
	public boolean ErIsEenRij() {
		return !this.rij.isEmpty();
	}
}
