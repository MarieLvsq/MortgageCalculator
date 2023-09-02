package Program;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Principal (1K€ - 1M€):");
		int principal = scanner.nextInt();

		while (principal < 1000 || principal > 1000000) {
			System.out.print("Enter a number between 1,000 and 1,000,000:");
			principal = scanner.nextInt();
			if (principal >= 1000 && principal <= 1000000)
				break;
		}

		System.out.print("Annual Interest Rate:");
		double annualInterest = scanner.nextDouble();
		while (annualInterest == 0 || annualInterest > 30) {
			System.out.print("Enter a number greater than 0 and less than or equal to 30 :");
			annualInterest = scanner.nextDouble();
			if (annualInterest >= 1 && annualInterest <= 30) {
				break;
			}
		}

		double monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;

		System.out.print("Period (Years):");
		int periodYears = scanner.nextInt();
		while (periodYears < 1 || periodYears > 30) {
			System.out.println("Enter a number between 1 and 30 :");
			periodYears = scanner.nextInt();
			if (periodYears >= 1 && periodYears <= 30) {
				break;
			}
		}

		int periodMonths = periodYears * MONTHS_IN_YEAR;

		double interestRatePow = Math.pow((1 + monthlyInterest), periodMonths);
		double resultDouble = principal * ((monthlyInterest * interestRatePow) / (interestRatePow - 1));

		String mortgage = NumberFormat.getCurrencyInstance().format(resultDouble);
		System.out.println("Mortgage:" + mortgage);

	}

}
