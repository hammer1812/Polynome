package Polynome;
/**
 * 
 * @author Adrian Fietta
 *
 */
public abstract class Iterationsverfahren {
	/**
	 * Anzahl der Iterationen
	 */
	protected int anzahlIterationen;
	/**
	 * Genauigkeit des Ergebnisses
	 */
	protected int genauigkeit;
	/**
	 * Berechnete Nullstelle
	 */
	protected double nullstelle;
	/**
	 * Maximale Anzahl der Iterationen
	 */
	protected int maxIterationen;
	/**
	 * Epsilon Genauigkeit
	 */
	protected double epsilon = Math.pow(10, (-1)*genauigkeit);
	/**
	 * 
	 * @return	Gibt die Anzahl der gewünschten Iterationen zurück.
	 */
	public int getAnzahlIterationen(){
		return anzahlIterationen;
	}
	/**
	 * 
	 * @return	Gibt die berechnete Nullstelle zurück.
	 */
	public double getNullstelle(){
		return nullstelle;
	}
}
