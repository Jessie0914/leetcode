package dynamic_programming;

/**
 * @ClassName Solution303_2
 * @Description 303.区域和检索_数组不可变的另外一种方法（动态规划的方法）
 * @Author shishi
 * @Date 2019/7/3 14:24
 **/
public class Solution303_2 {
    // 这种方法要比我一开始的方法效率提高了很多
    // 即在构造函数的时候，就计算出一开始到当前所在位置的总和
    // 那么i-j的总和，就是f[j]-f[i-1]的值
    int[] f;
    // 构造函数的时候直接就计算出f[i]的数值了，即为0-i的和
    public Solution303_2(int[] nums) {
        this.f = new int[nums.length];
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
            f[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return f[j]-(i==0 ? 0:f[i-1]);
    }
}
