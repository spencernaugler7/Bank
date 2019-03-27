public class Checking extends Account {

    public Checking(double balance, int aNumber, String name){
        super(balance, aNumber, name);
    }

    @Override
    double getInterestRate(double amount){
        if(balance < 10000){
            return 0.02;
        }else{
            return 0.05;
        }
    }

    @Override
    public String toString(){
    	return String.format("Checking \nAccount Number: %d\nName: %s\nBalance: %.2f\n", aNumber, name, balance);
    }


}
