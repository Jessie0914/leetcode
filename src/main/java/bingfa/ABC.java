package bingfa;

/**
 * @Classname ABC
 * @Description 3个线程分别打印ABC
 * @Date 2020/7/21 5:20 下午
 * @Created by chiyue
 */
public class ABC {
    // 0的时候打印A，1的时候打印B，2的时候打印C
    static int state = 0;

    public static void main(String[] args) {
        ABC abc = new ABC();

        // 线程1，打印A
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    synchronized (abc) {
                        if (state != 0) {
                            try {
                                abc.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("A");
                        abc.notifyAll();
                        state = 1;
                    }
                }
            }
        });

        // 线程2，打印B
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    synchronized (abc) {
                        if (state != 1) {
                            try {
                                abc.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("B");
                        abc.notifyAll();
                        state = 2;
                    }
                }
            }
        });

        // 线程3，打印C
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    synchronized (abc) {
                        if (state != 2) {
                            try {
                                abc.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("C");
                        abc.notifyAll();
                        state = 0;
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
