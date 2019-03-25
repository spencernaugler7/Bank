// TODO: add functionality to open savings, and checking accounts
// TODO: add functionality to open savings, and checking accounts
public abstract class Account {
    protected static int numAccounts;
    protected double balance;
    protected int aNumber;
    protected String name;

    protected static int getNumAccounts(){
        return numAccounts;
    }

    protected int getBalance(){

    }

    protected void deposit(double amount){
    	balance += amount;
    }

    protected void widthdraw(double amount){
    	balance -= amount;
    }

    protected int getAcNumber(){ return aNumber;}

}
