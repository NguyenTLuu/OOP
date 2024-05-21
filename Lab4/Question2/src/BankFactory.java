import java.util.Scanner;

public class BankFactory {
    Scanner sc = new Scanner(System.in);

    public void getBank() {
        System.out.println("Choose a bank");
        System.out.println("1. TPBank");
        System.out.println("2. VietcomBank");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                TPBank tp = new TPBank();
                System.out.println(tp.getBankName());
                break;
            case 2:
                VietcomBank vt = new VietcomBank();
                System.out.println(vt.getBankName());
                break;
        }
    }
}
