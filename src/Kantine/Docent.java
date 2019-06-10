package Kantine;

public class Docent extends Persoon{
	private String vierLetterCode;
	private String afdeling;
	
	public Docent() {
		super();
	}
	
	public Docent(String vierLettercode, String afdeling) {
		super();
		
		this.vierLetterCode = vierLetterCode;
		this.afdeling = afdeling;
	}
	
	public Docent(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, String vierLetterCode, String afdeling) {
		super(bsn, voornaam, achternaam, geboortedatum, geslacht);
		
		this.vierLetterCode = vierLetterCode;
		this.afdeling = afdeling;
	}

	public String getVierLetterCode() {
		return vierLetterCode;
	}

	public void setVierLetterCode(String vierLetterCode) {
		this.vierLetterCode = vierLetterCode;
	}

	public String getAfdeling() {
		return afdeling;
	}

	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}
	
	public String toString() {
		return "Docent";
	}
}
