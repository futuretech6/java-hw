import java.util.Scanner;

//Main测试类
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Worker w1 = new Worker("Joe", 15);
        w1.pay(35);
        SalariedWorker w2 = new SalariedWorker("Sue", 14.5);
        w2.pay();
        w2.pay(60);
        HourlyWorker w3 = new HourlyWorker("Dana", 20);
        w3.pay(25);
        w3.setRate(35);
        int h = input.nextInt(); // 输入小时工的工作时长
        w3.pay(h);
    }
}

/* 请在这里填写答案 */

class Worker {
    String name;
    double rate;

    Worker(String name, double wage) {
        this.setName(name);
        this.setRate(wage);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getName() {
        return this.name;
    }

    public double getRate() {
        return this.rate;
    }

    public void pay(double hour) {
        System.out.println("Not Implemented");
    }

}

class HourlyWorker extends Worker {
    HourlyWorker(String name, double wage) {
        super(name, wage);
    }

    public void pay(double hour) {
        System.out.printf("%.1f\n", hour > 40 ? (2 * hour - 40) * rate : hour * rate);
    }
}

class SalariedWorker extends Worker {
    SalariedWorker(String name, double wage) {
        super(name, wage);
    }

    public void pay() {
        System.out.printf("%.1f\n", 40 * rate);
    }

    public void pay(double whatever) {
        this.pay();
    }

}