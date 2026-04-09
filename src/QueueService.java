import java.util.Scanner;

public class QueueService {

    public void submitAccountRequest(Scanner scanner, MyQueue<BankAccount> accountRequests) {
        System.out.print("Enter new account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        BankAccount request = new BankAccount(accountNumber, username, balance);
        accountRequests.enqueue(request);

        System.out.println("Account opening request submitted.");
    }

    public void processNextAccountRequest(MyQueue<BankAccount> accountRequests, MyLinkedList<BankAccount> accounts) {
        BankAccount approved = accountRequests.dequeue();

        if (approved != null) {
            accounts.add(approved);
            System.out.println("Request processed. Account added:");
            approved.display();
        }
    }

    public void displayPendingRequests(MyQueue<BankAccount> accountRequests) {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending account requests.");
            return;
        }

        System.out.println("Pending Account Requests:");
        accountRequests.display();
    }

    public void addBillToQueue(Scanner scanner, MyQueue<String> billQueue) {
        System.out.print("Enter bill name: ");
        String billName = scanner.nextLine();

        billQueue.enqueue(billName);
        System.out.println("Added: " + billName);
    }

    public void processNextBill(MyQueue<String> billQueue) {
        String processedBill = billQueue.dequeue();

        if (processedBill != null) {
            System.out.println("Processing: " + processedBill);
        }
    }

    public void displayBillQueue(MyQueue<String> billQueue) {
        if (billQueue.isEmpty()) {
            System.out.println("Bill queue is empty.");
        } else {
            System.out.println("Bill Queue:");
            billQueue.display();
        }
    }

    public void showLastTransaction(MyStack<String> transactionHistory) {
        String last = transactionHistory.peek();

        if (last != null) {
            System.out.println("Last transaction: " + last);
        }
    }

    public void undoLastTransaction(MyStack<String> transactionHistory) {
        String removed = transactionHistory.pop();

        if (removed != null) {
            System.out.println("Undo -> " + removed + " removed");
        }
    }
}