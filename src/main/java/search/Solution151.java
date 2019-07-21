package search;

import java.util.Arrays;

/**
 * @ClassName Solution151
 * @Description 151.寻找旋转排序数组中的最小值
 * @Author shishi
 * @Date 2019/7/13 20:23
 **/

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 */
public class Solution151 {
    // 作弊的方法。。。正确思路如下：
    // 从左向右扫描，扫描到的第一个逆序的位置，肯定是原始数组中第一个元素，时间复杂度 O(n) 。
    // 不过本题依旧可以用二分查找，最关键的是要判断那个“断层”是在左边还是右边。
    // 若 A[mid] < A[right] ，则区间 [mid,right] 一定递增，断层一定在左边
    // 若 A[mid] > A[right] ，则区间 [left,mid] 一定递增，断层一定在右边
    // nums[mid] == nums[right] ，这种情况不可能发生，因为数组是严格单调递增的，不存在重复元素
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}
