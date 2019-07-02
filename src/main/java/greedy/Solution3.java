package greedy;

/**
 * @ClassName Solution3
 * @Description 3.无重复字符的最长子串
 * @Author shishi
 * @Date 2019/6/28 13:59
 **/

import java.util.Arrays;
import java.util.Hashtable;

/**
 * 题目要求：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例：
 * 输入: "abcabcbb"
 * 输出: 3
 *
 * 输入: "bbbbb"
 * 输出: 1
 *
 * 输入: "pwwkew"
 * 输出: 3
 */

public class Solution3 {
    /**
     * 也是滑动窗口的思想
     * 即定义一个窗口，首先不断的向右滑动right，去扩大窗口，找寻一个可行解
     * 然后再不断的增加left缩小窗口，优化解，这个过程需要不断更新目标解
     */
    public int lengthOfLongestSubstring(String s) {
        // 定义两个指针（滑动窗口的两个边界）
        int left = 0, right = 0;
        int maxLength = 0;

        // 因为这里只遍历一个字符串，所以只定义一个哈希表即可
        Hashtable<Character, Integer> window = new Hashtable<>();

        // 只要右指针没有超过字符串s的右边界，就继续
        while (right<s.length()){
            char c = s.charAt(right);
            Integer count = window.get(c);
            if (count==null){
                window.put(c,1);
            }else {
                window.put(c,count+1);
            }
            right++;

            // 当某个字符对应的数量超过2时,停止right++，进入这个循环，开始缩小left
            // 只有当当前这个字符的数量重新回到1了再跳出循环，不然一直left++，所以需要while循环
            while (window.get(c)>1){
                char c1 = s.charAt(left);
                Integer num = window.get(c1);
                window.put(c1,num-1);
                left++;
            }

            if (right-left>maxLength){
                maxLength = right-left;
            }
        }
        return maxLength;
    }

    // pdf上也有一个方法，是用贪心思想完成的（好巧妙啊）
    public int lengthOfLongestSubstring2(String s) {
        final int ASCII_MAX = 255;
        // 记录字符上次出现过的位置，初始化成-1
        int[] last = new int[ASCII_MAX];
        Arrays.fill(last, -1);

        int max_len = 0;
        int start = 0; // 记录当前子串的起始位置

        for (int i = 0; i < s.length(); i++) {
            // 查找last数组中的值，如果它大于起始位置，就说明它已经出现过一次了
            // 就更新max_len，并且重新更新start位置（找到的重复元素的下一个位置）
            if (last[s.charAt(i)] >= start) {
                max_len = Math.max(i - start, max_len);
                start = last[s.charAt(i)] + 1;
            }
            // 将当前元素出现的位置放入last数组
            last[s.charAt(i)] = i;
        }

        return Math.max(s.length() - start, max_len); // 别忘了最后一次，例如"abcd"
    }
}
