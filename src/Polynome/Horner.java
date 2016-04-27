package Polynome;
/**
 * 
 * @author Philip
 *
 */
public class Horner {
	
	private Polynom polynom;
	/**
	 * Konstruktor
	 * @param polynom das Polynom welches berechnet wird
	 */
	public Horner(Polynom polynom){
		
		this.polynom = polynom;
	}
	/**
	 * 
	 * @return das �bergebene Polynome
	 */
	public Polynom getPolynom(){
		return polynom;
	}
	/**
	 * 
	 * @return Darstellung des Polynoms als String
	 */
	public String getStringOfPolynom(){
		return polynom.toString();
	}
	/**
	 * berechnet ein Polynom f�r x nach Horner-Schema
	 * @param x Wert f�r den das Polynom berechnet werden soll
	 * @return Funktionswert f�r x
	 */
	public double getFunktionswert(double x){
		double fw = 0;
		for(int i=0; i<polynom.size(); i++){
			fw *= x;
			fw += polynom.get(i);
		}
		return fw;
	}
	/**
	 * berechnet die erste Ableitung eines Polynoms f�r x nach Horner-Schema
	 * @param x Wert f�r den die erste Ableitung des Polynoms berechnet werden soll
	 * @return Funktionswert der ersten Ableitung f�r x
	 */
	public double getErsteAbleitungwert(double x){
		double eaw = 0;
		double fw = 0;
		for(int i=0; i<polynom.size()-1; i++){
			fw *= x;
			eaw *= x;
			fw += polynom.get(i);
			eaw += fw;
		}
		return eaw;
	}	
}
