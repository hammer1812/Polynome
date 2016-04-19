package Polynome;

public class Polynom {

	private double[] polynom;
	
	public Polynom(String argumente){
		String[] coeffs = argumente.split(",");
		polynom = new double[3];
		for(int i=0; i<polynom.length; i++){
			polynom[i] = Double.parseDouble(coeffs[i]);
		}
	}
	
	public String toString(){
		String s = "";
		for(int i=polynom.length-1; i>=0;i--){
			s = s + polynom[i] + "*x^" + i + "+";
		}
		return s;
		
	}
	
}
