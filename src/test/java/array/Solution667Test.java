package array;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution667Test {

    @Test
    public void constructArray() {
        Solution667 solution667 = new Solution667();
        int[] result = solution667.constructArray(4, 3);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}