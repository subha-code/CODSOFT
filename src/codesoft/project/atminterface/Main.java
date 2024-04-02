package codesoft.project.atminterface;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        UserAccount account = new UserAccount(1000.0); // add 1000 Rs new account

        ATM atm = new ATM(account);
        int choice;
        double amount;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    amount = scanner.nextDouble();
                    atm.withdraw(amount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    atm.deposit(amount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

    }
}
