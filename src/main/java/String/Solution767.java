package String;

/**
 * @program: leetcode
 * @description: 重构字符串
 * @author: shishi
 * @create: 2019-09-09 10:41
 **/

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 输入: S = "aab"  输出: "aba"
 *
 * 输入: S = "aaab"  输出: ""
 */

// 思路是从前往后，当前元素和前一个元素相同的话，就往后找一个不一样的，然后交换
public class Solution767 {
    // case过不了，思路错了，上述思路比如说"baaba"就会出错
    public String reorganizeString(String S) {
        int length = S.length();
        if (length==0 || length==1) return S;
        else if (length==2){
            if (S.charAt(0)==S.charAt(1)) return "";
            else return S;
        }
        else {
            // 从1开始往后找
            int i=1;
            while (i<length) {
                char beforeC = S.charAt(i-1);
                char curC = S.charAt(i);
                // 如果相同，就往后找一个不同的，然后交换
                if (beforeC==curC){
                    int index = findDifferentIndex(S,i);
                    // 如果找不到就直接返回""
                    if (index==-1) return "";
                        // 找到了就交换
                    else {
                        String swap = swap(S, i, index);
                        S = swap;
                        i++;
                    }
                }
                else {
                    i++;
                }
            }
        }
        return S;
    }

    private String swap(String s, int i, int index) {
        char c1 = s.charAt(i);
        char c2 = s.charAt(index);
        char temp = c1;
        c1 =  c2;
        c2 = temp;
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.setCharAt(i,c1);
        stringBuilder.setCharAt(index,c2);
        s = stringBuilder.toString();
        return s;
    }

    private int findDifferentIndex(String s, int i) {
        char c = s.charAt(i);
        for (int j = i+1; j<s.length(); j++) {
            char curC = s.charAt(j);
            if (curC != c) return j;
        }
        return -1;
    }
}
