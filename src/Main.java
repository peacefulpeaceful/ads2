public class Main {
    public static void main(String[] args) {
        MainBank bank = new MainBank();

        bank.addAccount(new BankAccount(1001, "Ali", 150000));
        bank.addAccount(new BankAccount(1002, "Sara", 220000));
        bank.addAccount(new BankAccount(1003, "Dias", 180000));

        System.out.println();
        bank.showAccounts();

        System.out.println();
        bank.searchByUsername("Sara");
    }
}
