package array;

import org.junit.Test;

import java.util.List;

public class Solution448Test {

    @Test
    public void findDisappearedNumbers() {
        Solution448 solution448 = new Solution448();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = solution448.findDisappearedNumbers(nums);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}