package codesoft.project.atminterface;
import java.util.*;
public class ATM implements Operationatm{
    private UserAccount account;

    // Constructor to connect ATM with bank account
    public ATM(UserAccount account) {
        this.account = account;
    }


    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }


    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            account.deposit(amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }


    @Override
    public void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }


}
