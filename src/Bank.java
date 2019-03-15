import java.util.HashMap;
import java.util.Scanner;

public class Bank {
    // declare scanner for input, and Hashmap for customer PIN's
    private static Scanner console = new Scanner(System.in);
    HashMap<String, Integer> customers = new HashMap<>();

    public static void main(String[] args) {

        boolean exited = false;
        while(!exited){

            switch(menu()){
                case(1):
                    createAccount();
                    break;
                case(2):
                    verifyAccount(pin);
                    break;
                case(3):
                    exited = true;
                    break;
            }
        }
    }

    public Bank(){
        System.out.println("Welcome to The Untrustworthy Bank!\nPlease give us your money!\n\n");
    }

    public static int menu(){
        System.out.printf("%-10s\n%-10s\n%-10s",
                "Enter 1 to create a new account",
                "Enter 2 to access an existing account",
                "Enter 3 to exit the program");

        int response = Integer.parseInt(console.nextLine());

        return response;
    }
}
