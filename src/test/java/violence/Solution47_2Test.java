package violence;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution47_2Test {

    @Test
    public void permuteUnique() {
        Solution47_2 solution47_2 = new Solution47_2();
        int[] nums = {1,1,2};
        List<List<Integer>> lists = solution47_2.permuteUnique(nums);
        for (List list : lists){
            for (Object i : list){
                System.out.print(i+" ");
            }
            System.out.println("------------");
        }
    }
}