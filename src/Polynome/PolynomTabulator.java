package Polynome;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class PolynomTabulator {
	
	private ArrayList<String> table;
	private Horner hn;
//testkoeffizienten: 1;2;-5;-10;4;8
	public PolynomTabulator(Horner hn, double wertebereich1, double wertebereich2, double schrittweite){
		this.hn = hn;
		table = new ArrayList<String>();
		double ende = Math.abs(wertebereich1-wertebereich2)/schrittweite;
		
		for(int n = 0; n <= ende; n++){
			BigDecimal bd = new BigDecimal(wertebereich1 + schrittweite*n);
			bd = bd.setScale(1, RoundingMode.HALF_UP);
			StringBuilder sb = new StringBuilder();
			sb.append("\t");
			sb.append(bd.doubleValue());
			sb.append("\t\t");
			sb.append(hn.getFunktionswert(bd.doubleValue()));
			sb.append("\t\t");
			sb.append(hn.getErsteAbleitungwert(bd.doubleValue()));
			table.add(sb.toString());
		}
		
	}

	public void format(){
		System.out.println("Berechnung für das Polynom: " + hn.getStringOfPolynom());
		System.out.println("\tArgument\t\tPolynomwert\t\tWert der ersten Ableitung");
		for(int i = 0; i<table.size(); i++){
			System.out.println(table.get(i));
		}
	}
	
}
