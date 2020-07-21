package bingfa;

/**
 * @ClassName OddAndEven
 * @Description 打印奇偶数
 * @Author shishi
 * @Date 2020/3/13 16:13
 **/
public class OddAndEven {
    // 0的时候打印偶数，1的时候打印奇数
    static int state = 0;
    static int even = 0;
    static int odd = 1;

    public static void main(String[] args) {
        OddAndEven oddAndEven = new OddAndEven();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (even <= 100) {
                    synchronized (oddAndEven) {
                        if (state == 1) {
                            try {
                                oddAndEven.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(even);
                        oddAndEven.notifyAll();
                        even += 2;
                        state = 1;
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (odd <= 100) {
                    synchronized (oddAndEven) {
                        if (state == 0) {
                            try {
                                oddAndEven.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(odd);
                        oddAndEven.notifyAll();
                        odd += 2;
                        state = 0;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
