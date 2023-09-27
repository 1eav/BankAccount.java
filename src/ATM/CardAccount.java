package ATM;

public class CardAccount extends BankAccount {
    private double commission = 100;
    private String accountNumber = getAccountNumber() + "-10";

    public CardAccount(String name, double amountToPut) {
        super(name, amountToPut);
        setAccountNumber(accountNumber);
    }

    public boolean take(double amountToPut) {
        double finalAmount = amountToPut + commission;
        super.take(finalAmount);
        boolean finish = true;
        return finish;
    }
}