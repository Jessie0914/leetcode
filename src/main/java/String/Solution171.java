package String;

/**
 * @ClassName Solution171
 * @Description 171.Excel表列序号
 * @Author shishi
 * @Date 2019/7/2 15:25
 **/

/**
 * 题目要求：
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 示例：
 * 输入: "A"
 * 输出: 1
 *
 * 输入: "AB"
 * 输出: 28
 */
public class Solution171 {
    public static void main(String[] args) {
        Solution171 solution171 = new Solution171();
        int titleToNumber = solution171.titleToNumber("AAA");
        System.out.println(titleToNumber);
    }

    public int titleToNumber(String s) {
        final int length = s.length();
        if (length==0) return 0;
        int i=0;
        int result = 0;
        while (i<length){
            char c = s.charAt(i);
            if (i!=length-1){
                result =result+(int) ((c-'A'+1)*Math.pow(26,length-1-i));
            }
            // 如果是最后一位，那么需要加上(c-'A'+1)
            else {
                result += (c-'A'+1);
            }
            i++;
        }
        return result;
    }
}
