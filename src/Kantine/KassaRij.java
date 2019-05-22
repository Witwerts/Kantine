package Kantine;

import java.util.ArrayList;

public class KassaRij {
	private ArrayList<Dienblad> rij;
	
	public KassaRij() {
		this.rij = new ArrayList<Dienblad>();
	}
	
	public void sluitAchteraan(Dienblad klant) {
		this.rij.add(klant);
	}
	
	public Dienblad eerstePersoonInRij() {
		if(this.ErIsEenRij())
			return this.rij.get(0);
	
		return null;
	}
	
	public boolean ErIsEenRij() {
		return this.rij.isEmpty();
	}
}
