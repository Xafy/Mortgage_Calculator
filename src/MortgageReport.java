import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currencyInstance;
    private  MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currencyInstance = NumberFormat.getCurrencyInstance();
    }


    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currencyInstance.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("_________");
        System.out.println("The mortgage is :" + mortgageFormatted);
    }

    public void printPayments() {
        System.out.println("_________");
        System.out.println("Payments");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currencyInstance.format(balance));
    }
}
