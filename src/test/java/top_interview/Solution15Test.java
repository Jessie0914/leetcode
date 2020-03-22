package top_interview;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class Solution15Test {

    @Test
    public void threeSum() {
        Solution15 solution15 = new Solution15();
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> lists = solution15.threeSum(nums);
        for (List list : lists){
            Iterator iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
            System.out.println();
        }
    }
}