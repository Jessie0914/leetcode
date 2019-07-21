package search;

/**
 * @ClassName Solution81
 * @Description 81.搜索旋转排序数组2
 * @Author shishi
 * @Date 2019/7/13 20:12
 **/

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false
 *
 * 示例：
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int index = 0;
        while (index<nums.length){
            if (nums[index]==target){
                return true;
            }
            index++;
        }
        return false;
    }
}
