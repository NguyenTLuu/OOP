public class Question3 {
    private int n;

    public Question3() {

    }

    public Question3(int n) {
        this.n = n;
    }

    public void hailstone() {
        while (n != 1) {
            if (n % 2 == 0) {
                System.out.println(n + " is even, so we take " + n + "/2: " + (n / 2));
                n /= 2;
            }
            if (n % 2 == 1 & n != 1) {
                System.out.println(n + " is odd, so we take 3 * " + n + " + 1: " + ((n * 3) + 1));
                n = (n * 3) + 1;
            }
        }

    }
}
