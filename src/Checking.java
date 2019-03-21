public class Checking extends Account {

    public Checking(double balence, String name){
        numAccounts++;
        super(balence, aNumber, name)
    }

    @Override
    public String toString(){
    	return String.format("Savings\n Account Number: %d\nName: %s\nBalence: %.2f\n", aNumber, name, balence);
    }
}
