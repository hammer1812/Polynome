package Polynome;

public class Newton extends Iterationsverfahren{

	public Newton(Horner hn, int genauigkeit, double anfangsnaeherung, int maxIterationen){
		this.genauigkeit = genauigkeit;
		this.maxIterationen = maxIterationen;
		nullstelle = anfangsnaeherung;
		anzahlIterationen = 0;
		while(Math.abs(hn.getFunktionswert(nullstelle))>=epsilon && anzahlIterationen < maxIterationen){
			nullstelle = nullstelle - hn.getFunktionswert(nullstelle)/hn.getErsteAbleitungwert(nullstelle);
			anzahlIterationen++;
		}
		//nullstelle = nullstelle - hn.getFunktionswert(nullstelle)/hn.getErsteAbleitungwert(nullstelle);
		
	}
	
}
