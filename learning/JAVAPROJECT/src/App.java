// Project: Mortgate Calculator

import java.text.NumberFormat;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        // define variables
        int principal =  0;
        float monthlyInterest = 0;
        int numberOfPayment = 0;

        Scanner scanner = new Scanner(System.in);
        
        while (true){
            System.out.print("Principal ($1k - $lM): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000){
                break;
            }
            System.out.println("Enter value between 1000 and 1000000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annaulInterest = scanner.nextFloat();
            if (annaulInterest >= 1 && annaulInterest <= 30) {
                monthlyInterest = annaulInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while (true){
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 39){
                numberOfPayment = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage =  principal 
        * (monthlyInterest * (Math.pow(1+monthlyInterest, numberOfPayment))) 
        / (Math.pow(1+monthlyInterest, numberOfPayment) - 1);


        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}