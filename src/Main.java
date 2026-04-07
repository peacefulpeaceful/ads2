import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<BankAccount> accounts = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter data for account " + (i + 1));

            System.out.print("Account number: ");
            int accountNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();

            BankAccount account = new BankAccount(accountNumber, username, balance);
            accounts.add(account);

            System.out.println("Account added successfully.");
            System.out.println();
        }

        System.out.println("Accounts List:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i));
        }

        System.out.println();
        System.out.print("Enter username: ");
        String searchName = scanner.nextLine();

        BankAccount foundAccount = null;

        for (BankAccount account : accounts) {
            if (account.getUsername().equalsIgnoreCase(searchName)) {
                foundAccount = account;
                break;
            }
        }

        if (foundAccount == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Choose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Deposit: ");
                double amount = scanner.nextDouble();

                foundAccount.deposit(amount);

                System.out.println("New balance: " + foundAccount.getBalance());
            } else if (choice == 2) {
                System.out.print("Withdraw: ");
                double amount = scanner.nextDouble();

                if (amount > foundAccount.getBalance()) {
                    System.out.println("Not enough balance.");
                } else {
                    foundAccount.withdraw(amount);
                    System.out.println("New balance: " + foundAccount.getBalance());
                }
            } else {
                System.out.println("Wrong operation.");
            }
        }

        scanner.close();
    }
}