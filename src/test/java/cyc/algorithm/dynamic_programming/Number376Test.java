package cyc.algorithm.dynamic_programming;

import org.junit.Test;

import static org.junit.Assert.*;

public class Number376Test {

    @Test
    public void wiggleMaxLength() {
        Number376 number376 = new Number376();
        int[] nums = {1,7,4,9,2,5};
        int maxLength = number376.wiggleMaxLength(nums);
        System.out.println(maxLength);
    }
}