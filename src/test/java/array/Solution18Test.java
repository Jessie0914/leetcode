package array;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class Solution18Test {

    @Test
    public void fourSum() {
        Solution18 solution18 = new Solution18();
        int[] nums = {-1,-5,-5,-3,2,5,0,4};
        int target = 0;
        List<List<Integer>> lists = solution18.fourSum(nums, target);
        Iterator<List<Integer>> iterator = lists.iterator();
        while (iterator.hasNext()){
            List<Integer> list = iterator.next();
            for (Integer integer : list){
                System.out.print(integer+" ");
            }
            System.out.println("----------");
        }
    }
}