package search;

/**
 * @ClassName Solution4
 * @Description 4.寻找两个有序数组的中位数
 * @Author shishi
 * @Date 2019/7/13 20:34
 **/

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class Solution4 {
    // 最简单的方法，开辟新数组排序，取中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int newLength = nums1.length+nums2.length;
        int[] result = new int[newLength];
        for (int i=0;i<nums1.length;i++){
            result[i] = nums1[i];
        }
        for (int i=0;i<nums2.length;i++){
            result[i+nums1.length] = nums2[i];
        }
        Arrays.sort(result);
        if (newLength%2==1) return (double) result[newLength/2];
        else return (double)(result[newLength/2-1]+result[newLength/2])/2;
    }
}
