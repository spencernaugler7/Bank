import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Bank {
    // declare scanner for input, and Hashmap for customer PIN's
    private static Scanner console = new Scanner(System.in);
    private static HashMap<Integer, String> customers = new HashMap<>();

    public static void main(String[] args) {

        boolean exited = false;
        while(!exited){

            switch(menu()){
                case(1):
                    createAccount();
                    break;
                case(2):
                    accessAccount(pin, number);
                    break;
                case(3):
                    System.out.println("Goodbye!");
                    exited = true;
                    break;
            }
        }
    }


    public Bank(){
        // Friendly Greeting
        System.out.println("Welcome to The Untrustworthy Bank!\nPlease give us your money!\n\n");
    }


    private static int menu(){
        // basic dialog for the menu
        System.out.printf("%-10s\n%-10s\n%-10s",
                "Enter 1 to create a new account",
                "Enter 2 to access an existing account",
                "Enter 3 to exit the program");

        int response = Integer.parseInt(console.nextLine());

        return response;
    }


    private static void createAccount(){
        // asks if you are a new customer
        System.out.print("Enter 1 if you are a new Customer, 2 if not: ");
        int choice = Integer.parseInt(console.nextLine());

        // collects info and creates a new account if you are new
        if(choice == 1){
            System.out.print("What is your First name?: ");
            String fname = console.nextLine().strip();

            System.out.print("What is your last name?: ");
            String lname = console.nextLine().strip();

            System.out.print("Enter a 4 digit PIN to protect your account: ");
            int pin = Integer.parseInt(console.nextLine());

            // set up pin access for new customer
            String fullname = fname.concat(" ").concat(lname);
            customers.put(pin, fullname);

            // ship data off to Customer class

        }

        // asks for pin if you are not new then prints message
        if(choice == 2){
            System.out.print("Enter Your pin Number: ");
            int attempt = Integer.parseInt(console.nextLine());

            Set c = customers.keySet();
            boolean success = false;

            while(!success) {
                if (c.contains(attempt)) {
                    success = true;
                    System.out.print("Welcome Back " + customers.get(attempt));
                    //TODO: add operation if exists
                } else {
                    System.out.print("That didn't work try again!");
                }
            }
        }
    }

    
}
