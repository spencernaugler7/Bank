import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Customer {
    private static Scanner console = new Scanner(System.in);

    private String fname;
    private String lname;
    private ArrayList<Account> Accounts = new ArrayList<>();

    public Customer(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }

    private int printMenu(){
        System.out.println("===== "+ fname+"'s User Menu =====");
        System.out.println("1 to make checking\n" +
                "2 to make savings\n" +
                "3 to deposit money into an account\n" +
                "4 to withdraw money from an account\n" +
                "5 to list all accounts\n" +
                "6 to exit back to bank menu");
        return Integer.parseInt(console.nextLine());
    }

    // makes a new account with the name
    public void accountMenu(){
        boolean test = false;
        while(!test) {
            int choice = printMenu();
            switch(choice){
                case 1:
                    newChecking();
                    break;
                case 2:
                    newSavings();
                    break;
                case 3:
                    makeDeposit();
                    break;
                case 4:
                    makeWithdraw();
                    break;
                case 5:
                    listAllAccounts();
                    break;
                case 6:
                    test = true;
                    break;
                default:
                    System.err.println("you either didn't enter a number or you you didn't enter 1 or 2");
                    break;
            }
        }
    }

    private void newChecking() { // make a new checking account
        System.out.print("Enter a name for the account: ");
        String name = console.nextLine();
        System.out.print("Enter an initial deposit (or 0 if you do not want an initial deposit): ");
        double init = Double.parseDouble(console.nextLine());

        // generate rand 5 digit num for account number
        int rand_int = ThreadLocalRandom.current().nextInt(0,99999999);

        // take info and make a new account
        Checking newChecking = new Checking(init, rand_int, name);
        Accounts.add(newChecking);
        printNewAccount("Checking", name, rand_int, init, newChecking.getInterestRate(init));
    }

    private void newSavings(){
        // collect usual info for new account but with initial deposit being higher
        System.out.print("Enter a unique name for the account: ");
        String name = console.nextLine();
        // collect initial deposit that must be greater than $100
        boolean done = false;
        double init = 0;
        while(!done){
            System.out.print("Enter an initial deposit (it must be at least $100): ");
            init = Double.parseDouble(console.nextLine());
            if(init < 100) {
                System.out.println("Nice Try but we can count to 100");
            } else {
                done = true;
            }

        }
        // generate rand 5 digit num for account number
        int rand_int = ThreadLocalRandom.current().nextInt(0,99999999);

        // take info and make a new account
        Savings newSavings = new Savings(init, rand_int, name);
        Accounts.add(newSavings);
        printNewAccount("Savings", name, rand_int, init, newSavings.getInterestRate(init));
    }


    private void printNewAccount(String type, String name, int rand_int, double balance, double intrest_rate){
        System.out.printf("Success new %s account %s was created\n" +
                "Account Number: %d\n" +
                "Initial Balance: %.0f\n" +
                "Interest Rate %%%.0f\n", type, name, rand_int, balance, intrest_rate * 100);
    }


    private void makeWithdraw() {
        if(noAccounts()){
            System.out.println("You don't have any accounts created");
        }else{
            int AccountNumber = getAccountNum();
            int index = searchForAccount(AccountNumber);
            if(index != -1) {
                System.out.print("Enter the amount to Withdraw: ");
                double deposit = Double.parseDouble(console.nextLine());
                Accounts.get(index).withdraw(deposit);
            }else{
                System.out.println("You did not enter the correct Account Number" +
                        "or that account does not exist");
            }
        }
    }


    private void makeDeposit() {
        if (noAccounts()) {
            System.out.println("You don't have any accounts created");
        } else {
            int AccountNumber = getAccountNum();
            int index = searchForAccount(AccountNumber);
            if (index != -1) {
                System.out.print("Enter the amount to Deposit: ");
                double deposit = Double.parseDouble(console.nextLine());
                Accounts.get(index).deposit(deposit);
            } else {
                System.out.println("You did not enter the correct Account Number" +
                        "or that account does not exist");
            }
        }
    }

    private int getAccountNum() {
        System.out.print("Enter the account number: ");
        return Integer.parseInt(console.nextLine());
    }


    private boolean noAccounts(){
        return Accounts.size() == 0;
    }

    /* used in Bank class to check for name
     looks through accounts arraylist, for the account number entered, if found returns the index of that account
     if no account exists then it returns -1*/
    private int searchForAccount(int acNum){
        for(int i = 0; i < Accounts.size(); i++){
            if (Accounts.get(i).getAcNumber() == acNum){
                return i;
            }
        }
        // if the search failed return -1
        return -1;
    }


    public String getFName(){
        return fname.concat(" ").concat(lname);
    }

    // prints off all toString methods of all accounts
    public void listAllAccounts(){
        // each account will have a public toString method that will have this handled
        if(noAccounts()){
            System.out.println("There are no accounts created");
        } else {
            System.out.println("===== Accounts =====");// accounts are listed int the arraylist
            for(Object account : Accounts){
                System.out.println(account);
            }
        }
    }
}
