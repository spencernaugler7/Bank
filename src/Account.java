// TODO: add functionality to open savings, and checking accounts
// TODO: add functionality to open savings, and checking accounts
public abstract class Account {

    protected double balance;
    protected int aNumber;
    protected String name;

    public Account(double balance, int aNumber, String name){
        this.balance = balance;
        this.aNumber = aNumber;
        this.name = name;
    }

    protected double getBalance(){
        return balance;
    }

    protected int getAcNumber(){ return aNumber;}

    // used in subclasses to determine interest rates
    abstract double getInterestRate(double amount);

    public void deposit(double amount){
        double interest_rate = getInterestRate(amount);

        double newAmount = amount * (1 + interest_rate);
        balance += newAmount;

        System.out.printf("Success, Amount deposited: %.2f at %%%.0f\n" +
                "New Balance: %.2f\n", amount, interest_rate * 100, newAmount);

    }

    protected void withdraw(double amount){
        if( balance < amount){
            System.out.println("You don't have enough in your account to withdraw that");
        }else{
            double newAmount = balance - amount;
            balance = newAmount;
            System.out.printf("Success you made a withdrawal of %.2f\n" +
                    "New balance: %.2f", amount, newAmount);
        }

    }

}
