package array;

/**
 * @ClassName Solution283
 * @Description 283.移动零
 * @Author shishi
 * @Date 2019/6/30 16:03
 **/

/**
 * 题目要求：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 注意：必须在原数组上操作，不能拷贝额外的数组；尽量减少操作次数。
 *
 * 示例：
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int i = 0;
        int countOfZero = 0;
        while (i<nums.length){
            if (nums[i]==0){
                i++;
                countOfZero++;
            }else {
                nums[index++] = nums[i];
                i++;
            }
        }
        for (int j= nums.length-countOfZero;j<nums.length;j++){
            nums[j] = 0;
        }
    }
}
