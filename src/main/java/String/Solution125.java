package String;

/**
 * @ClassName Solution125
 * @Description 125.验证回文串
 * @Author shishi
 * @Date 2019/7/1 14:20
 **/

/**
 * 题目要求：
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
 *
 * 示例：
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 输入: "race a car"
 * 输出: false
 */
public class Solution125 {
    // 这题要记住一个函数
    // Character.isLetterOrDigit------判断一个字符是否为字母或者数字
    public boolean isPalindrome(String s) {
        if (s.length()==0) return true;

        int start = 0;
        int end = s.length()-1;
        s = s.toLowerCase();
        while (start<end){
            if (!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            } else if (s.charAt(start)!=s.charAt(end)){
                return false;
            } else {
              start++;
              end--;
            }
        }
        return true;
    }
}
