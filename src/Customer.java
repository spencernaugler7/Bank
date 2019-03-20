import java.util.ArrayList;
import java.util.Scanner;

// TODO: finish editing done() so while loop will exit properly
// TODO: make an account menu for an existing customer that wants to access their account
public class Customer {
    private String fname;
    private String lname;
    private ArrayList<Savings> savingsAccounts = new ArrayList<>();
    private ArrayList<Checking> checkingAccounts = new ArrayList<>();
    private static Scanner console = new Scanner(System.in);

    public Customer(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
        newAccount(fname, lname);
    }

    // makes a new account with the name
    private void newAccount(String fname, String lname){
        System.out.println("Hello " + fname + " " + lname);
        boolean test = false;
        while(!test) {
            System.out.println("=====New Account Maker=====");
            System.out.println(" 1 to make checking" +
                    "2 to make savings: ");
            int choice = Integer.parseInt(console.nextLine());

            switch(choice){
                case 1: 
                    Savings newSavings = new Savings();
                    savingsAccounts.add(newSavings);
                    test = done();
                    break;
                case 2:
                    Checking newChecking = new Checking();
                    checkingAccounts.add(newChecking);
                    test = done();
                    break;
                default:
                    System.out.println("you either didn't enter a number or you you didn't enter 1 or 2");
                    break;
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
            default:
                System.out.println("Either you did not enter 1 or 2 or you did not enter a number");
                return false;
                break;
        }
    }

    // used in Bank class to check for name
    public String getName(){
        return fname.concat(" ").concat(lname);
    }

    // prints off all toString methods of all accounts
    public void listAccounts(){
        // each account will have a public toString method that will have this handled
        System.out.println("Checking Accounts");// checking acounts
        for(Checking checking : checkingAccounts){
            System.out.println(checking);
        }
        System.out.println("Savings Accounts"); // savings accounts
        for(Savings savings : savingsAccounts){
            System.out.println(savings);
        }
    }

    // for an existing customer to access their account
    public void accountMenu(){

    }
}
