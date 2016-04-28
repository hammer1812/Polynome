package Polynome;

import java.util.Scanner;

public class NullstellenBerechner {

	public static void main(String[] args) {
		boolean exec = true;
		while(exec){
			Scanner sc = new Scanner(System.in);
			System.out.println("Geben sie die Koeffizienten eines Polynoms ein (getrennt durch Semikolon: \"a;b;c\"):");
			String argumente = sc.next();
			Newton nt;
			RegulaFalsi rf;
			Polynom polynom = new Polynom(argumente);
			Horner hn = new Horner(polynom);
			
			System.out.println("Welches Verfahren soll für das Polynom " + polynom.toString() + " angewendet werden? ");
			System.out.println("Newton (n) oder Regula Falsi (f)");
			char decide = sc.next().charAt(0);
			if(decide == 'n'){
				System.out.println("Geben sie die Genauigkeit des Verfahrens an in Form von 10^-x:");
				int genauigkeit = sc.nextInt();
				System.out.println("Geben sie die Anfangsnaeherung an:");
				double anfangsnaeherung = sc.nextDouble();
				System.out.println("Geben sie die Maximalzahl der Iterationen an:");
				int maxIterationen = sc.nextInt();
				
				nt = new Newton(hn, genauigkeit, anfangsnaeherung, maxIterationen);
				
				System.out.println("Die Naehrung der Nullstelle betraegt: " + nt.getNullstelle());
				System.out.println("und wurde nach " + nt.getAnzahlIterationen() + " Iterationen ermittelt");
			}
			else if(decide == 'f'){
				System.out.println("Geben sie die Genauigkeit des Verfahrens an in Form von 10^-x:");
				int genauigkeit = sc.nextInt();
				System.out.println("Geben sie die erste Anfangsnaeherung an:");
				double anfangsnaeherung0 = sc.nextDouble();
				System.out.println("Geben sie die zweite Anfangsnaeherung an:");
				double anfangsnaeherung1 = sc.nextDouble();
				System.out.println("Geben sie die Maximalzahl der Iterationen an:");
				int maxIterationen = sc.nextInt();
				
				rf = new RegulaFalsi(hn, genauigkeit, anfangsnaeherung0, anfangsnaeherung1, maxIterationen);

				System.out.println("Die Naehrung der Nullstelle betraegt: " + rf.getNullstelle());
				System.out.println("und wurde nach " + rf.getAnzahlIterationen() + " Iterationen ermittelt");
			}
			else{
				sc.close();
				throw new IllegalArgumentException("kein vorhandenes Verfahren ausgewaehlt");
			}
			System.out.println("Neue Berechnung durchführen?(y/n)");
			char repeat = sc.next().charAt(0);
			if(repeat == 'y')
				exec = true;
			else
				exec = false;
			sc.close();
		}
		
	}

}
