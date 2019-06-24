package Kantine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;

@Entity(name = "factuur")
@Table(name = "factuur")
@NamedQueries({
	@NamedQuery(name = "Factuur.total", query = "SELECT SUM(totaal), SUM(korting) FROM factuur"),
	@NamedQuery(name = "Factuur.average", query = "SELECT AVG(totaal), AVG(korting) FROM factuur"),
	@NamedQuery(name = "Factuur.top", query = "SELECT totaal, korting FROM factuur ORDER BY totaal DESC")
})

/**
 * Deze klasse zorgt voor de creatie en werking van een artikel.
 * @author Albert Witwerts
 * @author Gerwin Terpstra
 * @version 1.1
 */
public class Factuur implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "datum", nullable = false)
	private LocalDate datum;
	
	@Column(name = "korting", nullable = false)
	private double korting;
	
	@Column(name = "totaal", nullable = false)
	private double totaal;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "factuur_regel", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "regel_id"))
    private List<FactuurRegel> regels;
	
	/** 
	 * Constructor
     * 
     * Hier wordt een volledig nieuwe factuur aangemaakt, dus het heeft nog geen totaalprijs en korting.
	 */	
	public Factuur() {
		this.totaal = 0.00;
		this.korting = 0.00;
		
		this.regels = new ArrayList<FactuurRegel>();
	}
	
	/**
     * Constructor
     * 
     * Hier wordt een nieuwe factuur aangemaakt met klant en datum
     * 
     * @param klant, datum
     */
	
	public Factuur(Dienblad klant, LocalDate datum) {
		this();
		
		this.datum = datum;
		
		verwerkBestelling(klant);
	}
	
	/**
	* Verwerk artikelen en pas kortingen toe.
	*
	* Zet het totaal te betalen bedrag en het
	* totaal aan ontvangen kortingen.
	*
	* @param klant
	*/
	
	private void verwerkBestelling(Dienblad klant) {
		double totaalprijs = this.getTotaalPrijs(klant);
		double korting = 0.00;
		
		if(klant.getKlant() instanceof KortingskaartHouder) {
			KortingskaartHouder kaarthouder = (KortingskaartHouder)klant.getKlant();
			
			korting = (totaalprijs * (kaarthouder.geefKortingsPercentage() / 100));
			
			if(kaarthouder.heeftMaximum() && kaarthouder.geefMaximum() > korting)
				korting = kaarthouder.geefMaximum();
			
			totaalprijs -= korting;
		}
		
		for(Artikel artikel : klant.getArtikelen()) {
			this.regels.add(new FactuurRegel(this, artikel));
		}
		
		this.totaal = totaalprijs;
		this.korting = korting;
	}
	
	/**
	* @return het totaalbedrag
	*/
	public double getTotaal() {
		return this.totaal;
	}
	
	/**
	* @return het totaalbedrag
	*/
	public double getKorting() {
		return this.korting;
	}
	
	/**
	 * Deze methode is de getter van de totaalprijs
	 * @param klant
	 * @return totaalprijs in double
	 */
	public double getTotaalPrijs(Dienblad klant) {
		double totaal = 0.00;
		Stack<Artikel> artikelen = klant.getArtikelen();
		
		for(Artikel artikel : artikelen) {
			if(artikel == null)
				continue;
			
			totaal += artikel.getPrijs();
		}
		
		return totaal;
	}
	
	/**
	 * @return een printbaar bonnetje
	 */
	public String toString() {
		return "";
	}
}
