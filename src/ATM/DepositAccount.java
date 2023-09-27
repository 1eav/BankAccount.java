package ATM;

public class DepositAccount extends BankAccount {
    private static int savingsNumber = 0;
    private String accountNumber = super.getAccountNumber() + "-20";

    public DepositAccount(String name, double amountToPut) {
        super(name, amountToPut);
        accountNumber = accountNumber + "-" + Integer.toString(savingsNumber);
    }

    public DepositAccount(DepositAccount oldAccount, double amountToPut) {
        savingsNumber++;
        accountNumber = oldAccount.accountNumber + Integer.toString(savingsNumber);
    }

    public void postInterest() {
        double interestAmount = getAmount() * .12/12;
        double finalAmount = getAmount() + interestAmount;
        setAmount(finalAmount);
    }

    public String getAccountNumber() {
        return accountNumber; }
}