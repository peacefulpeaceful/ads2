import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainBank bank = new MainBank();
        Scanner scanner = new Scanner(System.in);
        bank.showFixedArrayAccounts();

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