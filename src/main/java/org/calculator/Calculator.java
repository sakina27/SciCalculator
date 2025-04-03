package org.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static double squareRoot(double x) {
        if (x < 0) {
            System.out.println("Error: Square root of a negative number is not defined in real numbers.");
            return Double.NaN;
        }
        return Math.sqrt(x);
    }
    //Trying ngrok
    public static long factorial(int x) {
        if (x < 0) {
            System.out.println("Error: Factorial is only defined for non-negative integers.");
            return -1;
        }
        if (x > 20) {
            System.out.println("Error: Factorial result is too large to compute.");
            return -1;
        }
        long fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }

    public static double naturalLog(double x) {
        if (x <= 0) {
            System.out.println("Error: Logarithm is only defined for positive numbers.");
            return Double.NaN;
        }
        return Math.log(x);
    }

    public static double power(double base, double exponent) {
        if (base == 0 && exponent == 0) {
            System.out.println("Error: 0^0 is undefined.");
            return Double.NaN;
        }
        if (base < 0 && exponent % 1 != 0) {
            System.out.println("Error: Negative base with fractional exponent results in a complex number.");
            return Double.NaN;
        }
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to Start");
        scanner.nextLine();

        while (true) {
            System.out.println("Scientific Calculator:");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln x)");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter number: ");
                        double x = scanner.nextDouble();
                        System.out.println("Result: " + squareRoot(x));
                        break;
                    case 2:
                        System.out.print("Enter integer: ");
                        int n = scanner.nextInt();
                        long factResult = factorial(n);
                        if (factResult != -1)
                            System.out.println("Result: " + factResult);
                        break;
                    case 3:
                        System.out.print("Enter number: ");
                        double y = scanner.nextDouble();
                        System.out.println("Result: " + naturalLog(y));
                        break;
                    case 4:
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exp = scanner.nextDouble();
                        System.out.println("Result: " + power(base, exp));
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
            }
            System.out.println("===========================================================");
        }
    }
}
