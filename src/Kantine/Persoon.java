package Kantine;

public class Persoon {
	private int bsn;
	private String voornaam;
	private String achternaam;
	private Datum geboortedatum;
	private char geslacht;
	
	public Persoon() {
		
	}
	
	public Persoon(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
		this.bsn = bsn;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;

		this.setGeslacht(geslacht);
	}
	
	public int getBsn() {
		return bsn;
	}
	
	public void setBsn(int bsn) {
		this.bsn = bsn;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public Datum getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(Datum geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

	public String getGeslacht() {
		if(this.geslacht == 'm')
				return "Man";
		else if(this.geslacht == 'v')
			return "Vrouw";
		
		return "Onbekend";
	}

	public void setGeslacht(char geslacht) {
		if(geslacht == 'm' || geslacht == 'v')
			this.geslacht = geslacht;
		else
			System.out.println("Error: Persoon kon niet geslacht worden!");
	}
	
	public String toString() {
		return "BSN: " + this.getBsn() + " Naam: " + this.getVoornaam() + " " + this.getAchternaam() + " Geboortedatum: " + this.getGeboortedatum() + " Geslacht: " + this.getGeslacht();
	}
}
