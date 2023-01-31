public class MortgageCalculator {
    private final static short MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private  int principal;
    private float annualInterest;
    private byte years;
    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }
    public double calculateMortgage() {
        float monthlyInterestRate = getMonthlyInterestRate();
        short numberOfPayments = getNumberOfPayments();
        double mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        return mortgage;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        short numberOfPayments = getNumberOfPayments();
        double remainingLoan = principal *
                (Math.pow(1 + getMonthlyInterestRate(), numberOfPayments) - Math.pow(1 + getMonthlyInterestRate(), numberOfPaymentsMade))
                / (Math.pow(1 + getMonthlyInterestRate(), numberOfPayments) - 1);
        return remainingLoan;
    }
    public double[] getRemainingBalances(){
        double[] balances = new double[getNumberOfPayments()];
        for (short numberOfPaymentsMade = 1; numberOfPaymentsMade <= getNumberOfPayments(); numberOfPaymentsMade++) {
            balances[numberOfPaymentsMade - 1] = calculateBalance(numberOfPaymentsMade);
        }
        return balances;
    }

    private float getMonthlyInterestRate() {
        return annualInterest / PERCENT / annualInterest;
    }
    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }
}
