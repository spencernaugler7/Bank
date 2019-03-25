import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//TODO: add functionality for a returning customer

public class Bank
{
    // declare scanner for input, and Hashmap for customer PIN's
    private static Scanner console = new Scanner(System.in);
    private static HashMap<Integer, Customer> customers = new HashMap<>();

    private static int menu(){
        // basic dialog for the menu
        System.out.println("===== Main Menu =====");
        System.out.printf("%-10s\n%-10s\n%-10s",
                "Enter 1 to create a new account",
                "Enter 2 to access an existing account",
                "Enter 3 to exit the program");

        return Integer.parseInt(console.nextLine());
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome to the national bank of give us your money!");
        // main menu loop
        while(true){
            switch(menu()){
                case 1:
                    newAccount();
                    break;
                case 2:
                    accessAccount();
                    break;
                case 3:
                    System.out.println("Goodbye! Thanks for your Money!");
                    break;
            }
        }
    }

    private static void accessAccount() {
        Set c = customers.keySet();
        boolean verified = false;
        while(!verified){
            System.out.print("Enter PIN number: ");
            int attempt = Integer.parseInt(console.nextLine());
            verified = verifyAccount(c, attempt);

            if(verified)
                customers.get(attempt).accountMenu();
        }
    }

    private static void newAccount(){
        // main menu for my program
        boolean done = false;
        while(!done){
            // asks if you are a new customer
            System.out.println("Enter 1 if you are a new Customer\n2 if returning\n3 to exit back to menu");
            int choice = Integer.parseInt(console.nextLine());

            switch(choice){
                case 1:
                    newCustomer();
                    break;
                case 2: // if returning customer redirect to the same menu just with pin verification
                    accessAccount();
                    break;
                case 3:
                    done = true;
                    break;
                default:
                    System.err.println("You did not enter 1,2, or 3, or you did not enter a number");
                    break;
            } // switch ending
        } // while ending
    }// function ending

    private static void newCustomer() {
        //collects info for customer creation
        System.out.print("What is your First name?: ");
        String fname = console.nextLine().trim();

        System.out.print("What is your last name?: ");
        String lname = console.nextLine().trim();

        System.out.print("Enter a 4 digit PIN to protect your account: ");
        int pin = Integer.parseInt(console.nextLine());

        Customer newCustomer = new Customer(fname, lname); // ship data off to Customer class
        customers.put(pin, newCustomer); // sets up verification

        customers.get(pin).accountMenu(); //account menu contains all of the account operations
    }

    private static boolean verifyAccount(Set c, int attempt){

        if (c.contains(attempt))
        {
            System.out.print("Success, Welcome Back " + customers.get(attempt).getFName());
            return true;
        } else {
            System.out.print("That didn't work, please try again.\nWe want your money!");
            return false;
        }

    }

}// class ending

