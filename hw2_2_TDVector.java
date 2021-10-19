import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TDVector a = new TDVector(); /* 无参构造，向量的x和y默认为0 */
        Scanner sc = new Scanner(System.in);
        double x, y, z;
        x = sc.nextDouble();
        y = sc.nextDouble();
        z = sc.nextDouble();
        TDVector b = new TDVector(x, y); /* 按照参数构造向量的x和y */
        TDVector c = new TDVector(b); /* 按照向量b构造向量 */
        a.setY(z);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        c.setX(z);
        a = b.add(c);
        System.out.println(a);
        System.out.println("b.x=" + b.getX() + " b.y=" + b.getY());
        sc.close();
    }
}

class TDVector {
    private double x;
    private double y;

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    /** 你所提交的代码将被嵌在这里（替换此行） **/
    public TDVector() {
        this(0, 0);
    }

    public TDVector(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public TDVector(TDVector other) {
        this(other.getX(), other.getY());
    }

    double getX() {
        return this.x;
    }

    double getY() {
        return this.y;
    }

    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    TDVector add(TDVector other) {
        return new TDVector(this.getX() + other.getX(), this.getY() + other.getY());
    }
    /** 到这里 **/

}
