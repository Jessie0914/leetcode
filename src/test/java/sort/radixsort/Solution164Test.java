package sort.radixsort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution164Test {

    @Test
    public void maximumGap() {
        Solution164 solution164 = new Solution164();
        int[] nums = {3,1,6,9};
        int maximumGap = solution164.maximumGap(nums);
        System.out.println(maximumGap);
    }
}