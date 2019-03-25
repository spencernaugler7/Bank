public class Savings extends Account {

    public Savings(double balence, String name){
        numAccounts++;
        super(balence, aNumber, name);
    }

    @Override
    public String toString(){
    	return String.format("Savings\nAccount Number: %d\nName: %s\nBalance: %.2f\n", aNumber, name, balance);
    }

}
