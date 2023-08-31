package Program;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		byte MONTHS_IN_YEAR = 12;
		byte PERCENT = 100;
		System.out.print("Principal:");
		Scanner scanner = new Scanner(System.in);
		int principal = scanner.nextInt();
		System.out.print("Annual Interest:");
		double monthlyInterest = scanner.nextDouble()/MONTHS_IN_YEAR/PERCENT;
		System.out.print("Period (Years):");
		int period = scanner.nextInt() *MONTHS_IN_YEAR;
		double interestRatePow = Math.pow((1+monthlyInterest), period);
		double resultDouble = principal * ((monthlyInterest*interestRatePow)/(interestRatePow-1));
		String mortgage = NumberFormat.getCurrencyInstance().format(resultDouble);
		System.out.println("Mortgage:" + mortgage);
	}

}
