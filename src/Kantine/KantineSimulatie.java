package Kantine;

public class KantineSimulatie {
	private Kantine kantine;
	
	public static final int DAGEN = 7;
	
	public KantineSimulatie() {
		kantine = new Kantine();
	}

	public void Simuleer(int dagen) {
		if(dagen < 0)
			dagen = this.DAGEN;
		
		for(int i = 0; i < dagen; i++) {
			for(int j = 0; j < 10 + i; j++) {
				kantine.loopPakSluitAan();
			}
			
			kantine.verwerkRijVoorKassa();
			
			System.out.println("geld in kassa: " + kantine.hoeveelheidGeldInKassa());
			
			kantine.resetKassa();
		}
	}
	
	public static void main(String[] args) {
		int dagen;
		
		if(args.length == 0) {
			dagen = DAGEN;
		} else {
			dagen = Integer.parseInt(args[0]);
		}
		
		new KantineSimulatie().Simuleer(dagen);
	}
}
