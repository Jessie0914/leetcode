package array;

/**
 * @ClassName Solution713_2
 * @Description 713. 乘积小于K的子数组
 * @Author shishi
 * @Date 2019/9/24 15:21
 **/
public class Solution713_2 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<=1) return 0;
        int multiple = 1;
        int count = 0;
        int left = 0;
        for (int right=0;right<nums.length;right++){
            multiple *= nums[right];
            while (multiple>=k){
                multiple /= nums[left];
                left++;
            }
            count += right- left + 1;
        }
        return count;
    }
}
