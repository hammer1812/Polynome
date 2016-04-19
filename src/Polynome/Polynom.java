package Polynome;

import java.util.ArrayList;

public class Polynom {

	private ArrayList<Double> polynom;
	
	public Polynom(String argumente){
		String[] coeffs = argumente.split(",");
		polynom = new ArrayList<Double>();
		for(int i=0; i<coeffs.length; i++){
			polynom.add(Double.parseDouble(coeffs[i]));
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<polynom.size();i++){
			//s = s + polynom[i] + "*x^" + i + "+";
			if(i==0){
				sb.append(polynom.get(i));
				sb.append("*x^");
				sb.append(i);
				sb.append(" ");
			}	//a*x^i
			else if(i==polynom.size()-1){
				if(polynom.get(i) >= 0){
					sb.append("+");
					sb.append(polynom.get(i));
				}	//+a
				else{
					sb.append(polynom.get(i));
				}	//-a
			}
			else{
				if(polynom.get(i) >= 0){
					sb.append("+");
					sb.append(polynom.get(i));
					sb.append("*x^");
					sb.append(i);
					sb.append(" ");
				}	//+a*x^i
				else{
					sb.append(polynom.get(i));
					sb.append("*x^");
					sb.append(i);
					sb.append(" ");
				}	//-a*x^i
			}
			
		}
		return sb.toString();
		
	}
	
}
