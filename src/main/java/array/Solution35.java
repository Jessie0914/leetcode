package array;

/**
 * @ClassName Solution35
 * @Description 35.搜索插入位置
 * @Author shishi
 * @Date 2019/7/4 10:11
 **/

/**
 * 题目要求:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 示例：
 * 输入: [1,3,5,6], 5 输出: 2
 * 输入: [1,3,5,6], 2 输出: 1
 * 输入: [1,3,5,6], 7 输出: 4
 * 输入: [1,3,5,6], 0 输出: 0
 */
public class Solution35 {
    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        int[] nums = {1,3,5,6};
        int target = 0;
        int insert = solution35.searchInsert(nums, target);
        System.out.println(insert);
    }

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i<nums.length){
            if (nums[i]==target) return i;
            if (nums[i]>target){
                return i;
            }
            i++;
        }
        return i;
    }
}
