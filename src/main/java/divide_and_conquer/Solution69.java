package divide_and_conquer;

/**
 * @ClassName Solution69
 * @Description 69.Sqrt(x)
 * @Author shishi
 * @Date 2019/7/1 19:26
 **/

/**
 * 题目要求：
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例：
 * 输入: 4
 * 输出: 2
 *
 * 输入: 4
 * 输出: 2
 */
public class Solution69 {
    // return (int) Math.floor(Math.sqrt(x));一句可以搞定
    // pdf上面讲的分治法我也没看懂，不看了
    public int mySqrt(int x) {
        return (int) Math.floor(Math.sqrt(x));
    }
}
