package sort.radixsort;

/**
 * @ClassName Solution164
 * @Description 164.最大间距
 * @Author shishi
 * @Date 2019/7/13 19:00
 **/

import java.util.Arrays;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例：
 * 输入: [3,6,9,1]
 * 输出: 3
 *
 * 输入: [10]
 * 输出: 0
 */
public class Solution164 {
    public int maximumGap(int[] nums) {
        if (nums.length<2) return 0;
        Arrays.sort(nums);
        int maxGap = Integer.MIN_VALUE;
        for (int i=1;i<nums.length;i++){
            if (nums[i]-nums[i-1]>maxGap){
                maxGap=nums[i]-nums[i-1];
            }
        }
        return maxGap;
    }
}
