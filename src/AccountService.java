import java.util.Scanner;

public class AccountService {

    public BankAccount findAccountByUsername(Scanner scanner, MyLinkedList<BankAccount> accounts) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        Node<BankAccount> current = accounts.getHead();

        while (current != null) {
            if (current.data.getUsername().equalsIgnoreCase(username)) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    public void depositMoney(Scanner scanner, BankAccount account, MyStack<String> transactionHistory) {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        account.deposit(amount);

        String transaction = "Deposit " + amount + " to " + account.getUsername();
        transactionHistory.push(transaction);

        System.out.printf("New balance: %.2f%n", account.getBalance());
    }

    public void withdrawMoney(Scanner scanner, BankAccount account, MyStack<String> transactionHistory) {
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

    public void showAllAccounts(MyLinkedList<BankAccount> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("Accounts List:");
        Node<BankAccount> current = accounts.getHead();
        int i = 1;

        while (current != null) {
            System.out.println(i + ". " + current.data);
            current = current.next;
            i++;
        }
    }
}