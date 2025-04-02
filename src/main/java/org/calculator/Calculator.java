package org.calculator;

import java.util.Scanner;

public class Calculator {
    public static double squareRoot(double x) {
        return Math.sqrt(x);
    }

    public static long factorial(int x) {
        if (x == 0) return 1;
        long fact = 1;
        for (int i = 1; i <= x; i++) fact *= i;
        return fact;
    }

    public static double naturalLog(double x) {
        return Math.log(x);
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Reiterate
        //loop
        while(true) {
            System.out.println(" Press Enter to Start");
            scanner.nextLine();
            System.out.println("Scientific Calculator:");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln x)");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
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
                    System.out.println("Result: " + factorial(n));
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
                    System.out.print("Exiting...\n");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }

        }
    }
}
