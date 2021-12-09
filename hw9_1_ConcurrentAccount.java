import java.util.Scanner;

class Account implements Runnable {
    private int balance;

    Account(int balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int money) {
        balance += money;

        this.notify();
    }

    public synchronized void withdraw(int money) {

        while (this.balance < money)
            try {
                this.wait();
                // Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        balance -= money;

        if (balance < 0) // 这里是withdraw代码的后半部分。
            throw new IllegalStateException(balance + "");
    }

    @Override
    public void run() {
    }

}
/* 系统已有代码，无需关注 */

public class Main {
    public static void main(String[] args) {

    }
}
