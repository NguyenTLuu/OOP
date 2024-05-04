import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Bank(ArrayList<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public Bank() {
    }

    public void inputAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            BankAccount account = new BankAccount();
            account.inputBankAccount();
            accounts.add(account);
        }
    }

    public void outputAccounts() {
        for (BankAccount account : accounts) {
            account.print();
            System.out.println();
        }
    }

    public void deposit1Account() {
        int accNo;
        double amount;
        System.out.println("Enter account number: ");
        Scanner sc = new Scanner(System.in);
        accNo = sc.nextInt();
        System.out.println("Enter amount to deposit: ");
        amount = sc.nextDouble();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).compareAccoutNumber(accNo))
                accounts.get(i).deposit(amount);
        }
    }

    public void transfer1Account() {
        int accNoSend, accNoReceive;
        double amount;
        System.out.println("Enter account send: ");
        Scanner sc = new Scanner(System.in);
        accNoSend = sc.nextInt();
        System.out.println("Enter account receive: ");
        accNoReceive = sc.nextInt();
        System.out.println("Enter amount to transfer: ");
        amount = sc.nextDouble();
        BankAccount acc1 = null, acc2 = null;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).compareAccoutNumber(accNoSend))
                acc1 = accounts.get(i);
            if (accounts.get(i).compareAccoutNumber(accNoReceive))
                acc2 = accounts.get(i);
        }
        if(acc1 != null && acc2 != null) {
            acc1.transferMoney(acc2,amount);
        }

    }


}
