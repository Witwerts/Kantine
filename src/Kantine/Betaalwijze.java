package Kantine;

import java.util.Random;

public abstract class Betaalwijze {
    protected double saldo;

    public Betaalwijze() {
    	int bedrag = new Random().nextInt(600) + 600;
    	
    	setSaldo(bedrag / 100);
    }
    
    /**
     * Methode om krediet te initialiseren
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Methode om betaling af te handelen
     *
     * @param tebetalen
     * @return Boolean om te kijken of er voldoende saldo is
     */
    public abstract boolean betaal(double tebetalen);
}