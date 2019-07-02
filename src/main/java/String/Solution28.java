package String;

/**
 * @ClassName Solution28
 * @Description 28.实现strStr()
 * @Author shishi
 * @Date 2019/7/1 15:23
 **/

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;

/**
 * 题目要求：
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1
 *
 * 示例：
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class Solution28 {
    // 暴力查找，更好的方法有KMP方法
    public int strStr(String haystack, String needle) {
        // 如果needle为""的话，应该返回0的
        if (needle.length()==0) return 0;
        if (haystack.length()<needle.length()) return -1;
        if (haystack.length() == needle.length()) {
            if (haystack.equals(needle)) {
                return 0;
            } else
                return -1;
        }

        // 最多比较这么多次数就够了
        int compareCount = haystack.length()-needle.length()+1;
        for (int i=0;i<compareCount;i++){
            // haystack的指针
            int j=i;
            // needle的指针
            int k=0;
            while (j<haystack.length() && k<needle.length() && haystack.charAt(j)==needle.charAt(k)){
                j++;
                k++;
            }
            if (k==needle.length()) return i;
        }

        return -1;
    }
}
