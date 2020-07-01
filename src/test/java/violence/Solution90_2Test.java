package violence;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution90_2Test {

    @Test
    public void subsetsWithDup() {
        Solution90_2 solution90_2 = new Solution90_2();
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> lists = solution90_2.subsetsWithDup(nums);
        for (List list : lists){
            for (Object i : list){
                System.out.print(i+" ");
            }
            System.out.println("------------");
        }
    }
}