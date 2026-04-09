import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainBank bank = new MainBank();
        Scanner scanner = new Scanner(System.in);

        BankAccount[] arrayAccounts = new BankAccount[3];
        arrayAccounts[0] = new BankAccount(1, "Murino", 1000);
        arrayAccounts[1] = new BankAccount(2, "Sasha", 2000);
        arrayAccounts[2] = new BankAccount(3, "Artur", 3000);

        bank.loadAccountsFromArray(arrayAccounts);

        while (true) {
            System.out.println();
            System.out.println("Bank Menu");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                bank.bankMenu();
            } else if (choice == 2) {
                bank.atmMenu();
            } else if (choice == 3) {
                bank.adminMenu();
            } else if (choice == 4) {
                System.out.println("Program ended.");
                break;
            } else {
                System.out.println("Wrong option.");
            }
        }
    }
}