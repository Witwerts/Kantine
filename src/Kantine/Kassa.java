package Kantine;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.time.LocalDate;

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
	
	private EntityManager manager;
	
	/**
     * Constructor waarmee een nieuwe kassa wordt aangemaakt.     * 
     * @param Kassarij
     */	
	public Kassa(EntityManager manager, KassaRij kassarij) {
		this.kassarij = kassarij;
		
		this.resetKassa();
		
		this.manager = manager;
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
		
		Factuur factuur = new Factuur(klant, LocalDate.of(2019,1,1));
		double totaalprijs = factuur.getTotaal() * (1 - factuur.getKorting());
		
		Betaalwijze betaalwijze = klant.getKlant().getBetaalwijze();
		EntityTransaction transaction = null;
		
		try {
			transaction = manager.getTransaction();
            transaction.begin();
            
			if(betaalwijze.betaal(totaalprijs)) {
				this.bedragInKassa += totaalprijs;
				
				manager.persist(factuur);
				transaction.commit();
			}
			else {
				transaction.rollback();
			}
		} catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
	}
	
	public void create(Student student) {
        EntityTransaction transaction = null;
        try {
            // Get a transaction, sla de student gegevens op en commit de transactie
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(student);
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
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
	
	
	/**
     * Deze methode reset de waarden van het aantal gepasseerde artikelen en
     * de totale hoeveelheid geld in de kassa.
     */	
	public void resetKassa() {
		this.gescandeArtikelen = 0;
		this.bedragInKassa = 0.00;
	}
}
