package Kantine;

public class Kassa {
	private KassaRij kassarij;
	private int gescandeArtikelen;
	private double bedragInKassa;
	
	public Kassa(KassaRij kassarij) {
		this.kassarij = kassarij;
		
		this.resetKassa();
	}
	
	public void rekenAf(Dienblad klant) {
		if(klant == null)
			return;
		
		this.bedragInKassa = klant.getTotaalPrijs();
	}
	
	public int aantalArtikelen() {
		return this.gescandeArtikelen;
	}
	
	public double hoeveelheidGeldInKassa() {
		return this.bedragInKassa;
	}
	
	public void resetKassa() {
		this.gescandeArtikelen = 0;
		this.bedragInKassa = 0.00f;
	}
}
