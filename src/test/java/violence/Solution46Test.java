package violence;

import org.junit.Test;

import java.util.List;

public class Solution46Test {

    @Test
    public void permute() {
        Solution46 solution46 = new Solution46();
        int[] nums = {1,1,2};
        List<List<Integer>> lists = solution46.permute(nums);
        for (List list : lists){
            for (Object i : list){
                System.out.print(i+" ");
            }
            System.out.println("------------");
        }
    }
}