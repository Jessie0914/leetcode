package bingfa.abc;

/**
 * @Classname ABC
 * @Description 3个线程打印ABC
 * @Date 2020/7/22 11:36 上午
 * @Created by chiyue
 */
public class ABC {
    // 循环次数
    private int loopCount;

    // 当前打印
    private int flag;

    public ABC(int loopCount, int flag) {
        this.loopCount = loopCount;
        this.flag = flag;
    }

    public void print(char c, int currentC, int next) {
        synchronized (this) {
            for (int i = 0; i < loopCount; i++) {
                while (flag != currentC) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(c);
                flag = next;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        // 循环3次，从1:A开始打印
        ABC abc = new ABC(3, 1);

        new Thread(() -> {
            abc.print('A', 1, 2);
        }).start();

        new Thread(() -> {
            abc.print('B', 2, 3);
        }).start();

        new Thread(() -> {
            abc.print('C', 3, 1);
        }).start();
    }
}
