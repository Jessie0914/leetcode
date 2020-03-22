package top_interview;

/**
 * @ClassName Solution28
 * @Description 实现 strStr()
 * @Author shishi
 * @Date 2020/3/2 22:35
 **/

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        if (needle.length() > haystack.length())
            return -1;

        // 加了这一句，能避免超时。。。
        if (needle.length() == haystack.length())
            return needle.equals(haystack) ? 0 : -1;

        int i = 0;
        int j = 0;

        while (i < haystack.length() && j < needle.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                int mayRes = i;
                while ((i < haystack.length() && j < needle.length()) && needle.charAt(j) == haystack.charAt(i)) {
                    i++;
                    j++;
                }
                if (j == needle.length())
                    return mayRes;
                else {
                    i = mayRes + 1;
                    j = 0;
                }
            } else {
                i++;
            }
        }
        return -1;
    }
}
