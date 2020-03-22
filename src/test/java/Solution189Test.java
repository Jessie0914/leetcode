import org.junit.Test;
import other.Solution189;

public class Solution189Test {

    @Test
    public void rotate() {
        Solution189 solution189 = new Solution189();
        int[] nums = {-1};
        solution189.rotate(nums,7);
        for (int i : nums){
            System.out.print(i+" ");
        }
    }
}