package top_interview;

/**
 * @ClassName Solution34
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * @Author shishi
 * @Date 2020/3/3 22:20
 **/

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值，返回 [-1, -1]
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Solution34 {
    // 二分法
    public int[] searchRange(int[] nums, int target) {
        // 先判断是否存在
        int index = binarySearch(nums, 0, nums.length - 1, target);
        if (index == -1)
            return new int[]{-1, -1};
        else {
            // 向左向右开始找这个数的左右边界
            int value = nums[index];
            int i = index;
            while (i >= 0 && nums[i] == value)
                i--;
            int j = index;
            while (j < nums.length && nums[j] == value)
                j++;
            return new int[]{i+1, j-1};
        }
    }

    // 二分查找
    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[left] == target)
                return left;
            if (nums[right] == target)
                return right;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
}
