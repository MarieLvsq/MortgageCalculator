package Program;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.print("Principal:");
		Scanner scanner = new Scanner(System.in);
		int principal = scanner.nextInt();
		System.out.print("Annual Interest:");
		double monthlyInterest = scanner.nextDouble()/1200;
		System.out.print("Period (Years):");
		int period = scanner.nextInt() *12;
		double interestRatePow = Math.pow((1+monthlyInterest), period);
		double resultDouble = principal * ((monthlyInterest*interestRatePow)/(interestRatePow-1));
		String result = NumberFormat.getCurrencyInstance().format(resultDouble);
		System.out.println("Mortgage:" + result);
	}

}
