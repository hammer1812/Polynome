package Polynome;

public class RegulaFalsi extends Iterationsverfahren{

	public RegulaFalsi(Horner hn, int genauigkeit, double anfangsnaeherung0, double anfangsnaeherung1, int maxIterationen){
		if(Math.signum(hn.getFunktionswert(anfangsnaeherung0)) != (-1)*Math.signum(hn.getFunktionswert(anfangsnaeherung1))){
			throw new IllegalArgumentException("ungeeignete Startwerte");
		}
		
		anzahlIterationen = 1;
		double ns0 = anfangsnaeherung0;
		double ns1 = anfangsnaeherung1;
		nullstelle = ns0 - (ns1 - ns0)/(hn.getFunktionswert(ns1)-hn.getFunktionswert(ns0)) * hn.getFunktionswert(ns0);
		
		if(Math.signum(hn.getFunktionswert(nullstelle)) == Math.signum(hn.getFunktionswert(ns1))){
			ns1 = ns0;
		}
		
		while(Math.abs(hn.getFunktionswert(nullstelle))>=epsilon && anzahlIterationen < maxIterationen){
			ns1 = ns1 - (nullstelle - ns1)/(hn.getFunktionswert(nullstelle)-hn.getFunktionswert(ns1)) * hn.getFunktionswert(ns1);

			if(Math.signum(hn.getFunktionswert(nullstelle)) == Math.signum(hn.getFunktionswert(ns1))){
				nullstelle = ns1;
			}
			
			nullstelle = ns1 - (nullstelle - ns1)/(hn.getFunktionswert(nullstelle)-hn.getFunktionswert(ns1)) * hn.getFunktionswert(ns1);
			
			
			anzahlIterationen++;
		}
		
	}
	
}
