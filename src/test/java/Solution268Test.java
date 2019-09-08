import org.junit.Test;

import static org.junit.Assert.*;

public class Solution268Test {

    @Test
    public void missingNumber() {
        Solution268 solution268 = new Solution268();
        int[] nums={2};
        int i = solution268.missingNumber(nums);
        System.out.println(i);
    }
}