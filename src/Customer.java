import java.util.ArrayList;

public class Customer {
    private String first;
    private String last;
    private ArrayList<Savings> savingsAccounts = new ArrayList<>();
    private ArrayList<Checking> checkingAccounts = new ArrayList<>();

    public Customer(String fname, String lname){
        this.first = fname;
        this.last = lname;
    }

    public String getFirstName(){
        return first;
    }

    public String getLastName(){
        return last;
    }

    public void listAccounts(){
        // each account will have a public toString method that will have this handled
        for(int i = 0; i < savingsAccounts.size(); i++){
            System.out.println(savingsAccounts.get(i));
        }
        for(int i = 0; i < checkingAccounts.size(); i++){
            System.out.println(checkingAccounts.get(i));
        }
    }

    public void accessAccount(int acNumber){
        
    }

    private int accessAccountMenu(){

    }
}
