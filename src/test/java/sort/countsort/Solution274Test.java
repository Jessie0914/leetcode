package sort.countsort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution274Test {

    @Test
    public void hIndex() {
        Solution274 solution274 = new Solution274();
        int[] citations = {0,1,0,0,0};
        int hIndex = solution274.hIndex(citations);
        System.out.println(hIndex);
    }
}