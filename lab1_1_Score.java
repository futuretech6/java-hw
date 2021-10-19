import java.util.Scanner;
// import java.lang.Integer;

class Main {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // Fraction a = new Fraction(-1, 2);
        // Fraction b = new Fraction(1, 3);
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(a.plus(b));
        // System.out.println(a.multiply(b).plus(new Fraction(5, 6)));
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(a.toDouble());
        System.out.println(new Fraction(-3, 2).toString());
        // in.close();
    }
}

/* 请在这里填写答案 */

class Fraction {
    private int a, b;

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public Fraction(int a, int b) {
        int gcd = gcd(a, b);
        this.a = a / gcd;
        this.b = b / gcd;
        if (this.b < 0) {
            this.a *= -1;
            this.b *= -1;
        }
    }

    public double toDouble() {
        return 1.0 * a / b;
    }

    public Fraction plus(Fraction r) {
        return new Fraction(a * r.b + b * r.a, b * r.b);
    }

    public Fraction multiply(Fraction r) {
        return new Fraction(a * r.a, b * r.b);
    }

    public String toString() {
        if (a == 1 && b == 1)
            return "1";
        else
            return a + "/" + b;
    }
};