import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Bank {
    // declare scanner for input, and Hashmap for customer PIN's
    private static Scanner console = new Scanner(System.in);
    private static HashMap<Integer, Customer> customers = new HashMap<>();

    public void menu(){
        System.out.println("Welcome to the national bank of give us your money!");

        // main menu loop
        boolean done = false;
        while(!done){
            System.out.println("===== Main Menu =====");
            System.out.printf("%-10s\n%-10s\n%-10s",
                    "Enter 1 to create a new user",
                    "Enter 2 to access an existing user",
                    "Enter 3 to exit the program\n");
            int response = Integer.parseInt(console.nextLine());
            switch(response){
                case 1:
                    newCustomer();
                    break;
                case 2:
                    accessAccount();
                    break;
                case 3:
                    System.out.println("Goodbye! Thanks for your Money!");
                    done = true;
                    break;
                default:
                    System.out.println("You didn't enter 1, 2, or 3");
                    break;
            }
        }
    }


    private void accessAccount() {
        Set c = customers.keySet();
        boolean verified = false;
        if(noCustomers()) {
            System.out.println("There there are no users created!");
        } else {
            while (!verified) {
                System.out.print("Enter PIN number: ");
                int attempt = Integer.parseInt(console.nextLine());
                verified = verifyAccount(c, attempt);
                if (verified)
                    customers.get(attempt).accountMenu();
            }
        }
    }


    private boolean noCustomers(){
        return customers.size() == 0;
    }


    private void newCustomer() {
        //collects info for customer creation
        System.out.print("What is your First name?: ");
        String fname = console.nextLine().trim();

        System.out.print("What is your last name?: ");
        String lname = console.nextLine().trim();

        System.out.print("Enter a 4 digit PIN to protect your account: ");
        int pin = Integer.parseInt(console.nextLine());

        Customer newCustomer = new Customer(fname, lname); // ship data off to Customer class
        customers.put(pin, newCustomer); // sets up verification
        System.out.println("Success User account created\nput 2 in the bank"+
            "menu and enter your pin to access your portal");
    }


    private boolean verifyAccount(Set c, int attempt){

        if (c.contains(attempt))
        {
            System.out.print("Success, Welcome Back " + customers.get(attempt).getFName() +"\n" );
            return true;
        } else {
            System.out.print("That didn't work, please try again. 1We want your money!");
            return false;
        }

    }

}// class ending

