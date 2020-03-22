package top_interview;

/**
 * @ClassName Solution26
 * @Description 删除排序数组中的重复项
 * @Author shishi
 * @Date 2020/3/2 22:12
 **/

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 1)
            return nums.length;

        int curIndex = 1;
        int mayNeedToReplace = 1;

        while (mayNeedToReplace < nums.length) {
            // 如果发现重复元素
            if (nums[mayNeedToReplace] == nums[mayNeedToReplace - 1]) {
                // 往后去找第一个不是当前数的值
                int value = nums[mayNeedToReplace];
                while (mayNeedToReplace<nums.length && nums[mayNeedToReplace]==value){
                    mayNeedToReplace++;
                }
            }
            else {
                nums[curIndex] = nums[mayNeedToReplace];
                mayNeedToReplace++;
                curIndex++;
            }
        }
        return curIndex;
    }
}
