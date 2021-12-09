import java.util.*;
import java.util.concurrent.*;

class SimpleTask implements Runnable {
    private final CountDownLatch latch;
    private static Random rand = new Random(47);

    public SimpleTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            TimeUnit.NANOSECONDS.sleep(rand.nextInt(5));
            Main.list.add((int) (Math.random() * 10));
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static List<Integer> list;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Main.list = /* 你的答案 */ new ArrayList<Integer>(); /* 你的答案 */
        /* 以下是多个线程频繁在Main.list上增删元素的代码 */
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int poolSize = sc.nextInt();
            CountDownLatch latch = new CountDownLatch(m);
            ExecutorService exec = Executors.newFixedThreadPool(poolSize);
            for (int i = 0; i < m; i++) {
                exec.execute(new SimpleTask(latch));
            }
            exec.shutdown();
            latch.await();
            // 这里是一些测试代码，如检验list中元素个数是否正确
            Main.list.clear();
        }
        sc.close();

    }
}