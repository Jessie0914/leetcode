package ali_leetcode_daily;

/**
 * @ClassName Solution162
 * @Description 寻找峰值
 * @Author shishi
 * @Date 2020/6/17 22:08
 **/
public class Solution162 {
    // 假设nums[-1]为-1
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        int index = 0;
        int len = nums.length;

        while (index < len) {
            if (index == 0) {
                if (nums[0] > nums[1])
                    return 0;
            }
            else if (index == len - 1) {
                if (nums[len - 1] > nums[len - 2])
                    return len - 1;
            }

            else if (nums[index] > nums[index - 1] && nums[index] > nums[index + 1])
                return index;
            index++;
        }
        return -1;
    }
}
