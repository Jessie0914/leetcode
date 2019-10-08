package test;

/**
 * @ClassName T
 * @Description TODO
 * @Author shishi
 * @Date 2019/9/29 17:47
 **/
public class T {
    public static void main(String[] args) {
        char[] data = {'/','/','b'};
        String s = String.valueOf(data, 2, 2);
        System.out.println(s);
    }
}
