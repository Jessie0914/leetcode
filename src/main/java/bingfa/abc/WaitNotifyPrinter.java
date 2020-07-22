package bingfa.abc;

/**
 * @Classname WaitNotifyPrinter
 * @Description TODO
 * @Date 2020/7/22 12:00 下午
 * @Created by chiyue
 */
public class WaitNotifyPrinter {
    /**
     * 循环次数
     */
    private int loopNum;

    private int flag;

    public WaitNotifyPrinter(int loopNum, int flag) {
        this.loopNum = loopNum;
        this.flag = flag;
    }

    /**
     * 打印消息
     *
     * @param message 要打印的内容
     * @param current 当前flag
     * @param next    要唤醒的flag
     */
    public void print(String message, int current, int next) {
        synchronized (this) {
            for (int i = 0; i < loopNum; i++) {
                //判断flag是否和当前一致，一致就打印
                while (flag != current) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(message);
                //更新flag
                flag = next;
                //更新完需要唤醒正在等待的线程
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        WaitNotifyPrinter p = new WaitNotifyPrinter(5, 1);
        new Thread(() -> {
            p.print("a", 1, 2);
        }).start();
        new Thread(() -> {
            p.print("b", 2, 3);
        }).start();
        new Thread(() -> {
            p.print("c", 3, 1);
        }).start();
    }
}
