package Kantine;

import java.util.*;

public class Dienblad {
	private ArrayList<Artikel> artikelen;
	
	public Dienblad() {
		
	}
	
	public void voegToe(Artikel artikel) {
		if(artikel == null)
			return;
		
		this.artikelen.add(artikel);
	}
	
	public int getAantalArtikelen() {
		return this.artikelen.size();
	}
	
	public double getTotaalPrijs() {
		double totaal = 0.00f;
		
		for(Artikel artikel : this.artikelen) {
			if(artikel == null)
				continue;
			
			totaal += artikel.getPrijs();
		}
		
		return totaal;
	}
}
