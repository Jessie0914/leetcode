package array;

/**
 * @ClassName Solution27
 * @Description 27.移除元素
 * @Author shishi
 * @Date 2019/6/30 15:36
 **/

/**
 * 题目要求：
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例：
 * nums = [3,2,2,3], val = 3
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2
 *
 * nums = [0,1,2,2,3,0,4,2], val = 2
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4
 */
public class Solution27 {
    // 可以参考26题、80题，非常类似
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int i=0;
        while (i<nums.length){
            if (nums[i]==val){
                i++;
            }
            else {
                nums[index++] = nums[i];
                i++;
            }
        }
        return index;
    }
}
