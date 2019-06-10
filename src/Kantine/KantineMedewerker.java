package Kantine;

public class KantineMedewerker extends Persoon {
	private int medewerkersNummer;
	private boolean magAchterKassa;
	
	public KantineMedewerker() {
		super();
	}
	
	public KantineMedewerker(int medewerkersNummer, boolean magAchterKassa) {
		super();
		
		this.medewerkersNummer = medewerkersNummer;
		this.magAchterKassa = magAchterKassa;
	}
	
	public KantineMedewerker(int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int medewerkersNummer, boolean magAchterKassa) {
		super(bsn, voornaam, achternaam, geboortedatum, geslacht);
		
		this.medewerkersNummer = medewerkersNummer;
		this.magAchterKassa = magAchterKassa;
	}

	public int getMedewerkersNummer() {
		return medewerkersNummer;
	}

	public void setMedewerkersNummer(int medewerkersNummer) {
		this.medewerkersNummer = medewerkersNummer;
	}

	public boolean isMagAchterKassa() {
		return magAchterKassa;
	}

	public void setMagAchterKassa(boolean magAchterKassa) {
		this.magAchterKassa = magAchterKassa;
	}

	public String toString() {
		return "Kantine Medewerker";
	}
}
