import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<BankAccount> accounts = new LinkedList<>();
        Stack<String> transactionHistory = new Stack<>();
        Queue<String> billQueue = new LinkedList<>();

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
            scanner.close();
            return;
        }

        while (true) {
            System.out.println();
            System.out.println("Choose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Bill payment");
            System.out.println("4. Add bill request to queue");
            System.out.println("5. Process next bill payment");
            System.out.println("6. Display bill queue");
            System.out.println("7. Show last transaction");
            System.out.println("8. Undo last transaction");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

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

            } else if (choice == 4) {
                System.out.print("Enter bill name: ");
                String billName = scanner.nextLine();

                billQueue.offer(billName);
                System.out.println("Added: " + billName);

            } else if (choice == 5) {
                if (billQueue.isEmpty()) {
                    System.out.println("Bill queue is empty.");
                } else {
                    String processedBill = billQueue.poll();
                    System.out.println("Processing: " + processedBill);
                }

            } else if (choice == 6) {
                if (billQueue.isEmpty()) {
                    System.out.println("Queue is empty.");
                } else {
                    System.out.println("Bill Queue:");
                    for (String bill : billQueue) {
                        System.out.println(bill);
                    }
                }

            } else if (choice == 7) {
                if (!transactionHistory.isEmpty()) {
                    System.out.println("Last transaction: " + transactionHistory.peek());
                } else {
                    System.out.println("No transactions in history.");
                }

            } else if (choice == 8) {
                if (!transactionHistory.isEmpty()) {
                    String removedTransaction = transactionHistory.pop();
                    System.out.println("Undo -> " + removedTransaction + " removed");
                } else {
                    System.out.println("Nothing to undo.");
                }

            } else if (choice == 9) {
                System.out.println("Program ended.");
                break;

            } else {
                System.out.println("Wrong operation.");
            }
        }

        scanner.close();
    }
}