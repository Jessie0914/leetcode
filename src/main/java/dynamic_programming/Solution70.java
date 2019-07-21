package dynamic_programming;

/**
 * @ClassName Solution70
 * @Description 70.爬楼梯
 * @Author shishi
 * @Date 2019/7/3 12:29
 **/

/**
 * 题目要求：
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例：
 * 输入： 2
 * 输出： 2
 *
 * 输入： 3
 * 输出： 3
 */
public class Solution70 {
    // 最简单的方式就是递归，f(n) = f(n-1) + f(n-2)
    // 但是效率低，会超时
    public int climbStairs(int n) {
        if (n==0) return 1;
        if (n==1) return 1;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    // 使用迭代，效率会高很多
    public int climbStairs2(int n) {
        // 相当于f(0)的初值为0
        int preV = 0;
        // 相当于f(1)的初值为1
        int cur = 1;
        for (int i=1;i<=n;i++){
            int tmp = cur;
            cur+=preV;
            preV = tmp;
        }
        return cur;
    }

    // 还有一种方法，是直接套用公式
    // 因为这个是斐波那契数列，斐波那契数列的通项有固定的公式
    // 这个效率其实还是没有迭代来的高
    public int climbStairs3(int n) {
        double s = Math.sqrt(5);
        return  (int) Math.floor((Math.pow((1+s)/2, n+1) +
                Math.pow((1-s)/2, n+1))/s + 0.5);
    }
}
