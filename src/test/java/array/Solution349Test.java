package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution349Test {

    @Test
    public void intersection() {
        Solution349 solution349 = new Solution349();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result = solution349.intersection(nums1, nums2);
        for (int i : result){
            System.out.println(i);
        }
    }
}