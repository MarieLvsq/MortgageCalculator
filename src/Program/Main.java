package Program;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int principal = (int) readNumber("Principal: ", 1000, 100000);
		double annualInterest = (float) readNumber("Annual Interest  Rate: ", 1, 30);
		byte periodYears = (byte) readNumber("Period Years: ", 1, 30);
		
		double mortgage = calculateMortgage(principal, annualInterest, periodYears);

		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage:" + mortgageFormatted);

	}

	public static double readNumber(String prompt, double min, double max) {
		Scanner scanner = new Scanner(System.in);
		double value;
		while (true) {
			System.out.println(prompt);
			value = scanner.nextFloat();
			if (value >= min && value <=max)
				break;
			System.out.println("Enter a value between " + min + "and " + max);
		}
		return value;
	}

	public static double calculateMortgage(int principal, double annualInterest, byte years) {

		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;

		short periodMonths = (short) (years * MONTHS_IN_YEAR);
		double monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;

		// Mortgage calculation
		double interestRatePow = Math.pow((1 + monthlyInterest), periodMonths);
		double mortgage = principal * ((monthlyInterest * interestRatePow) / (interestRatePow - 1));

		return mortgage;
	}

}
