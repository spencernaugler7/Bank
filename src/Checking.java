public class Checking extends Account {

    public Checking(double balance, int aNumber, String name)
    {
        super(balance, aNumber, name);
    }

    @Override
    double getInterestRate(double amount)
    {
        if(balance < 10000){
            return 0.02;
        } else {
            return 0.05;
        }
    }

    @Override
    public String toString()
    {
        String type = "Checking";
        return String.format("%-20s%-20s%-20s%-20.2f\n", aNumber, type, name, balance);
    }


}
