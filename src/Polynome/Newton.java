package Polynome;

public class Newton extends Iterationsverfahren{

	public Newton(Horner hn, int genauigkeit, double anfangsnaeherung, int maxIterationen){
		this.genauigkeit = genauigkeit;
		this.maxIterationen = maxIterationen;
		nullstelle = anfangsnaeherung;
		for(int i = 0; i < maxIterationen; i++){
			nullstelle = nullstelle - hn.getFunktionswert(nullstelle)/hn.getErsteAbleitungwert(nullstelle);
		}
	}
	
}
