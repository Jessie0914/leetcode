package String;

/**
 * @ClassName Solution26
 * @Description 14.最长公共前缀
 * @Author shishi
 * @Date 2019/6/28 16:15
 **/

/**
 * 题目要求：
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例：
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 */
public class Solution14 {
    // 这方法是纵向扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        // 取第一个字符串作为对照，匹配的长度最多也是第一个字符串的长度
        int right_most = strs[0].length();
        // 从第二个字符串开始比较（如果只有一个字符串，这个循环不会进来）
        for (int i = 1; i < strs.length; i++)
            // 每个字符串都从头开始比较，比较到“最长可能长度”即可（每次比较完一个字符串，都需要更新一下“最长可能长度”）
            for (int j = 0; j < right_most; j++)
                // 如果一直匹配，就一直j++

                // 当本身字符串已经到边界 或者 哪个字符不匹配了，就可以更新“最长可能长度”了，并且就会立马跳出循环
                if (j == strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j))
                    right_most = j;

        return strs[0].substring(0, right_most);
    }
}
