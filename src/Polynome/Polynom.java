package Polynome;

public class Polynom {

	private double[] polynom;
	
	public Polynom(String argumente){
		String[] coeffs = argumente.split(";");
		polynom = new double[coeffs.length];
		for(int i=0; i<coeffs.length; i++){
			polynom[i] = Double.parseDouble(coeffs[i]); //wirft exception wenn Kommazahl mit "," statt "." geschrieben wird kektoni
		}
	}
	
	public double get(int index){
		return polynom[index];
	}
	
	public int size(){
		return polynom.length;
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
