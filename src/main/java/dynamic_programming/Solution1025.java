package dynamic_programming;

/**
 * @ClassName Solution1025
 * @Description 1025.除数博弈
 * @Author shishi
 * @Date 2019/7/3 14:54
 **/

/**
 * 题目要求：有点长
 */

public class Solution1025 {
    // 这个方法太强了……直接就判断奇偶数就可以解决
    // 1、数字N 如果是奇数，它的约数必然都是奇数；若是偶数，那么约数可奇可偶
    // 2、无论N一开始多大，游戏进行到N=2的时候就会结束，那么谁轮到N=2谁就会赢
    // 3、N如果是偶数，因为爱丽丝先出手，所以爱丽丝只需要一直选1，鲍勃将一直面临N为奇数的情况，爱丽丝必赢
    // 4、N如果是奇数，那么爱丽丝选完之后必然成为偶数，之后鲍勃只要一直选1就稳赢
    // 所以这个问题其实就是判断偶数还是奇数的数学题
    public boolean divisorGame(int N) {
        if (N%2==0) return true;
        else return false;
    }
}
