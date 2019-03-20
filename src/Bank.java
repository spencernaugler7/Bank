import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//TODO: add functionalilty for a returning customer

public class Bank
{
    // declare scanner for input, and Hashmap for customer PIN's
    private static Scanner console = new Scanner(System.in);
    private static HashMap<Integer, Customer> customers = new HashMap<>();

    public static void main(String[] args)
    {
        System.out.println("Welcome to the national bank of You don't own your money!");
        // main menu loop
        boolean exited = false;
        while(!exited){
            System.out.println("===== Main Menu =====");
            switch(menu()){
                case 1:
                    newAccount();
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Goodbye!");
                    exited = true;
                    break;
            }
        }
    }

    private static int menu(){
        // basic dialog for the menu
        System.out.printf("%-10s\n%-10s\n%-10s",
                "Enter 1 to create a new account",
                "Enter 2 to access an existing account",
                "Enter 3 to exit the program");

        return Integer.parseInt(console.nextLine());
    }


    private static void newAccount(){

        // asks if you are a new customer
        System.out.print("Enter 1 if you are a new Customer, 2 if not: ");
        int choice = Integer.parseInt(console.nextLine());

        // collects info and creates a new account if you are new
        boolean done = false;
        while(!done){
            switch(choice){
                case 1:
                    //collects info for customer creation
                    System.out.print("What is your First name?: ");
                    String fname = console.nextLine().strip();

                    System.out.print("What is your last name?: ");
                    String lname = console.nextLine().strip();

                    System.out.print("Enter a 4 digit PIN to protect your account: ");
                    int pin = Integer.parseInt(console.nextLine());

                    Customer newCustomer = new Customer(fname, lname); // ship data off to Customer class
                    customers.put(pin, newCustomer); // sets up verification
                    customers.get(pin).accountMenu(); //accountMenu is an other loop that has an account menu
                    done = true;
                    break;
                case 2:
                    Set c = customers.keySet();
                    boolean verified = false;
                    while(!verified) {
                        System.out.print("Enter Your pin Number: ");
                        int attempt = Integer.parseInt(console.nextLine());
                        verified = verifyAccount(c, attempt);
                    }
                    done = true;
                    break;
                default:
                    System.out.println("Either you did not enter a number\nor you did not enter 1 or 2");
                    break;
            } // switch ending
        } // while ending
    }// function ending

    private static boolean verifyAccount(Set c, int attempt){

        if (c.contains(attempt))
        {
            System.out.print("Success, Welcome Back " + customers.get(attempt).getName());
            return true;
        } else {
            System.out.print("That didn't work, please try again.\nWe want your money!");
            return false;
        }

    }

}// class ending

