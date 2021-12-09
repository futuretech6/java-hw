import java.util.Scanner;

enum IntOp {
    add { // for operator add
        int eval(int i1, int i2) {
            return i1 + i2;
        }
    },
    sub { // for operator sub
        int eval(int i1, int i2) {
            return i1 - i2;
        }
    };

    int eval(int i1, int i2) {
        return 0;
    };
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String op = in.next();
        int i1 = in.nextInt();
        int i2 = in.nextInt();
        System.out.println(IntOp.valueOf(op).eval(i1, i2));
        in.close();
    }
}