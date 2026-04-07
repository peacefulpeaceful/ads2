public class BankAccount {
    private int accountNumber;
    private String username;
    private double balance;

    public BankAccount(int accountNumber, String username, double balance){
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }
    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount){
        balance = balance + amount;
    }
    public void withdraw(double amount){
        balance = balance - amount;
    }
    public String getUsername(){
        return username;
    }
    public void display(){
        System.out.println("Account Number: " + accountNumber + " username: " + username + " balance: " + balance);
    }
    @Override
    public String toString(){
        return username + " - Balance: " + balance;
    }
}
