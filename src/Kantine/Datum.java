package Kantine;

public class Datum {
	private int dag;
	private int maand;
	private int jaar;
	
	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}
	
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
	
	public int getDag() {
		return dag;
	}
	
	public void setDag(int dag) {
		this.dag = dag;
	}

	public int getMaand() {
		return maand;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
	
	public String getDatumAsString() {
		return String.format("%02d-%02d-%04d", dag, maand, jaar);
	}
	
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
