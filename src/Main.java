import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int principal = (int) readValue("Enter Principal", 1000, 1000000);
        float annualInterestRate = (float) readValue("Enter annual interest rate :", 3, 30)
        byte years = (byte) readValue("Enter Number of years :", 3, 30);

        double mortgage = calculateMortgage(principal, annualInterestRate, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("The mortage is :" + mortgageFormatted);
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
}