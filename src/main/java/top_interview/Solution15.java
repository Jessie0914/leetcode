package top_interview;

/**
 * @ClassName Solution15
 * @Description 三数之和
 * @Author shishi
 * @Date 2020/2/28 21:12
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution15 {
    // 需要注意如何防止重复
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 遇上重复的就直接往前
            if ((i - 1) >= 0 && nums[i] == nums[i - 1])
                continue;

            int num = nums[i];

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (num + nums[j] + nums[k] > 0) {
                    k--;
                    // 防止重复，遇到一样的元素，一直后退
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else if (num + nums[j] + nums[k] < 0) {
                    j++;
                    // 防止重复
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                } else {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(num);
                    cur.add(nums[j]);
                    cur.add(nums[k]);

                    list.add(cur);
                    j++;
                    k--;
                    // 防止重复
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    // 防止重复
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }

        return list;
    }
}
