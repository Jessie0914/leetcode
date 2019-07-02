package String;

/**
 * @ClassName Solution58
 * @Description 58.最后一个单词的长度
 * @Author shishi
 * @Date 2019/7/2 16:39
 **/

import java.util.ArrayList;

/**
 * 题目要求：
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 示例：
 * 输入: "Hello World"
 * 输出: 5
 */
public class Solution58 {
    // 我觉得我的代码看起来有点冗余，思想就是从后往前找，但是提交总会有特殊情况报错，改了很多
    // 看了题解，思想是一样的，但代码看起来漂亮很多
    public int lengthOfLastWord(String s) {
        final int length = s.length();
        if (length==0) return 0;
        
        int i = length-1;
        while (i>0){
            if (s.charAt(i)==' '){
                i--;
            }else {
                break;
            }
        }
        int end = i+1;
        while (i>0){
            if (i-1>0 && s.charAt(i-1)!=' '){
                i--;
            }else if (i==1 && s.charAt(0)!=' '){
                i=0;
            }else {
                break;
            }
        }
        int start = i;
        String substring = s.substring(start, end).trim();
        return substring.length();
    }

    // 灵魂画手牧马师的题解
    public int lengthOfLastWord2(String s) {
        int end = s.length()-1;
        while (end>=0 && s.charAt(end)==' ') end--;

        // 主要是这一步，我上面一开始没写到这一步，导致后面很多case过不了，改来改去的
        if (end<0) return 0;

        int start = end;
        while (start>=0 && s.charAt(start)!=' ') start++;
        return end-start;
    }
}
