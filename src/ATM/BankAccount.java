package ATM;

public class BankAccount {
    protected static int numberOfAccounts = 101001;
    private double amount;
    private String owner;
    private String accountNumber;

    public BankAccount() {
        amount = 0;
        accountNumber = numberOfAccounts + "";
        numberOfAccounts++;
    }

    public BankAccount(String name, double amountToPut) {
        owner = name;
        amount = amountToPut;
        accountNumber = numberOfAccounts + "";
        numberOfAccounts++;
    }

    public BankAccount(BankAccount oldAccount, double amountToPut) {
        owner = oldAccount.owner;
        amount = amountToPut;
        accountNumber = oldAccount.accountNumber;
    }

    public void put(double amountToPut) {
        amount = amount + amountToPut;
    }

    public boolean take(double amountToPut) {
        boolean finish = true;
        if (amountToPut <= amount) {
            amount = amount - amountToPut;
        } else {
            finish = false;
        }
        return finish;
    }

    public double getAmount() {
        return amount;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAmount(double newAmount) {
        amount = newAmount;
    }

    public void setAccountNumber(String newAccountNumber) {
        accountNumber = newAccountNumber;
    }
}