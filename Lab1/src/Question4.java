import java.util.Scanner;

public class Question4 {
    private int n;
    private int[] array;

    public void setArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Length of Array: ");
        n = sc.nextInt();
        array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
    }

    public int sumEven() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                sum += array[i];
        }
        return sum;
    }
}
