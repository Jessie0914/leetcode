package String;

/**
 * @ClassName Solution344
 * @Description 344.反转字符串
 * @Author shishi
 * @Date 2019/7/3 19:54
 **/

/**
 * 题目要求：
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 示例：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class Solution344 {
    public void reverseString(char[] s) {
        if (s.length == 0) return;

        int i = 0;
        int j = s.length-1;
        while (i<j){
            swap(s,i,j);
            i++;
            j--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
