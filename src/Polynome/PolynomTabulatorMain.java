package Polynome;

import java.util.Scanner;

public class PolynomTabulatorMain {

	public static void main(String[] args) {
		//Polynom poly = new Polynom("-1,-1,5.6,700,1,2");
		//System.out.println(poly.toString());
		boolean exec = true;
		Scanner sc = new Scanner(System.in);
		while(exec){
			System.out.println("Geben sie die Koeffizienten eines Polynoms ein (getrennt durch Semikolon: \"a;b;c\"):");
			String argumente = sc.nextLine();
			System.out.println("Rechne mit Werten von: ");
			double wertebereich1 = sc.nextDouble();
			System.out.println("bis: ");
			double wertebereich2 = sc.nextDouble();
			System.out.println("Mit einer Schrittweite von: ");
			double schrittweite = sc.nextDouble();
			
			Horner hn = new Horner(new Polynom(argumente));
			PolynomTabulator polyTab = new PolynomTabulator(hn, wertebereich1, wertebereich2, schrittweite);
			polyTab.format();
			
			System.out.println("Neue Berechnung durchf�hren?(y/n)");
			if(sc.next().charAt(0) == 'y')
				exec = true;
			else
				exec = false;
			
		}
		sc.close();
		
	}

}
