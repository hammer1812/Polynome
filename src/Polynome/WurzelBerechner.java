package Polynome;
/**
 * 
 * @author Adrian Fietta
 *
 */
import java.util.Scanner;

public class WurzelBerechner {
/**
 * Mainmethode zur Berechnung von Wurzeln
 * @param args
 */
	public static void main(String[] args) {
		
		boolean exec = true;
		Scanner sc = new Scanner(System.in);
		
		while(exec){
			System.out.println("Geben sie den Radikand der Wurzel ein: ");
			double radikand = sc.nextDouble();
			System.out.println("Geben sie den Exponent der Wurzel ein: ");
			int exponent = sc.nextInt();
			
			Polynom polynom = new Polynom(radikand, exponent);
			Horner hn = new Horner(polynom);
			Newton wurzel = new Newton(hn, 4, radikand, 100);
			
			System.out.println("Die Wurzelnaeherung betraegt: " + wurzel.getNullstelle());
			
			System.out.println("Neue Berechnung durchführen?(y/n)");
			if(sc.next().charAt(0) == 'y')
				exec = true;
			else
				exec = false;
			
		}
		sc.close();
	}

}
