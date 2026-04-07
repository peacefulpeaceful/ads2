import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class QueueService {

    public void submitAccountRequest(Scanner scanner, Queue<BankAccount> accountRequests) {
        System.out.print("Enter new account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        BankAccount request = new BankAccount(accountNumber, username, balance);
        accountRequests.offer(request);

        System.out.println("Account opening request submitted.");
    }

    public void processNextAccountRequest(Queue<BankAccount> accountRequests, LinkedList<BankAccount> accounts) {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending account requests.");
        } else {
            BankAccount approved = accountRequests.poll();
            accounts.add(approved);
            System.out.println("Request processed. Account added:");
            approved.display();
        }
    }

    public void displayPendingRequests(Queue<BankAccount> accountRequests) {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending account requests.");
        } else {
            System.out.println("Pending Account Requests:");
            for (BankAccount request : accountRequests) {
                request.display();
            }
        }
    }

    public void addBillToQueue(Scanner scanner, Queue<String> billQueue) {
        System.out.print("Enter bill name: ");
        String billName = scanner.nextLine();

        billQueue.offer(billName);
        System.out.println("Added: " + billName);
    }

    public void processNextBill(Queue<String> billQueue) {
        if (billQueue.isEmpty()) {
            System.out.println("Bill queue is empty.");
        } else {
            String processedBill = billQueue.poll();
            System.out.println("Processing: " + processedBill);
        }
    }

    public void displayBillQueue(Queue<String> billQueue) {
        if (billQueue.isEmpty()) {
            System.out.println("Bill queue is empty.");
        } else {
            System.out.println("Bill Queue:");
            for (String bill : billQueue) {
                System.out.println(bill);
            }
        }
    }

    public void showLastTransaction(Stack<String> transactionHistory) {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions in history.");
        } else {
            System.out.println("Last transaction: " + transactionHistory.peek());
        }
    }

    public void undoLastTransaction(Stack<String> transactionHistory) {
        if (transactionHistory.isEmpty()) {
            System.out.println("Nothing to undo.");
        } else {
            String removed = transactionHistory.pop();
            System.out.println("Undo -> " + removed + " removed");
        }
    }
}