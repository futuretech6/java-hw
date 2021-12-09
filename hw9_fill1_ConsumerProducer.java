//类1：共享缓冲区
class SharedData {
    private char c;// 单缓冲(只能放 1 个产品)
    private boolean isProduced = false;// (标志)是否有产品在缓冲

    // 方法1：放产品到缓冲区
    public synchronized void push(char c) {
        if (this.isProduced) {
            try {
                System.out.println("产品" + this.c + "还未消费，不能生产");

                this.wait() /* 1 */;
            } catch (InterruptedException e /* 2 */) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        this.c = c;
        this.isProduced = true;
        this.notify(); // 此行代码与填空 3 相同
        System.out.println("生产了产品" + c + "，并通知了消费者");
    }

    // 方法2：从缓冲区取产品
    public synchronized char get() {
        if (!this.isProduced) {
            try {
                System.out.println("还未生产，不能消费");
                this.wait();// 此行代码与填空 1 相同
            } catch (InterruptedException e /* 此处代码与填空 2 相同 */ ) {
            }
        }
        this.isProduced = false;
        this.notify() /* 3 */;
        System.out.println("消费了产品" + c + "，并通知了生产者");
        return this.c;
    }
}

// 类2：消费者(线程)
class Consumer extends Thread {
    private SharedData s;

    public Consumer(SharedData s) {
        this.s = s;
    }

    public void run() {
        char ch;
        do {
            try {
                Thread.sleep((int) Math.random() * 3000);// 随机延时
            } catch (InterruptedException e /* 此处代码与填空 2 相同 */ ) {
            }

            ch = s.get() /* 4 */;// 从共享缓冲区取产品消费
        } while (ch != 'D');
    }
}

// 类3：生产者(线程)
class Producer extends Thread {
    private SharedData s;

    public Producer(SharedData s) {
        this.s = s;
    }

    public void run() {
        for (char ch = 'A'; ch <= 'D'; ch++) {
            try {
                Thread.sleep((int) Math.random() * 3000);// 随机延时
            } catch (InterruptedException e /* 此处代码与填空 2 相同 */ ) {
                e.printStackTrace();
            }

            s.push(ch) /* 5 */;// 产品入共享缓冲区
        }
    }
}

// 主类：测试程序
public class Main {
    public static void main(String[] args) {
        SharedData s = new SharedData();// 共享缓冲区
        Producer p = new Producer(s);
        Consumer c = new Consumer(s);
        p.start();
        c.start();
    }
}