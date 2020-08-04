package ali_leetcode_daily.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution15
 * @Description 三数之和
 * @Author shishi
 * @Date 2020/8/4 20:35
 **/
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return lists;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && (nums[i] == nums[i - 1]))
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);

                    lists.add(list);
                    j++;
                    while (nums[j] == nums[j - 1] && j < k)
                        j++;

                    k--;
                    while (nums[k] == nums[k + 1] && j < k)
                        k--;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                    while (nums[k] == nums[k + 1] && j < k)
                        k--;
                } else {
                    j++;
                    while (nums[j] == nums[j - 1] && j < k)
                        j++;
                }
            }
        }

        return lists;
    }
}
