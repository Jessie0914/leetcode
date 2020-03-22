package design_pattern;

/**
 * @ClassName Singleton
 * @Description TODO
 * @Author shishi
 * @Date 2020/3/14 11:08
 **/
public class Singleton {
    private Singleton instance;

    private Singleton() {

    }

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
