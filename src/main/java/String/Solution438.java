package String;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @ClassName Solution438
 * @Description 438.找到字符串中所有的异位字母词
 * @Author shishi
 * @Date 2019/6/28 8:07
 **/

/**
 * 题目要求：
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 示例：
 * 输入: s: "cbaebabacd" p: "abc"
 * 输出:[0, 6]
 *
 * 输入: s: "abab" p: "ab"
 * 输出: [0, 1, 2]
 */
public class Solution438 {
    /**
     * 滑动窗口思想（需要好好琢磨。。。）
     * 创建left、right指针，用来代表window窗口的左右边界，初始都指向字符串s的第一个数字
     * 维护两个hash表，分别是字符串p对应的needs和字符串s的window窗口
     * windows的right指针，一直往右走，直到满足条件（这个条件根据不同的题目而不同）的时候，开始操作left指针
     * 将left一直往前移，移到不满足条件为止
     * 然后再移动right，周而复始，直到right超过字符串s的右边界为止
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 存放结果数组
        List<Integer> res = new ArrayList<>();

        // 定义双指针
        int left = 0, right = 0;

        // 定义两个hash表，其中window作为滑动窗口
        Hashtable<Character, Integer> needs = new Hashtable<>();
        Hashtable<Character, Integer> window = new Hashtable<>();

        // 把字符串p的字母，放入needs的哈希表，代表需要匹配的数字
        // 这样一对比，C++确实好简洁啊，下面java一大坨代码，C++两行就可以
        //  for (char c : t) needs[c]++;
        for (int i=0;i<p.length();i++){
            char c = p.charAt(i);
            Integer num = needs.get(c);
            if (num==null){
                needs.put(c,1);
            }
            else {
                needs.put(c,num+1);
            }
        }

        // 定义匹配依据---需要满足的字符的个数
        // 当match的数量达到和p的字符串长度一样大的时候就说明找到了可行解
        int match = 0;

        // 当右指针还没有到尽头就一直往右
        while (right<s.length()){
            char c = s.charAt(right);
            // 如果是needs哈希表里的字符，就把window窗口对应的数值++
            if (needs.containsKey(c)){
                Integer num = window.get(c);
                if (num==null){
                    window.put(c,1);
                }else {
                    window.put(c,num+1);
                }

                // 然后判断有没有达到needs哈希表中对应字符该有的数量
                // 如果相等，就说明一个字符已经满足要求了，match++
                int num1 = window.get(c);
                int num2 = needs.get(c);
                if (num1 == num2) match++;
            }
            right++;

            // 当发现已经满足要求了，就可以开始移动左指针left了
            while (match == needs.size()){
                // 题目要求的是字母异位词，所以需要当前找到的window和needs窗口的大小需要一样
                // 如果符合，那么当前的left就是可行解，放入res数组
                if (right-left==p.length()){
                    res.add(left);
                }

                char c1 = s.charAt(left);
                // 往右移动left之前，如果当前字符和needs有关，需要做一些操作
                if (needs.containsKey(c1)){
                    int count = window.get(c1);
                    // 往右移动会减少一个有用的字符，所以数量--
                    int currentCount = count-1;
                    window.put(c1,currentCount);

                    int neededCount = needs.get(c1);
                    if (currentCount<neededCount){
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}
