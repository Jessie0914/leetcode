package bitmanipulation;

/**
 * @ClassName Solution461
 * @Description 461.汉明距离
 * @Author shishi
 * @Date 2019/6/27 15:03
 **/

/**
 * 题目要求：
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 示例：
 * 输入: x = 1, y = 4
 * 输出: 2
 */
public class Solution461 {
    /**
     * 借鉴了136道题中其中的一个解决方案：异或
     * x与y的汉明距离，其实就是将两者异或得到的数转换成二进制之后1的数量
     */
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int count = 0;
        while (xor!=0){
            if (xor%2==1){
                count++;
            }
            xor/=2;
        }
        return count;
    }
}
