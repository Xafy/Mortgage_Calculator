public class Main {
    public static void main(String[] args) {
        int principal = (int) Console.readValue("Enter Principal", 1000, 1000000);
        float annualInterestRate = (float) Console.readValue("Enter annual interest rate :", 3, 30);
        byte years = (byte) Console.readValue("Enter Number of years :", 3, 30);

        var calculator = new MortgageCalculator(principal, annualInterestRate, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPayments();
    }

}