package Kantine;
public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen) {
    	boolean kanBetalen = this.saldo - tebetalen >= -kredietlimiet;
    	
    	try {
    		if(kanBetalen) {
        		this.saldo -= tebetalen;
        	}
        	else {
        		throw new TeWeinigGeldException("Kan niet betalen...");
        	}
    	}
    	catch (TeWeinigGeldException e) {
    		System.out.println(e);
    	}
    	
        return kanBetalen;
    }
}
