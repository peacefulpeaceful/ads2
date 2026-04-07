import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<BankAccount> accounts = new LinkedList<>();
        Stack<String> transactionHistory = new Stack<>();

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
            System.out.println("3. Bill payment");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Deposit: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                foundAccount.deposit(amount);

                String transaction = "Deposit " + amount + " to " + foundAccount.getUsername();
                transactionHistory.push(transaction);

                System.out.println("New balance: " + foundAccount.getBalance());
            } else if (choice == 2) {
                System.out.print("Withdraw: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                if (amount > foundAccount.getBalance()) {
                    System.out.println("Not enough balance.");
                } else {
                    foundAccount.withdraw(amount);

                    String transaction = "Withdraw " + amount + " from " + foundAccount.getUsername();
                    transactionHistory.push(transaction);

                    System.out.println("New balance: " + foundAccount.getBalance());
                }
            } else if (choice == 3) {
                System.out.print("Enter bill payment amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                if (amount > foundAccount.getBalance()) {
                    System.out.println("Not enough balance for bill payment.");
                } else {
                    foundAccount.withdraw(amount);

                    String transaction = "Bill payment " + amount + " from " + foundAccount.getUsername();
                    transactionHistory.push(transaction);

                    System.out.println("Bill payment completed.");
                    System.out.println("New balance: " + foundAccount.getBalance());
                }
            } else {
                System.out.println("Wrong operation.");
            }
        }

        System.out.println();
        if (!transactionHistory.isEmpty()) {
            System.out.println("Last transaction: " + transactionHistory.peek());
        } else {
            System.out.println("No transactions in history.");
        }

        System.out.println();
        if (!transactionHistory.isEmpty()) {
            String removedTransaction = transactionHistory.pop();
            System.out.println("Undo -> " + removedTransaction + " removed");
        } else {
            System.out.println("Nothing to undo.");
        }

        scanner.close();
    }
}