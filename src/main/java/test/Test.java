package test;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author shishi
 * @Date 2019/9/26 14:16
 **/
public class Test {
    public static void main(String[] args) {
        String[] strings = {"1","2","3","10"};
        Arrays.sort(strings);
        for (int i=0;i<strings.length;i++){
            System.out.println(strings[i]);
        }
    }
}
