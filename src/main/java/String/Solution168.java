package String;

/**
 * @ClassName Solution168
 * @Description 168.Excel表列名称
 * @Author shishi
 * @Date 2019/7/4 10:25
 **/

/**
 * 题目要求：
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 示例：
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 */
public class Solution168 {
    public static void main(String[] args) {
        Solution168 solution168 = new Solution168();
        String s = solution168.convertToTitle(702);
        System.out.println(s);
    }

    public String convertToTitle(int n) {
        String res = "";
        while (n>0){
            int k = n % 26;
            if (k==0){
                res = 'Z'+ res;
                n-=26;
            }else {
                res = (char)('A' - 1 + k) + res;
            }
            n/=26;
        }
        return res;
    }
}
