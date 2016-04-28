package Polynome;
/**
 * 
 * @author Adrian Fietta
 *
 */
public class Newton extends Iterationsverfahren{
	/**
 	 * Konstruktor
 	 * 
 	 * Berechnet die Nullstelle des Polynoms nach Newtonverfahren.
 	 * @param hn	Objekt Horner um Funktionalitaeten zur Berechnung der Funktionswerte in der Klasse Horner zu ermöglichen.
	 * @param genauigkeit	Genauigkeit auf welches das Ergebnis gerundet werden soll.
	 * @param anfangsnaeherung	Die Anfangsnaeherung der Nullstelle, welche vom Benutzer festgelegt wird.
	 * @param maxIterationen	Anzahl der maximalen Iterationen für die Durchführung der Methode
	 */
	public Newton(Horner hn, int genauigkeit, double anfangsnaeherung, int maxIterationen){
		
		this.genauigkeit = genauigkeit;
		this.maxIterationen = maxIterationen;
		
		nullstelle = anfangsnaeherung;
		anzahlIterationen = 0;
		
		while(Math.abs(hn.getFunktionswert(nullstelle))>=epsilon && anzahlIterationen < maxIterationen){
			nullstelle = nullstelle - hn.getFunktionswert(nullstelle)/hn.getErsteAbleitungwert(nullstelle);
			anzahlIterationen++;
		}
	
	}
	
}
