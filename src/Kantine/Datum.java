package Kantine;

/**
 * Deze klasse zorgt voor de creatie en werking van een datum.
 * @author Gerwin Terpstra
 * @author Albert Witwerts
 * @version 1.1
 */
public class Datum {
	private int dag;
	private int maand;
	private int jaar;
	
	/**
     * Constructor zonder parameters waarmee een datum met alle instanstievariabelen op 0 wordt aangemaakt.
     */	
	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}
	
	/**
     * Constructor waar een nieuwe datum aangemaakt met bekende datums.
     * Als de datum niet geldig is, worden de instantievariabelen op 0 gezet.
     * @param dag
     * @param maand
     * @param jaar
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
     * Deze methode is de getter van dag.
     * @return dag
     */	
	public int getDag() {
		return dag;
	}
	
	/**
     * Deze methode is de zetter van dag.
     * @param dag
     */	
	public void setDag(int dag) {
		this.dag = dag;
	}

	/**
     * Deze methode is de getter van maand.
     * @return maand
     */	
	public int getMaand() {
		return maand;
	}

	/**
     * Deze methode is de setter van maand.
     * @param maand
     */	
	public void setMaand(int maand) {
		this.maand = maand;
	}

	/**
     * Deze methode is de getter van jaar.
     * @return jaar
     */	
	public int getJaar() {
		return jaar;
	}

	/**
     * Deze methode is de setter van jaar.
     * @param jaar
     */	
	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
	
	/**
     * Deze methode geft de volledige datum terug in type string.
     * @return de datum als string.
     */	
	public String getDatumAsString() {
		return String.format("%02d-%02d-%04d", dag, maand, jaar);
	}
	
	/**
     * Deze methode controleert of de gegeven dag, maand en jaar samen een geldige datum zijn.
     * @param dag
     * @param maand
     * @param jaar
     * @return geldige datum in boolean
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
