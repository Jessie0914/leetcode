import org.junit.Test;
import other.Solution167;

public class Solution167Test {

    @Test
    public void twoSum() {
        Solution167 solution167 = new Solution167();
        int[] numbers = {0,0,3,4};
        int target = 0;
        int[] nums = solution167.twoSum(numbers, target);
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}