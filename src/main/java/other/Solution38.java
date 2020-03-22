package other; /**
 * @ClassName Solution38
 * @Description 38.报数
 * @Author shishi
 * @Date 2019/7/20 12:26
 **/

/**
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */
public class Solution38 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        // 如果>1的话，遍历n-1次
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            s = strFormat(s);
        }
        return s;
    }

    private String strFormat(String s) {
        if (s.length() == 1)
            return "1" + s.charAt(0);
        int length = s.length();
        String str = "";
        int count = 1;
        char[] chars = s.toCharArray();
        // 从数组的第二个开始算起，要么和前一个数字相同，要么不同
        for (int j = 1; j < length; j++) {
            // 相同的话，就往后继续遍历，并且count++
            if (chars[j] == chars[j - 1]) {
                count++;
            }
            // 不同的话，就先把前面那一部分转换成字符串
            else {
                str = str + (char) (count + '0') + chars[j - 1];
                count = 1;
            }
            // 遍历到最后一位了
            if (j == length - 1) {
                str = str + (char) (count + '0') + chars[j];
            }
        }
        return str;
    }
}
