package violence;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution47Test {

    @Test
    public void permuteUnique() {
        Solution47 solution47 = new Solution47();
        int[] nums = {1,1,2};
        List<List<Integer>> lists = solution47.permuteUnique(nums);
        for (List list : lists){
            for (Object i : list){
                System.out.print(i+" ");
            }
            System.out.println("------------");
        }
    }
}