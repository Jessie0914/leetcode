import org.junit.Test;
import other.Solution415;

public class Solution415Test {

    @Test
    public void addStrings() {
        Solution415 solution415 = new Solution415();
        String nums1= "6913259244";
        String nums2 = "71103343";
        String s = solution415.addStrings(nums1, nums2);
        System.out.println(s);
    }
}