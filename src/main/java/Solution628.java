/**
 * @ClassName Solution628
 * @Description 628.三个数的最大乘积
 * @Author shishi
 * @Date 2019/7/22 12:19
 **/

import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 给定的整型数组长度范围是[3,10^4]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围
 */
public class Solution628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        // 如果长度只有3，那么没得选
        if (len==3) return nums[0] * nums[1] * nums[2];
        // 如果最大值也小于0，那么也没得选
        if (nums[len-1]<=0) return nums[len-1] * nums[len-2] * nums[len-3];
        // 剩下的情况就是最大值一定大于0，那么这个数一定会用到
        // 要么就是最大值 * 剩下的紧挨着的两个＞0的数
        // 要么就是最大值 * 最小的两个负数相乘
        else {
            if (nums[0] * nums[1] > nums[len-2] * nums[len-3]){
                return nums[0] * nums[1] * nums[len-1];
            }else {
                return nums[len-2] * nums[len-3] * nums[len-1];
            }
        }
    }
}
