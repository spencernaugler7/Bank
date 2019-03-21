// TODO: add functionality to open savings, and checking accounts
// TODO: add functionality to open savings, and checking accounts
public abstract class Account {
    protected static int numAccounts;
    protected double balence;
    protected int aNumber;
    protected String name;

    protected int getNumAccounts(){
        return numAccounts;
    }

    protected int getBalence(){

    }

    protected void deposit(double ammount){
    	balence += ammount;
    }

    protected void widthdraw(double ammount){
    	balence -= ammount;
    }

    protected int getAcNumber(){ return aNumber;}

}
