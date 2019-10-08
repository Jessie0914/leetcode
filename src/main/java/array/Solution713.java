package array;

/**
 * @ClassName Solution713
 * @Description 713. 乘积小于K的子数组
 * @Author shishi
 * @Date 2019/9/24 13:06
 **/
public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        // 暴力求解，必定超时
        int maxlength = nums.length;
        int len = 1;
        while (len<=maxlength){
            boolean flag = false;
            for (int i=0;i<=maxlength-len;i++){
                flag = false;
                int multiple = 1;
                for (int j=i;j<i+len;j++){
                    multiple *= nums[j];
                    if (multiple>=k) flag=true;
                }
                if (!flag) count++;
            }
            len++;
        }
        return count;
    }
}
