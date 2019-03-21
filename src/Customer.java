import java.util.ArrayList;
import java.util.Scanner;
// TODO: finish widthdrawing and deposition functionality

public class Customer {
    private String fname;
    private String lname;
    private ArrayList<Savings> savingsAccounts = new ArrayList<>();
    private ArrayList<Checking> checkingAccounts = new ArrayList<>();
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
                    "5 to exit back to bank menu");
            int choice = Integer.parseInt(console.nextLine());

            switch(choice){
                case 1:
                    Savings newSavings = new Savings();
                    savingsAccounts.add(newSavings);
                    break;
                case 2:
                    Checking newChecking = new Checking();
                    checkingAccounts.add(newChecking);
                    break;
                case 3:
                    if(savingsAccounts.size() == 0 && checkingAccounts.size() == 0){
                        System.out.println("you don't have any savings  or checking accounts");
                        break;
                    }
                    System.out.print("Enter the account number: ")
                    int acTest = Integer.parseInt(console.nextLine());

                case 4:
                    System.out.println("Enter the account number you would like to draw from");
                    int acInput = Integer.parseInt(console.nextLine());
                    savIndex = searchForSavAccount(acInput);
                    checkIndex = searchForCheckAccount(acInput);

                    if(savIndex )
                case 5:
                    test = true;
                    break;
                default:
                    System.out.println("you either didn't enter a number or you you didn't enter 1 or 2");
                    break;
            }
        }
    }


    // used in Bank class to check for name
    public String getFName(){
        return fname.concat(" ").concat(lname);
    }

    // returns index of an account in the savings list
    private int searchForSavAccount(int acNum){
        int count = 0;
        for(int i = 0; i < savingsAccounts.size(); i++){
            if (savingsAccounts.get(i).getAcNumber() == acNum){
                return i;
            }
        }
        // if the search failed return -1
        return -1;
    }

    // same as previous but searches checking accounts instead of savings accounts
    private int searchForCheckAccount(int acNum){
        int count = 0;
        for(int i = 0; i < checkingAccounts.size(); i++){
            if (checkingAccounts.get(i).getAcNumber() == acNum){
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
        System.out.println("Checking Accounts");// checking acounts
        for(Checking checking : checkingAccounts){
            System.out.println(checking);
        }
        System.out.println("Savings Accounts"); // savings accounts
        for(Savings savings : savingsAccounts){
            System.out.println(savings);
        }
    }
}
