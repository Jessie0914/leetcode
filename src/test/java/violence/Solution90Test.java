package violence;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution90Test {

    @Test
    public void subsetsWithDup() {
        Solution90 solution90 = new Solution90();
        int[] nums = {1,2,2};
        List<List<Integer>> lists = solution90.subsetsWithDup(nums);
        for (List list : lists){
            for (Object i : list){
                System.out.print(i+" ");
            }
            System.out.println("---------------------");
        }
    }
}