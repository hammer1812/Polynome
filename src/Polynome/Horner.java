package Polynome;

public class Horner {
	
	private Polynom polynom;
	
	public Horner(Polynom polynom){
		
		this.polynom = polynom;
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
