package Polynome;

public class Horner {
	
	private double wertebereich1, wertebereich2, schrittweite;
	private double radikand;
	private int exponent;
	private Polynom polynom;
	
	public Horner(Polynom polynom, double wertebereich1, double wertebereich2, double schrittweite){
		this.wertebereich1 = wertebereich1;
		this.wertebereich2 = wertebereich2;
		this.schrittweite = schrittweite;
		this.polynom = polynom;
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
	
	public Polynom getPolynom(){
		return polynom;
	}
	
	public String getStringOfPolynom(){
		return polynom.toString();
	}
	
	public double getFunktionswert(double x){
		double fw = 0;
		for(int i=0; i<polynom.size(); i++){
			fw *= x;
			fw += polynom.get(i);
		}
		return fw;
	}
	
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
