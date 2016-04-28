package Polynome;

public abstract class Iterationsverfahren {
	
	protected int anzahlIterationen;
	protected int genauigkeit;
	protected double nullstelle;
	protected int maxIterationen;
	protected double epsilon = Math.pow(10, (-1)*genauigkeit);
	
	public int getAnzahlIterationen(){
		return anzahlIterationen;
	}
	
	public double getNullstelle(){
		return nullstelle;
	}
}
