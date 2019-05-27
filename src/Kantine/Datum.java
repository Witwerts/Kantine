package Kantine;

public class Datum {
	private int dag;
	private int maand;
	private int jaar;
	
	/**
     * Constructor om een nieuwe datum aan te maken, zonder dat er een datum bekend is.
     */
	
	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}
	
	/**
     * Constructor
     * 
     * Hier wordt een nieuwe Datum aangemaakt, als er wel een dag, maand en jaar bekend is.
     *
     * @param dag, maand en jaar
     */
	
	public Datum(int dag, int maand, int jaar) {
		if(this.bestaatDatum(dag, maand, jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
		else {
			this.dag = 0;
			this.maand = 0;
			this.jaar = 0;
		}
	}
	
	/**
     * Methode om de dag van de Datum op te vragen
     *
     * @return dag
     */
	
	public int getDag() {
		return dag;
	}
	
	/**
     * Methode om de dag van de Datum aan te kunnen passen
     *
     * @param dag
     */
	
	public void setDag(int dag) {
		this.dag = dag;
	}

	/**
     * Methode om de maand van de Datum op te vragen
     *
     * @return maand
     */
	
	public int getMaand() {
		return maand;
	}

	/**
     * Methode om de maand van de Datum aan te kunnen passen
     *
     * @param maand
     */
	
	public void setMaand(int maand) {
		this.maand = maand;
	}

	/**
     * Methode om het jaar van de Datum op te kunnen vragen
     *
     * @return jaar
     */
	
	public int getJaar() {
		return jaar;
	}

	/**
     * Methode om het jaar van de Datum aan te kunnen passen
     *
     * @param jaar
     */
	
	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
	
	/**
     * Methode om de volledige Datum in een string op te kunnen vragen.
     *
     * @return de datum als string
     */
	
	public String getDatumAsString() {
		return String.format("%02d-%02d-%04d", dag, maand, jaar);
	}
	
	/**
     * Methode om te kunnen controleren of de gegeven dag, maand en jaar een geldige datum is.
     *
     * @param dag, maand, jaar
     *
     * @return true/false (boolean)
     */
	
	public Boolean bestaatDatum(int dag, int maand, int jaar) {
		if(dag < 1 || maand < 1 || maand > 12 || jaar < 1900 || jaar > 2100)
			return false;
		
		switch(maand) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(dag > 31)
					return false;
				
				break;
			
			case 2:
				if((dag > 28 && (!(jaar % 4 == 0 && (jaar % 100 != 0 || jaar % 400 == 0)))) || dag > 29)
					return false;
				
			default:
				if(dag > 30)
					return false;
					
				break;
		}
		
		return true;
	}
}
