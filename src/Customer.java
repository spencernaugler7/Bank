import java.util.ArrayList;
import java.util.Scanner;
// TODO: finish withdrawing and deposition functionality

public class Customer {
    private String fname;
    private String lname;
    private ArrayList<Account> Accounts = new ArrayList<>();
    private static Scanner console = new Scanner(System.in);

    public Customer(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }

    // makes a new account with the name
    public void accountMenu(){
        System.out.println("Hello " + fname + " " + lname);
        boolean test = false;
        while(!test) {
            System.out.println("===== "+ fname+"'s Account Menu =====");
            System.out.println(" 1 to make checking\n" +
                            "2 to make savings\n" +
                            "3 to deposit money into an account\n" +
                            "4 to withdraw money from an account\n" +
                            "5 to list all accounts" +
                            "6 to exit back to bank menu");
            int choice = Integer.parseInt(console.nextLine());

            switch(choice){
                case 1:

                case 2:

                case 3:
                    if(!noAccounts()) {
                        int aNum = getAcInput();
                        int search = searchForAccount(aNum);
                        if(search == -1){
                            System.out.println("That account doesn't exits");
                            break;
                        }else{
                            System.out.print("Enter the amount you would like to deposit: ");
                            double amount = Double.parseDouble(console.nextLine());
                            Accounts.get(search).deposit(amount);
                        }
                    }else{
                        System.out.println("you don't have any savings or checking accounts");
                        break;
                    }

                case 4:
                    int accountIndex
                    break;
                case 5:
                    listAllAccounts();
                case 6:
                    test = true;
                    break;
                default:
                    System.out.println("you either didn't enter a number or you you didn't enter 1 or 2");
                    break;
            }
        }
    }

    private boolean noAccounts(){
        if(Accounts.size() == 0){
            return true;
        }
        return false;
    }

    private int getAcInput(){
        System.out.print("Enter the account number");
        return Integer.parseInt(console.nextLine());
    }


    // used in Bank class to check for name
    public String getFName(){
        return fname.concat(" ").concat(lname);
    }

    // returns index of an account in the savings list
    private int searchForAccount(int acNum){
        for(int i = 0; i < Accounts.size(); i++){
            if (Accounts.get(i).getAcNumber() == acNum){
                return i;
            }
        }
        // if the search failed return -1
        return -1;
    }

    // returns the number of accounts in total
    private int getNumAccounts(){ return Account.getNumAccounts();}

    // prints off all toString methods of all accounts
    public void listAllAccounts(){
        // each account will have a public toString method that will have this handled

        System.out.println("Checking Accounts");// accounts
        for(Object account : Accounts){
            System.out.println(account);
        }
    }
}
