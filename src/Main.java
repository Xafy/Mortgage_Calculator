import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static short MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {
        short numberOfPaymentsMade = 0;


        int principal = (int) readValue("Enter Principal", 1000, 1000000);
        float annualInterestRate = (float) readValue("Enter annual interest rate :", 3, 30);
        byte years = (byte) readValue("Enter Number of years :", 3, 30);

        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double mortgage = calculateMortgage(principal, annualInterestRate, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("_________");
        System.out.println("The mortgage is :" + mortgageFormatted);

        System.out.println("_________");
        System.out.println("payments");
        for (numberOfPaymentsMade =1 ; numberOfPaymentsMade <= numberOfPayments ; numberOfPaymentsMade++){
            double balance = calculateBalance(principal, annualInterestRate, years, numberOfPaymentsMade);
            System.out.println(balance);
        }
    }

    public static  double readValue(String prompt, int min, int max){
        Scanner scanner =new Scanner(System.in);
        float value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between" + min + " and " + max);
        }
        return  value;
    }

    public static  double calculateMortgage(int principal,
                                            float annualInterestRate,
                                            byte years){

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = annualInterestRate / PERCENT / annualInterestRate;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        return  mortgage;
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, int numberOfPaymentsMade){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterestRate = annualInterest / PERCENT / annualInterest;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double remainingLoan = principal *
                (Math.pow(1+monthlyInterestRate,numberOfPayments) - Math.pow(1+monthlyInterestRate,numberOfPaymentsMade))
                / (Math.pow(1+monthlyInterestRate, numberOfPayments) - 1);
        return  remainingLoan;
    }
}