package Polynome;

import java.util.Arrays;

public class Horner {
	
	private double wertebereich1, wertebereich2, schrittweite;
	private double[] polynom;
	
	//TO-DO Array-deklaration wieder in Polynom.java auslagern
	//TO-DO getter in Polynom.java einrichten und dann mit Arrays.copyOf() was basteln
	public Horner(String argumente, double wertebereich1, double wertebereich2, double schrittweite){
		String[] coeffs = argumente.split(";");
		polynom = new double[coeffs.length];
		for(int i=0; i<coeffs.length; i++){
			polynom[i] = Double.parseDouble(coeffs[i]); //wirft exception wenn Kommazahl mit "," statt "." geschrieben wird kektoni
		}
		this.wertebereich1 = wertebereich1;
		this.wertebereich2 = wertebereich2;
		this.schrittweite = schrittweite;
		
	}
	
	public double getWertebereich1(){
		return wertebereich1;
	}
	
	public double getWertebereich2(){
		return wertebereich2;
	}
	
	public double getSchrittweite(){
		return schrittweite;
	}
	
	public double[] getPolynom(){
		return Arrays.copyOf(polynom, polynom.length);
	}
	
	public double getFunktionswert(double x){
		double fw = 0;
		
		return fw;
	}
	
	public double getErsteAbleitungwert(double x){
		double eaw = 0;
		
		return eaw;
	}
	
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
