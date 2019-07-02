package sort;

import java.util.Arrays;

/**
 * @ClassName Solution242_2
 * @Description 242 字母异位词的其他解法
 * @Author shishi
 * @Date 2019/6/25 18:50
 **/

/**
 * 方法1
 * 可以将两个字符串排序，如果是异位词的话，排好序之后比较一定是相同的
 * 但这个方法提交之后，也没有多高效，比我自己那个好一点
 *
 * 要记住的方法：
 * ①字符串排序的方法（将字符串转换成char[]数组，然后Arrays.sort对char[]数组排序，最后再将char[]数组toString成字符串）
 * ②两个字符串比较不能用"=="，需要用equals
 *
 * 方法2
 * 哈希表的思想，利用的是数组即可
 */
public class Solution242_2 {

    public boolean isAnagram(String s, String t){
        if (s.length()!=t.length()){
            return false;
        }

        // 将字符串s排好序
        char[] charArrayS = s.toCharArray();
        Arrays.sort(charArrayS);
        String sortedS = Arrays.toString(charArrayS);

        // 将字符串t排好序
        char[] charArrayT = t.toCharArray();
        Arrays.sort(charArrayT);
        String sortedT = Arrays.toString(charArrayT);

        // 将字符串s和t做比较
        if (sortedS.equals(sortedT)){
            return true;
        }else {
            return false;
        }
    }

    // 哈希表方法（和我自己想的方法是一样的，但是这里只用了数组就好）
    // 这个是最高效的
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }

        for (int count:counter){
            if (count!=0){
                return false;
            }
        }
        return true;
    }
}
