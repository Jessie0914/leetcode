package test;

/**
 * @ClassName Test
 * @Description 用来写代码过程中测试
 * @Author shishi
 * @Date 2019/6/26 10:39
 **/

public class Test {
    public static void main(String[] args) {
        getPer("abc","a");
    }


    public static void getPer(String str1, String str2) {
        //str1:没排好的 str2:已经排好的
        if (str1.equals("")) System.out.println(str2);
        for (int i = 0; i < str1.length(); i++) {
            getPer(str1.substring(0, i) + str1.substring(i + 1), str2 + str1.charAt(i));
        }
    }
}
