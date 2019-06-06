package Kantine;

/**
 * Deze klasse zorgt voor de creatie en werking van een kassa en kassarij in een kantine.
 * @author Albert Witwerts
 * @author Gerwin Terpstra
 * @Version 1.1
 */
public class Kantine {
	private Kassa kassa;
	private KassaRij kassarij;
	private KantineAanbod kantineaanbod;
	
	/** 
	 * Constructor zonder parameters
	 */	
	public Kantine() {
		this.kassarij = new KassaRij();
		this.kassa = new Kassa(this.kassarij);
	}
	
	/**
	 * Deze methode zorgt ervoor dat een dienblad met artikelen achter een rij aansluit.
	 * @param dienblad
	 * @param artikelnamen
	 */	
	public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {
		if(this.kassarij == null)
			return;
		
		for(String artikelnaam : artikelnamen) {
			Artikel artikel = this.kantineaanbod.getArtikel(artikelnaam);
			
			dienblad.voegToe(artikel);
		}
		
		this.kassarij.sluitAchteraan(dienblad);
	}
	
	// Deze methode zorgt ervoor dat de eerstvolgende klant afrekent zolang er een rij bestaat.	 
	public void verwerkRijVoorKassa() {
		while(this.kassarij != null && this.kassarij.ErIsEenRij()) {
			Dienblad klant = this.kassarij.eerstePersoonInRij();
			this.kassa.rekenAf(klant);
		}
	}
	
	/** 
	 * Deze methode is de getter voor de instantievariabele kassa.
	 * @return kassa
	 */	
	public Kassa getKassa() {
		return this.kassa;
	}
	
	/** 
     * Deze methode is de getter voor de instantievariabele kantineAanbod.
	 * @return kantineAanbod
	 */
	public KantineAanbod getKantineAanbod() {
		return this.kantineaanbod;
	}
	
	// Deze methode is de setter voor kantineaanbod.
	public void setKantineAanbod(KantineAanbod kantineaanbod) {
		this.kantineaanbod = kantineaanbod;
	}
}
