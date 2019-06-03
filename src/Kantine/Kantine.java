package Kantine;

public class Kantine {
	private Kassa kassa;
	private KassaRij kassarij;
	private KantineAanbod kantineaanbod;
	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Datum(29, 2, 2000);
	//}
	
	public Kantine() {
		this.kassarij = new KassaRij();
		this.kassa = new Kassa(this.kassarij);
	}
	
	public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
		if(this.kassarij == null)
			return;
		
		Dienblad dienblad = new Dienblad(persoon);
		
		for(String artikelnaam : artikelnamen) {
			Artikel artikel = this.kantineaanbod.getArtikel(artikelnaam);
			
			dienblad.voegToe(artikel);
		}
		
		this.kassarij.sluitAchteraan(dienblad);
	}
	
	public void verwerkRijVoorKassa() {
		while(this.kassarij != null && this.kassarij.ErIsEenRij()) {
			Dienblad klant = this.kassarij.eerstePersoonInRij();
			this.kassa.rekenAf(klant);
		}
	}
	
	/*public double hoeveelheidGeldInKassa() {
		if(this.kassa != null)
			return this.kassa.hoeveelheidGeldInKassa();
		
		return 0.00f;
	}
	
	public int aantalArtikelen() {
		if(this.kassa != null)
			return this.kassa.aantalArtikelen();
		
		return 0;
	}
	
	public void resetKassa() {
		if(this.kassa != null)
			this.kassa.resetKassa();
	}*/
	
	public Kassa getKassa() {
		return this.kassa;
	}
	
	public KantineAanbod getKantineAanbod() {
		return this.kantineaanbod;
	}
	
	public void setKantineAanbod(KantineAanbod kantineaanbod) {
		this.kantineaanbod = kantineaanbod;
	}
}
