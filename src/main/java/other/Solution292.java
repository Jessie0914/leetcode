package other; /**
 * @ClassName Solution292
 * @Description 292.Nim游戏
 * @Author shishi
 * @Date 2019/7/23 14:45
 **/

/**
 * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 */
public class Solution292 {
    // 如果堆中石头的数量 n 不能被 4 整除，那么你总是可以赢得 Nim 游戏的胜利。
    // 推理可以看官方的题解
    public boolean canWinNim(int n) {
        if (n%4==0) return false;
        else return true;
    }
}
