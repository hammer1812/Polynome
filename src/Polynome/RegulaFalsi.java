package Polynome;
/**
 * 
 * @author Adrian Fietta
 * 
 */
public class RegulaFalsi extends Iterationsverfahren{
	/**
	 * Konstruktor
	 * 
	 * Berechnet die Nullstellen des Polynoms nach dem Regula Falsi Verfahren.
	 * @param hn	Objekt Horner um Funktionalitaeten zur Berechnung der Funktionswerte in der Klasse Horner zu ermöglichen.
	 * @param genauigkeit	Genauigkeit auf welches das Ergebnis gerundet werden soll.
	 * @param anfangsnaeherung0	Die erste Anfangsnaeherung der Nullstelle, welche vom Benutzer festgelegt wird.
	 * @param anfangsnaeherung1	Die zweite Anfangsnaeherung der Nullstelle, wird ebenfalls vom Benutzer festgelegt, nur notwendig für Regula Falsi.
	 * @param maxIterationen	Anzahl der maximalen Iterationen für die Durchführung der Methode
	 */
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
