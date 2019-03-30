public class Savings extends Account {

    public Savings (double balance, int aNumber, String name)
    {
        super(balance, aNumber, name);
    }

    @Override
    double getInterestRate (double amount)
    {
        if(balance < 10000){
            return 0.04;
        } else {
            return 0.07;
        }
    }

    @Override
    public String toString()
    {
        String type = "Savings";
    	return String.format("%-20s%-20s%-20s%-20.2f\n", aNumber, type, name, balance);
    }

}
