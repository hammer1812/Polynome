package Polynome;

import java.util.ArrayList;

public class PolynomTabulator {
	
	private ArrayList<String> table;
	private Horner hn;

	public PolynomTabulator(Horner hn){
		this.hn = hn;
		//funktionswerte für wertebereich berechnen
		table = new ArrayList<String>();
		
		//Bug: berechnet in der Schleife merkwürdige Kommazahlen, bzw sind die nicht auch eine stelle gerundet FeelsBadMan
		for(double i = hn.getWertebereich1(); i<=hn.getWertebereich2(); i += hn.getSchrittweite()){
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
	//Muster:
	//    5x^2+3x+1
	//_______________________________________________________________________
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
