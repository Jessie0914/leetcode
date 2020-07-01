package violence;

import org.junit.Test;

import java.util.List;

public class Solution78Test {

    @Test
    public void subsets() {
        Solution78 solution78 = new Solution78();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = solution78.subsets(nums);
        for (List list:subsets){
            for (Object i : list){
                System.out.print(i+" ");
            }
            System.out.println("-------------");
        }
    }
}