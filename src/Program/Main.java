package Program;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Principal
		System.out.print("Principal (1K€ - 1M€):");
		int principal = scanner.nextInt();

		while (principal < 1000 || principal > 1000000) {
			System.out.print("Enter a number between 1,000 and 1,000,000:");
			principal = scanner.nextInt();
			if (principal >= 1000 && principal <= 1000000)
				break;
		}

		// Annual Interest
		System.out.print("Annual Interest Rate:");
		double annualInterest = scanner.nextDouble();

		while (annualInterest == 0 || annualInterest > 30) {
			System.out.print("Enter a number greater than 0 and less than or equal to 30 :");
			annualInterest = scanner.nextDouble();
			if (annualInterest >= 1 && annualInterest <= 30) {
				break;
			}
		}

		// Period
		System.out.print("Period (Years):");
		byte periodYears = scanner.nextByte();

		while (periodYears < 1 || periodYears > 30) {
			System.out.println("Enter a number between 1 and 30 :");
			periodYears = scanner.nextByte();
			if (periodYears >= 1 && periodYears <= 30) {
				break;
			}
		}

		double mortgage = calculateMortgage(principal, annualInterest, periodYears);
		
		// Formatting mortgage result
		String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
		System.out.println("Mortgage:" + mortgageFormatted);

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
