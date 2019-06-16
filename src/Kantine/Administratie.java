package Kantine;

/**
 * Deze klasse zorgt voor de creatie en werking van een adminstratie.
 * @author Albert Witwerts
 * @author Gerwin Terpstra
 * @version 1.1
 */
public class Administratie {
	 final static int DAYS_IN_WEEK = 7;
	
    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal in int
     * @return het gemiddelde in double
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
    	double totaal = 0.00;
    	
    	for(int getal : aantal)
    		totaal += getal;
    	
    	return totaal / aantal.length;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
    	double totaal = 0.00;
    	
    	for(double getal : omzet) {
    		totaal += getal;
    	}
    	
    	return totaal / omzet.length;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[DAYS_IN_WEEK];
        
        for(int i = 0; i < DAYS_IN_WEEK; i++) {
            int j = 0;
            
            while((i + DAYS_IN_WEEK * j) < omzet.length) {
            	double getal = omzet[i + DAYS_IN_WEEK * j];
            	
            	if(getal > 0.0) {
            		temp[i] += getal;
            	}

                j++;
            }
        }
        
        return temp;
    }
}
