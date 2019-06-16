package Kantine;

/**
 * Deze klasse zorgt voor de creatie van een persoon.
 * @author Gerwin Terpstra
 * @author Albert Witwerts
 * @version 1.1
 */
public class Student extends Persoon{
	private int studentNummer;
	private String studieRichting;
	
	// Constructor die een student aanmaakt zonder parameters
	public Student() {
		super();
	}
	
	/**
	 * Constructor die een student aanmakt met een studentennummer en studierichting
	 * @param studentNummer in int
	 * @param studieRicthing in String
	 */
	public Student(int studentNummer, String studieRicthing) {
		super();
		
		this.studentNummer = studentNummer;
		this.studieRichting = studieRichting;
	}
	
	/**
	 * Constructor die een student aanmaakt met veel informatie
	 * @param bsn
	 * @param voornaam
	 * @param achternaam
	 * @param geboortedatum
	 * @param geslacht
	 * @param studentNummer
	 * @param studieRichting
	 */
	public Student(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int studentNummer, String studieRichting, Betaalwijze betaalwijze) {
		super(bsn, voornaam, achternaam, geboortedatum, geslacht, betaalwijze);
		
		this.studentNummer = studentNummer;
		this.studieRichting = studieRichting;
	}

	/**
	 * Deze methode geeft het nummer van de student terug
	 * @return studentNumer in int
	 */
	public int getStudentNummer() {
		return studentNummer;
	}

	/**
	 * Deze methode past het nummer aan van de student
	 * @param studentNummer in int
	 */
	public void setStudentNummer(int studentNummer) {
		this.studentNummer = studentNummer;
	}

	/**
	 * Deze methode geeft de studierichting terug van de student
	 * @return studieRichting in String
	 */
	public String getStudieRichting() {
		return studieRichting;
	}

	/**
	 * Deze methode past de studierichting aan
	 * @param studieRichting in String
	 */
	public void setStudieRichting(String studieRichting) {
		this.studieRichting = studieRichting;
	}

	/**
	 * Deze methode geeft alle informatie van de student terug in String
	 * @return alle informatie in String
	 */
	public String toString() {
		return "Student";
	}
}
