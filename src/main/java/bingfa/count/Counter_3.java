package bingfa.count;

/**
 * @Classname counter_3
 * @Description 计数器
 * @Date 2020/7/22 1:52 下午
 * @Created by chiyue
 */
public class Counter_3 {
    private static int count = 0;
    public synchronized void add(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter_3 counter_3 = new Counter_3();

        for(int i = 0;i<100;i++){
            new Thread(()->{
                counter_3.add();
            }).start();
        }

        Thread.sleep(500);
        System.out.println(Counter_3.count);
    }
}
