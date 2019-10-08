package String;

/**
 * @ClassName Solution306
 * @Description 306. 累加数
 * @Author shishi
 * @Date 2019/9/15 13:10
 **/

/**
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 *  输入: "112358"
 * 输出: true
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 */
public class Solution306 {
    // 只要去寻找好第一个和第二个num即可
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len<3) return false;
        // 比如说长度为5，那么第一个数最多为2；长度为6，第一个长度最多也是为2。所以长度最多为(len-1)/2
        // 第一个数的长度必定在1~(len-1)/2之间，从0开始，到i结束（不包括i）
        for (int i=1;i<=(num.length()-1)/2;i++){
            String s1 = num.substring(0, i);
            // 如果说长度>1并且以0开头，才是无效的。（注意如果长度==1，不能判为无效，比如说0）
            if (s1.startsWith("0")&&s1.length()>1) break;
            long num1 = Long.parseLong(s1);

            // 第二个数是从i开始（包含i），到j结束（不包含j）
            for (int j=i+1;j<len;j++){
                String s2 = num.substring(i, j);
                if (s2.startsWith("0")&&s2.length()>1) break;
                long num2 = Long.parseLong(s2);

                // 剩下的字符串就是从j开始截取（包含j）
                String remain = num.substring(j);
                // 递归比较
                if (judgeRemain(remain,num1,num2)){
                    return true;
                }
            }
        }
        return false;
    }

    // 取到了第一个数和第二个数之后，和剩下的字符串递归比较
    private boolean judgeRemain(String remain, long num1, long num2) {
        // 递归结束的条件
        if (remain.equals("")) return true;
        // 将num3转换成字符串
        long num3 = num1+num2;
        String s3 = num3+"";

        // 如果remain前面的部分不是s3，直接返回false
        if (!remain.startsWith(s3)) return false;
        // 否则，递归比较，num2变成了num1，num3变成了num2，remain是取s3的长度之后的字符串
        return judgeRemain(remain.substring(s3.length()),num2,num3);
    }
}
