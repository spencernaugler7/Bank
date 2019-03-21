public class Savings extends Account {

    public Savings(double balence, String name){
        numAccounts++;
        super(balence, aNumber, name)
    }

    @Override
    public String toString(){
    	return String.format("Savings\n Account Number: %d\nName: %s\nBalence: %.2f\n", aNumber, name, balence);
    }

}
