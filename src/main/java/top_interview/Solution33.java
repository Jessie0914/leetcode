package top_interview;

/**
 * @ClassName Solution33
 * @Description 搜索旋转排序数组
 * @Author shishi
 * @Date 2020/3/3 13:16
 **/

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Solution33 {
    // 巧办法，二分的思想
    // 需要通过判断分割点与mid的大小来分类讨论
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[left] == target)
                return left;
            if (nums[right] == target)
                return right;
            if (nums[mid] == target)
                return mid;

            // 分割点在中间偏右的情况
            if (nums[mid] > nums[left]) {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    if (target > nums[left])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            } else {
                if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    if (target > nums[left])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            }
        }
        return -1;
    }
}
