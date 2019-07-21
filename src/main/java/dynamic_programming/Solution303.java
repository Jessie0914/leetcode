package dynamic_programming;

/**
 * @ClassName Solution303
 * @Description 303.区域和检索-数组不可变
 * @Author shishi
 * @Date 2019/7/3 14:05
 **/

/**
 * 题目要求：
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
public class Solution303 {
    // 我想到的方法可行，但是效率特别低
    // 其实就是，我新建了一个数组，将初始化的数组拷贝过来，然后就计算i-j的和
    int[] array;
    public Solution303(int[] nums) {
        this.array = nums;
    }

    int sum = 0;
    public int sumRange(int i, int j) {
        if (i<0) return 0;
        sum = 0;
        for (;i<=j;i++){
            sum += array[i];
        }
        return sum;
    }
}
