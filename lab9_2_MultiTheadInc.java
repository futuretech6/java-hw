import java.util.Scanner;

/*这里放置你的答案，即PrintTask类的代码*/

class PrintTask implements Runnable {
    Integer n;

    PrintTask(Integer n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++)
            System.out.println(i);
        System.out.println(Thread.currentThread().getName());
    }
}

/* 这里放置你的答案，即PrintTask类的代码 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintTask task = new PrintTask(Integer.parseInt(sc.next()));
        Thread t1 = new Thread(task);
        t1.start();
        sc.close();
    }
}