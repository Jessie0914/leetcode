package jianzhi;

/**
 * @ClassName JZ2
 * @Description 将一个字符串中的每个空格替换成“%20”
 * @Author shishi
 * @Date 2020/7/12 14:52
 **/
public class JZ2 {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else {
                sb.append("%20");
            }
            i++;
        }

        return sb.toString();
    }
}
