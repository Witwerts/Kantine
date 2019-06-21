package Kantine;

public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
	public boolean betaal(double tebetalen) {
    	boolean kanBetalen = this.saldo - tebetalen >= 0;
    	
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