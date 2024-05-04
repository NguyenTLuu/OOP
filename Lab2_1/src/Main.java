public class Main {
    public static void main(String[] args) {
        ComplexNumber complexNumber1 = new ComplexNumber();
        complexNumber1.input();
        ComplexNumber complexNumber2 = new ComplexNumber();
        complexNumber2.input();
        complexNumber1.plus(complexNumber2).print();
        complexNumber1.minus(complexNumber2).print();
        complexNumber1.multiply(complexNumber2).print();
        complexNumber1.divide(complexNumber2).print();

    }
}

