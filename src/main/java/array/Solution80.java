package array;

/**
 * @ClassName Solution80
 * @Description 80.删除排序数组中的重复项2
 * @Author shishi
 * @Date 2019/6/29 12:46
 **/

/**
 * 题目要求：
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 示例：
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 */
public class Solution80 {
    // 这道题与26题就很像，姊妹题，所以稍作改动就可以了
    public int removeDuplicates(int[] nums) {
        if (nums.length<=2) return nums.length;

        int length = 2;
        int index = 2;
        while (index<nums.length){
            if (nums[index]==nums[length-2]){
                index++;
            }
            else {
                nums[length++] = nums[index];
                index++;
            }
        }
        return length;
    }
}
