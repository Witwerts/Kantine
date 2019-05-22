package Kantine;

public class Artikel {
	private String naam;
	private Double prijs;
	
	public Artikel() {
	}
	
	public Artikel(String naam, Double prijs) {
		this.setNaam(naam);
		this.setPrijs(prijs);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Double getPrijs() {
		return prijs;
	}

	public void setPrijs(Double prijs) {
		this.prijs = prijs;
	}
	
	public String toString() {
		return "Naam: " + this.getNaam() + " Prijs: " + this.getPrijs();
	}
}
