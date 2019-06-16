package Kantine;

/**
 * Deze klasse zorgt voor de creatie van een docent
 * @author Gerwin Terpstra
 * @author Albert Witwerts
 * @version 1.1
 */
public class Docent extends Persoon{
	private String vierLetterCode;
	private String afdeling;
	
	/**
	 * Constructor voor de klasse docent zonder parameters.
	 */
	public Docent() {
		super();
	}
	
	/**
	 * Constructor voor de klasse docent die een docent met een code en afdeling aanmaakt.
	 * @param vierLettercode in String
	 * @param afdeling in String
	 */
	public Docent(String vierLettercode, String afdeling) {
		super();
		
		this.vierLetterCode = vierLetterCode;
		this.afdeling = afdeling;
	}
	
	/**
	 * Constructor voor de klasse Docent die een docent aanmaakt met heel veel gegevens.
	 * @param bsn
	 * @param voornaam
	 * @param achternaam
	 * @param geboortedatum
	 * @param geslacht
	 * @param vierLetterCode
	 * @param afdeling
	 */
	public Docent(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, String vierLetterCode, String afdeling) {
		super(bsn, voornaam, achternaam, geboortedatum, geslacht);
		
		this.vierLetterCode = vierLetterCode;
		this.afdeling = afdeling;
	}

	// Deze methode geeft de code van de docent terug
	public String getVierLetterCode() {
		return vierLetterCode;
	}

	/**
	 * Deze methode past de code van de docent aan
	 * @param vierLetterCode in String
	 */
	public void setVierLetterCode(String vierLetterCode) {
		this.vierLetterCode = vierLetterCode;
	}

	// Deze methode is de getter van afdeling
	public String getAfdeling() {
		return afdeling;
	}

	/** deze methode past de afdeling aan
	 *  @param afdeling in String
	 */
	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}
	
	/** Deze methode geeft de informatie van de docent terug in String
	 *  @return alle informatie van de docent in String
	 */
	public String toString() {
		return "Docent";
	}
}
