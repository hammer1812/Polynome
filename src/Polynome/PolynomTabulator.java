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
			StringBuilder sb = new StringBuilder();
			BigDecimal bd = new BigDecimal(wertebereich1 + schrittweite*n);
			bd = bd.setScale(1, RoundingMode.HALF_UP);
			//sb.append(bd.doubleValue());
			//sb.append("\t\t");
			sb.append(String.format("%1$-4f", bd.doubleValue()));
			//sb.append(hn.getFunktionswert(bd.doubleValue()));
			sb.append("\t");
			sb.append(String.format("%1$-7f", hn.getFunktionswert(bd.doubleValue())));
			sb.append("\t");
			//sb.append(hn.getErsteAbleitungwert(bd.doubleValue()));
			sb.append(String.format("%1$-7f", hn.getErsteAbleitungwert(bd.doubleValue())));
			sb.append("\n");
			table.add(sb.toString());
		}
		
	}

	public void format(){
		StringBuilder sb = new StringBuilder();
		System.out.println("Berechnung für das Polynom: " + hn.getStringOfPolynom() + "\n");
		System.out.println("Argument\tPolynomwert\tWert der ersten Ableitung");
		for(int i = 0; i<table.size(); i++){
			//System.out.println(table.get(i));
			sb.append(table.get(i));
			
		}
		System.out.println(sb.toString());
	}
	
}
