import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class AccountService {

    public BankAccount findAccountByUsername(Scanner scanner, LinkedList<BankAccount> accounts) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        for (BankAccount account : accounts) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    public void depositMoney(Scanner scanner, BankAccount account, Stack<String> transactionHistory) {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        account.deposit(amount);

        String transaction = "Deposit " + amount + " to " + account.getUsername();
        transactionHistory.push(transaction);

        System.out.printf("New balance: %.2f%n", account.getBalance());
    }

    public void withdrawMoney(Scanner scanner, BankAccount account, Stack<String> transactionHistory) {
        System.out.print("Enter withdraw amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount > account.getBalance()) {
            System.out.println("Not enough balance.");
        } else {
            account.withdraw(amount);

            String transaction = "Withdraw " + amount + " from " + account.getUsername();
            transactionHistory.push(transaction);

            System.out.printf("New balance: %.2f%n", account.getBalance());
        }
    }

    public void showBalance(BankAccount account) {
        System.out.printf("Balance: %.2f%n", account.getBalance());
    }

    public void showAllAccounts(LinkedList<BankAccount> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            System.out.println("Accounts List:");
            for (int i = 0; i < accounts.size(); i++) {
                System.out.println((i + 1) + ". " + accounts.get(i));
            }
        }
    }
}