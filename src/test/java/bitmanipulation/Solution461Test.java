package bitmanipulation;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution461Test {

    @Test
    public void hammingDistance() {
        Solution461 solution461 = new Solution461();
        int hammingDistance = solution461.hammingDistance(1, 4);
        System.out.println(hammingDistance);
    }
}