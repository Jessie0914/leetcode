package bitmanipulation; /**
 * @ClassName bitmanipulation.Solution371
 * @Description 371.两整数之和
 * @Author shishi
 * @Date 2019/7/2 16:06
 **/

/**
 * 题目要求：
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 */
public class Solution371 {
    // 这个有点意思，分为进位和加起来的和的部分
    // 加起来的和就用异或操作符就行了，但是它无法照顾到二进制加后的进位
    // 所以需要用到&操作，进位就是两数&的结果
    // 接下来，再把进位和加起来的和 用异或操作加起来，直到进位为0
    public static int getSum(int a, int b) {
        if (b==0) return a;
        int sum = a^b;
        int carry = (a&b) << 1;
        if (carry!=0){
            return getSum(sum,carry);
        }
        return sum;
    }
}
