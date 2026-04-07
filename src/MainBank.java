import java.util.LinkedList;

public class MainBank {
    private LinkedList<BankAccount> accounts;

    public MainBank() {
        accounts = new LinkedList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println(account.getUsername() + " added successfully.");
    }

    public void showAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in the list.");
            return;
        }

        System.out.println("Accounts List: ");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i));
        }
    }

    public void searchByUsername(String username) {
        for (BankAccount account : accounts) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Account found: ");
                account.display();
                return;
            }
        }
        System.out.println("Account not found.");
    }
}