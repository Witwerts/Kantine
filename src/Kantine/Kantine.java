package Kantine;

public class Kantine {
	private Kassa kassa;
	private KassaRij kassarij;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Datum(29, 2, 2000);
	}
	
	public Kantine() {
		this.kassarij = new KassaRij();
		this.kassa = new Kassa(this.kassarij);
	}
	
	public void loopPakSluitAan() {
		if(this.kassarij == null)
			return;
		
		Persoon persoon = new Persoon();
		Dienblad dienblad = new Dienblad();
		
		this.kassarij.sluitAchteraan(dienblad);
	}
	
	public void verwerkRijVoorKassa() {
		 /* while() {
			
		} */
	}
	
	public double hoeveelheidGeldInKassa() {
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
	}
}
