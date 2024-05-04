import java.util.Scanner;

public class ComplexNumber {
    private double re;
    private double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumber() {
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Real: ");
        re = sc.nextDouble();
        sc.nextLine();
        System.out.print("Imaginary: ");
        im = sc.nextDouble();
        sc.nextLine();
    }

    public void print() {
        System.out.println(this.re + " + " + this.im + "i");
    }

    public ComplexNumber plus(ComplexNumber other) {
        double newRe = this.re + other.re;
        double newIm = this.im + other.im;
        return new ComplexNumber(newRe, newIm);
    }

    public ComplexNumber minus(ComplexNumber other) {
        double newRe = this.re - other.re;
        double newIm = this.im - other.im;
        return new ComplexNumber(newRe, newIm);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newRe = this.re * other.re - this.im * other.im;
        double newIm = this.re * other.im + this.im * other.re;
        return new ComplexNumber(newRe, newIm);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double newRe = (this.re * other.re + this.im * other.im) / (other.re * other.re + other.im * other.im);
        double newIm = (this.im * other.re - this.re * other.im) / (other.re * other.re + other.im * other.im);
        return new ComplexNumber(newRe, newIm);
    }
}
