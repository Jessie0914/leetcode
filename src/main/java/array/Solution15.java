package array;

/**
 * @ClassName Solution15
 * @Description 15.三数之和
 * @Author shishi
 * @Date 2019/6/29 14:38
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目要求：
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * nums = [-1, 0, 1, 2, -1, -4]
 * 结果：[ [-1, 0, 1], [-1, -1, 2] ]
 */
public class Solution15 {
    // 自己想不出来，抄的书的代码
    // 先排序，然后在最内层循环左右夹逼，并且要跳过重复的数
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 如果数量都不足三个数，直接返回空List即可
        if (nums.length < 3) return result;

        // 先排序
        Arrays.sort(nums);
        // 定义成final，不需要改变了
        final int target = 0;

        // 最外层循环，i从第一个开始
        for (int i = 0; i < nums.length - 2; ++i) {
            // 跳过重复的
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // 第二个坐标从j=i+1开始遍历
            int j = i+1;
            // 第三个坐标从末尾开始遍历
            int k = nums.length-1;

            // 移动第二个和第三个坐标，左右夹逼
            while (j < k) {
                // 如果三数相加比target小，说明需要往右移动j
                if (nums[i] + nums[j] + nums[k] < target) {
                    ++j;
                    // 当遇到相同的数的时候，就一直j++
                    while(nums[j] == nums[j-1] && j < k) ++j;
                }
                // 如果三数相加比target大，就说明需要往左移动k
                else if(nums[i] + nums[j] + nums[k] > target) {
                    --k;
                    // 当遇到相同的数的时候，就一直k--
                    while(nums[k] == nums[k+1] && j < k) --k;
                }
                // 当三数相加正好等于target，就说明找到了一组可行解
                else {
                    // 加入List中，记住这个函数Arrays.asList()
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    while(nums[j] == nums[j-1] && j < k) ++j;
                    while(nums[k] == nums[k+1] && j < k) --k;
                }
            }
        }
        return result;
    }
}
