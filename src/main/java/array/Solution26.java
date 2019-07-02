package array;

/**
 * @ClassName Solution26
 * @Description 26.删除排序数组中的重复项
 * @Author shishi
 * @Date 2019/6/28 22:27
 **/

/**
 * 题目要求：
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
 * 注意：需要保证返回的长度和数组都是对的才行
 *
 * 示例：
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 */
public class Solution26 {
    // 我想不出如何不利用额外的数组空间+O(1)时间复杂度去解决
    // 解决方案好像也挺简单的……但自己没有想到
    public int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;

        // 这个下标是用来返回新数组的长度的（也是“新”数组的下标）
        int length = 1;
        // 这个下标是用来遍历数组的，从1开始，因为0号元素一定不会重复
        int index = 1;
        while (index<nums.length){
            // 如果和前面的重复，那么就继续往前找，直到找到不重复的
            if (nums[index]==nums[index-1]){
                index++;
            }
            // 当前元素和前面的不重复，就把第一个开始重复的覆盖掉，并且length+=
            else {
                nums[length++] = nums[index];
                index++;
            }
        }
        return length;
    }
}
