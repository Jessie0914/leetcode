package top_interview;

/**
 * @ClassName Solution14
 * @Description 最长公共前缀
 * @Author shishi
 * @Date 2020/2/28 20:55
 **/

/**
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1)
            return "";

        int row = strs.length;
        int p = 0;
        boolean flag = true;
        while (p < strs[0].length() && flag) {

            char c = strs[0].charAt(p);
            for (int i = 1; i < row; i++) {
                if (p >= strs[i].length()) {
                    flag = false;
                    break;
                } else if (strs[i].charAt(p) != c) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                p++;
        }
        return strs[0].substring(0, p);
    }
}
