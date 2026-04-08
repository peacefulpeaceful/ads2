import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MainBank {
    private Scanner scanner = new Scanner(System.in);

    private LinkedList<BankAccount> accounts = new LinkedList<>();
    private Stack<String> transactionHistory = new Stack<>();
    private Queue<String> billQueue = new LinkedList<>();
    private Queue<BankAccount> accountRequests = new LinkedList<>();

    private BankAccount[] fixedAccounts = {
            new BankAccount(1, "King", 1000),
            new BankAccount(2, "Bebra", 2000),
            new BankAccount(3, "Miomio", 3000)
    };

    private AccountService accountService = new AccountService();
    private QueueService queueService = new QueueService();

    public MainBank() {
        accounts.add(new BankAccount(1, "King", 1000));
        accounts.add(new BankAccount(2, "Bebra", 2000));
        accounts.add(new BankAccount(3, "Miomio", 3000));
    }

    public void showFixedArrayAccounts() {
        System.out.println("Fixed Array Accounts:");
        for (int i = 0; i < fixedAccounts.length; i++) {
            fixedAccounts[i].display();
        }
    }

    public void bankMenu() {
        while (true) {
            System.out.println();
            System.out.println("Bank Menu");
            System.out.println("1 - Submit account opening request");
            System.out.println("2 - Deposit money");
            System.out.println("3 - Withdraw money");
            System.out.println("4 - Back");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                queueService.submitAccountRequest(scanner, accountRequests);
            } else if (choice == 2) {
                BankAccount account = accountService.findAccountByUsername(scanner, accounts);
                if (account != null) {
                    accountService.depositMoney(scanner, account, transactionHistory);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 3) {
                BankAccount account = accountService.findAccountByUsername(scanner, accounts);
                if (account != null) {
                    accountService.withdrawMoney(scanner, account, transactionHistory);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Wrong option.");
            }
        }
    }

    public void atmMenu() {
        while (true) {
            System.out.println();
            System.out.println("ATM Menu");
            System.out.println("1 - Balance enquiry");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Back");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                BankAccount account = accountService.findAccountByUsername(scanner, accounts);
                if (account != null) {
                    accountService.showBalance(account);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 2) {
                BankAccount account = accountService.findAccountByUsername(scanner, accounts);
                if (account != null) {
                    accountService.withdrawMoney(scanner, account, transactionHistory);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Wrong option.");
            }
        }
    }

    public void adminMenu() {
        while (true) {
            System.out.println();
            System.out.println("Admin Menu");
            System.out.println("1 - View pending account requests");
            System.out.println("2 - Process next account request");
            System.out.println("3 - View bill payment queue");
            System.out.println("4 - Add bill to queue");
            System.out.println("5 - Process next bill payment");
            System.out.println("6 - Show last transaction");
            System.out.println("7 - Undo last transaction");
            System.out.println("8 - Show all accounts");
            System.out.println("9 - Show fixed array accounts");
            System.out.println("10 - Back");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                queueService.displayPendingRequests(accountRequests);
            } else if (choice == 2) {
                queueService.processNextAccountRequest(accountRequests, accounts);
            } else if (choice == 3) {
                queueService.displayBillQueue(billQueue);
            } else if (choice == 4) {
                queueService.addBillToQueue(scanner, billQueue);
            } else if (choice == 5) {
                queueService.processNextBill(billQueue);
            } else if (choice == 6) {
                queueService.showLastTransaction(transactionHistory);
            } else if (choice == 7) {
                queueService.undoLastTransaction(transactionHistory);
            } else if (choice == 8) {
                accountService.showAllAccounts(accounts);
            } else if (choice == 9) {
                showFixedArrayAccounts();
            } else if (choice == 10) {
                break;
            } else {
                System.out.println("Wrong option.");
            }
        }
    }
}