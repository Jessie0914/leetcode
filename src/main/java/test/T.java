package test;

/**
 * @ClassName T
 * @Description TODO
 * @Author shishi
 * @Date 2019/9/29 17:47
 **/
public class T {
    public static void main(String[] args) {
        int x=9999;
        int count = func(x);
        System.out.println(count);
    }

    private static int func(int x) {
        int count = 0;
        x = 9999;
        while (x>0){
            count++;
            x = x&(x-1);
        }
        return count;
    }


}
