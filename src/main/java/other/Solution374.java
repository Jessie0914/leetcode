package other; /**
 * @ClassName Solution374
 * @Description 374.猜数字大小
 * @Author shishi
 * @Date 2019/7/4 21:05
 **/

/**
 * 题目要求：
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * 示例：
 * 输入: n = 10, pick = 6
 * 输出: 6
 */
public class Solution374 {
    // 这题没法儿测试，因为调用的接口函数guess(n)是leetcode服务器上的，你看不到
    public int guessNumber(int n) {
        int guess = -1;
        while (guess(n)!=0){
            if (guess==-1) {
                n--;
            }
            else n++;
        }
        return n;
    }

    private int guess(int n) {
        return 0;
    }
}
