import java.util.ArrayList;
import java.util.Scanner;
public class Customer {
    private String first;
    private String last;
    private ArrayList<Savings> savingsAccounts = new ArrayList<>();
    private ArrayList<Checking> checkingAccounts = new ArrayList<>();
    private static Scanner console = new Scanner(System.in);

    public Customer(String fname, String lname){
        this.first = fname;
        this.last = lname;
        newAccount(fname, lname);
    }

    // makes a new account with the name
    private void newAccount(String fname, String lname){

        System.out.println("Hello " + fname + " " + lname);
        boolean test = false;
        while(!test) {
            System.out.println(" 1 to make checking" +
                    "2 to make savings: ");
            int choice = Integer.parseInt(console.nextLine());
            if (choice == 1) {
                System.out.println("Checking Account Maker");
                Savings newSavings = Savings();
                test = done();

            } else if (choice == 2) {
                System.out.println("Savings Account Maker");
                Checking newChecking = Checking();
                test = done();

            } else {
                System.out.println("you either didn't enter a number or you you didn't enter 1 or 2");
            }
        }
    }

    // used in newAccount to test for multiple account creations
    private boolean done(){
        System.out.println("Enter 1 to make another one or 2 to stop");
        int choice = Integer.parseInt(console.nextLine());
        switch(choice){
            case 1: return true;
                break;
            case 2: return false;
                break;
        }
    }

    public String getFirstName(){
        return first;
    }

    public String getLastName(){
        return last;
    }

    // prints off all toString methods of all accounts
    public void listAccounts(){
        // each account will have a public toString method that will have this handled
        System.out.println("Checking Accounts");
        for(Checking checking : checkingAccounts){
            System.out.println(checking);
        }
        System.out.println("Savings Accounts");
        for(Savings savings : savingsAccounts){
            System.out.println(savings);
        }
    }

    public void accountMenu(){

    }
}
