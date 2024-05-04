import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    private int mAccNum;
    private String mName;
    private double mBalance;

    public BankAccount(int mAccNum, String mName, double mBalance) {
        this.mAccNum = mAccNum;
        this.mName = mName;
        this.mBalance = mBalance;
    }

    public BankAccount inputBankAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number: ");
        mAccNum = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        mName = sc.nextLine();
        System.out.print("Enter balance: ");
        mBalance = sc.nextDouble();
        sc.nextLine();
        return this;
    }

    public BankAccount() {
    }

    public void deposit(double amount) {
        this.mBalance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount < 0) return false;
        if (amount > this.mBalance) return false;
        this.mBalance -= amount;
        return true;
    }

    public boolean transferMoney(BankAccount acc, double amount) {
        if (amount < 0) return false;
        if (amount > this.mBalance) return false;
        this.withdraw(amount);
        acc.mBalance += amount;
        return true;
    }

    public void print() {
        System.out.println("Account number: " + mAccNum);
        System.out.println("Name: " + mName);
        System.out.println("Balance: " + mBalance);
    }

    public boolean compareAccoutNumber(int acc) {
        return acc == this.mAccNum;
    }
}
