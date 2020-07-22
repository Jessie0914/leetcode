package bingfa.count;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Counter
 * @Description 100个线程对一个数+1，要求最后输出100
 * @Author shishi
 * @Date 2020/3/13 15:54
 **/
public class Counter {
    static Counter counter = new Counter();
    static int count = 0;

    public synchronized void add() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    counter.add();
                }
            });
        }

        Thread.sleep(1000);
        System.out.println(count);
    }
}
