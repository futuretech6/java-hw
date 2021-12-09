import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Repo {
    private enum WorkerState {
        worker1, worker2
    };

    private List<String> tasks;
    private WorkerState state;

    /* 将传递进来的字符串以空格分隔分解为多个不同的任务，并存储起来。如"1 2 3 4 5 6"被分解成6个任务1,2,3,4,5,6 */
    public Repo(String items) {
        this();
        for (String item : items.split(" ")) {
            tasks.add(item);
        }
    }

    public Repo() {
        tasks = new LinkedList<String>();
        state = WorkerState.worker1;
    }

    public int getSize() { // 返回Repo包含的任务数量。注意：完成任务的时候，需要将任务删除。
        return tasks.size();
    }

    protected synchronized void get1() {
        if (state == WorkerState.worker1) {
            System.out.println("Thread-0 finish " + tasks.get(0));
            tasks.remove(0);
            state = WorkerState.worker2;
            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    protected synchronized void get2() {
        if (state == WorkerState.worker2) {
            System.out.println("Thread-1 finish " + tasks.get(0));
            tasks.remove(0);
            state = WorkerState.worker1;
            this.notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

class Worker1 implements Runnable {
    private Repo repo;

    Worker1(Repo r) {
        repo = r;
    }

    @Override
    public void run() {
        while (repo.getSize() > 0)
            repo.get1();
    }
}

class Worker2 implements Runnable {
    private Repo repo;

    Worker2(Repo r) {
        repo = r;
    }

    @Override
    public void run() {
        while (repo.getSize() > 0)
            repo.get2();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Repo repo = new Repo("1 2 3 4 5 6 7 8 9");
        Thread t1 = new Thread(new Worker1(repo));
        Thread t2 = new Thread(new Worker2(repo));
        t1.start();
        Thread.yield();
        t2.start();
        sc.close();
    }
}