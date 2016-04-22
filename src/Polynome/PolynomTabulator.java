package Polynome;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class PolynomTabulator {
	
	private ArrayList<String> table;
	private Horner hn;

	public PolynomTabulator(Horner hn){
		this.hn = hn;
		//funktionswerte für wertebereich berechnen
		table = new ArrayList<String>();
		double ende = Math.abs(hn.getWertebereich1()-hn.getWertebereich2())/hn.getSchrittweite();
		//Bug: berechnet in der Schleife merkwürdige Kommazahlen, bzw sind die nicht auch eine stelle gerundet FeelsBadMan
		for(int n = 0; n <= ende; n++){
			double i = round(hn.getWertebereich1() + hn.getSchrittweite()*n, 1);
			StringBuilder sb = new StringBuilder();
			sb.append("\t");
			sb.append(i);
			sb.append("\t\t");
			sb.append(hn.getFunktionswert(i));
			sb.append("\t\t");
			sb.append(hn.getErsteAbleitungwert(i));
			table.add(sb.toString());
		}
		
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	//Muster:
	//    5x^2+3x+1
	// _____________________________________________________________________
	//|		Argument	|		Polynomwert		|		Ableitungswert		|
	//|		x			|		xyz				|		XYZ					|
	//|		x			|		xyz				|		XYZ					|
	//|		x			|		xyz				|		XYZ					|
	//|		x			|		xyz				|		XYZ					|
	//|		x			|		xyz				|		XYZ					|
	//|_________________|_______________________|___________________________|
	public void format(){
		System.out.println("Berechnung für das Polynom: " + hn.getStringOfPolynom());
		System.out.println("\tArgument\t\tPolynomwert\t\tWert der ersten Ableitung");
		for(int i = 0; i<table.size(); i++){
			System.out.println(table.get(i));
		}
	}
	
}
