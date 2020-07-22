package bingfa.odd_even;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname two
 * @Description 原子类
 * @Date 2020/7/22 11:15 上午
 * @Created by chiyue
 */
public class two {
    private static AtomicInteger count = new AtomicInteger(0);
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() ->{
            while (count.get()<100){
                if (flag) {
                    System.out.println(count.getAndIncrement());
                    flag = false;
                }
            }
        });

        executorService.execute(()->{
            while (count.get()<100){
                if (!flag){
                    System.out.println(count.getAndIncrement());
                    flag = true;
                }
            }
        });

        executorService.shutdown();
    }
}
