package top_interview;

import org.junit.Test;

public class Solution4Test {

    @Test
    public void findMedianSortedArrays() {
        Solution4 solution4 = new Solution4();
        int[] nums1 = {2};
        int[] nums2 = {1};
        double medianSortedArrays = solution4.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}