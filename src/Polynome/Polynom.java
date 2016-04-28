package Polynome;
/**
 * 
 * @author Philip Förster
 *
 */
public class Polynom {
	/**
	 * Polynom
	 * 
	 * index des Arrays entspricht dem Exponenten von x
	 */
	private double[] polynom;
	/**
	 * Radikand einer Wurzel
	 */
	private double radikand;
	/**
	 * Exponent einer Wurzel
	 */
	private int exponent;
	/**
	 * Konstruktor
	 * 
	 * wandelt den übergebenen String in ein Polynom um und stellt Funktionalitäten bereit
	 * @param argumente String der zu einem Polynom umgewandelt wird (1;2;3 == 1x^2 + 2x + 3)
	 */
	public Polynom(String argumente){
		String[] coeffs = argumente.split(";");
		polynom = new double[coeffs.length];
		for(int i=0; i<coeffs.length; i++){
			polynom[i] = Double.parseDouble(coeffs[i]); //wirft exception wenn Kommazahl mit "," statt "." geschrieben wird kektoni
		}
	}
	/**
	 * Konstruktor
	 * 
	 * wandelt eine Wurzel in ein Polynom um und stellt Funktionalitäten bereit
	 * @param radikand Radikand einer Wurzel
	 * @param exponent Exponent einer Wurzel
	 */
	public Polynom(double radikand, int exponent){
		this.radikand = radikand;
		this.exponent = exponent;
		polynom = new double[exponent+1];
		polynom[0] = 1;
		for(int i = 1; i < polynom.length-1;i++){
			polynom[i] = 0;
		}
		polynom[exponent] = (-1)*radikand;
	}
	/**
	 * getter für einen Koeffizienten am Index des Polynoms
	 * @param index Position des Koeffizienten
	 * @return ein Koeffizient des Polynoms
	 */
	public double get(int index){
		return polynom[index];
	}
	/**
	 * getter für Groesse des Polynoms
	 * @return Groesse des Polynoms
	 */
	public int size(){
		return polynom.length;
	}
	/**
	 * formatiert das Polynom um es als String darzustellen
	 * @return Polynom als String
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<polynom.length;i++){
			//s = s + polynom[i] + "*x^" + i + "+";
			
			if(i==0){
				sb.append(polynom[i]);
				sb.append("*x^");
				sb.append(polynom.length-i-1);
				sb.append(" ");
			}	//a*x^i
			else if(i==polynom.length-1){
				if(polynom[i] >= 0){
					sb.append("+");
					sb.append(polynom[i]);
				}	//+a
				else{
					sb.append(polynom[i]);
				}	//-a
			}
			else{
				if(polynom[i] >= 0){
					sb.append("+");
					sb.append(polynom[i]);
					sb.append("*x^");
					sb.append(polynom.length-i-1);
					sb.append(" ");
				}	//+a*x^i
				else{
					sb.append(polynom[i]);
					sb.append("*x^");
					sb.append(polynom.length-i-1);
					sb.append(" ");
				}	//-a*x^i
			}
			
		}
		return sb.toString();
		
	}
	
}
