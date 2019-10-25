package array;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution229Test {

    @Test
    public void majorityElement() {
        Solution229 solution229 = new Solution229();
        int[] nums = {3,2,3};
        List<Integer> list = solution229.majorityElement(nums);
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
}