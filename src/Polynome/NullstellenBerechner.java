package Polynome;

import java.util.Scanner;

public class NullstellenBerechner {

	public static void main(String[] args) {
		boolean exec = true;
		Scanner sc = new Scanner(System.in);
		while(exec){
			System.out.println("Geben sie die Koeffizienten eines Polynoms ein (getrennt durch Semikolon: \"a;b;c\"):");
			String argumente = sc.nextLine();
			
			Horner hn = new Horner(new Polynom(argumente));
			
			System.out.println("Neue Berechnung durchführen?(y/n)");
			if(sc.next().charAt(0) == 'y')
				exec = true;
			else
				exec = false;
			
		}
		sc.close();
	}

}
