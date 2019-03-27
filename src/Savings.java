public class Savings extends Account {

    public Savings(double balance, int aNumber, String name) {
        super(balance, aNumber, name);
    }

    @Override
    double getInterestRate(double amount){
        if(balance < 10000){
            return 0.04;
        }else{
            return 0.07;
        }
    }

    @Override
    public String toString(){
    	return String.format("Savings\nAccount Number: %d\nName: %s\nBalance: %.2f\n", aNumber, name, balance);
    }

}
