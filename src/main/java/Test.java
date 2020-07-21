/**
 * @ClassName Test
 * @Description TODO
 * @Author shishi
 * @Date 2019/10/29 20:44
 **/
public class Test {
    public static void main(String[] args) {
        String s = "www.taobao.com";
        int i = s.length() - 1;

        StringBuilder sb = new StringBuilder();

        while (i >= 0) {
            int j = i;
            while (i >= 0 && s.charAt(i) != '.') {
                i--;
            }
            // 当前i为'.'，所以需要从i+1开始截取字符串
            sb.append(s, i + 1, j + 1);
            if (i > 0)
                sb.append('.');
            i--;
        }
        System.out.println(sb.toString());
    }
}
