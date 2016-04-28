package Polynome;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * 
 * @author Philip Förster
 *
 */
public class PolynomTabulator {
	/**
	 * Tabelle mit Argument, Polynomwert in Abhängigkeit von x, Wert der ersten Ableitung in Abhängigkeit von x
	 */
	private String table;
	/**
	 * Objekt Horner um Funktionalitäten aus der Klasse Horner zur Verfügung zu stellen
	 */
	private Horner hn;
	/**
	 * Konstruktor
	 * 
	 * formatiert Parameter zu einer Tabelle
	 * @param hn Objekt um auf Funktionswerte eines Polynoms zugreifen zu können
	 * @param wertebereich1 Startwert für den Funktionswerte tabelliert werden sollen
	 * @param wertebereich2 Endwert für den Funktionswerte tabelliert werden sollen
	 * @param schrittweite Schrittweite in welcher Funktionswerte tabelliert werden sollen
	 */
	public PolynomTabulator(Horner hn, double wertebereich1, double wertebereich2, double schrittweite){
		this.hn = hn;
		double ende = Math.abs(wertebereich1-wertebereich2)/schrittweite;
		StringBuilder sb = new StringBuilder();
		for(int n = 0; n <= ende; n++){
			
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
			
		}
		table = sb.toString();
	}
	/**
	 * gibt eine Tabelle in System.out aus
	 */
	public void format(){
		System.out.println("Berechnung für das Polynom: " + hn.getStringOfPolynom() + "\n");
		System.out.println("Argument\tPolynomwert\tWert der ersten Ableitung");
		System.out.println(table);
	}
	
}
