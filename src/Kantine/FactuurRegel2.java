package Kantine;

import java.time.LocalDate;
import java.util.Stack;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * Deze klasse zorgt voor de creatie en werking van een artikel.
 * @author Albert Witwerts
 * @author Gerwin Terpstra
 * @version 1.1
 */

@Entity
@Table(name = "regel")
public class FactuurRegel2 implements Serializable {
	@Id
    @GeneratedValue
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factuur_id")
	private Factuur factuur;
	
	//@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "artikel_id")
	//private Artikel artikel;
	
	/** 
	 * Constructor
     * 
     * Hier wordt een volledig nieuwe factuurregel aangemaakt, dus het heeft nog geen factuur en artikel
	 */	
	
	public FactuurRegel2() {}
	
	/** 
	 * Constructor
     * 
     * Hier wordt een volledig nieuwe factuur aangemaakt, dus het heeft nog geen totaalprijs en korting.
	 */	
	public FactuurRegel2(Factuur factuur, Artikel artikel) {
		this.factuur = factuur;
		//this.artikel = artikel;
	}
	
	public Factuur getFactuur() {
		return this.factuur;
	}
	
	/*public Artikel getArtikel() {
		return this.artikel;
	}*/
	
	/**
	 * @return een printbaar factuurregel
	 */
	public String toString() {
		return "";
	}
}
