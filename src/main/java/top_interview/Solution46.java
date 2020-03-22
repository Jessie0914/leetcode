package top_interview;

/**
 * @ClassName Solution46
 * @Description 全排列
 * @Author shishi
 * @Date 2020/3/5 15:10
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Solution46 {
    // 经典问题，全排列，回溯
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> curList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(list, curList, nums, used);
        return list;
    }

    private void helper(List<List<Integer>> list, ArrayList<Integer> curList, int[] nums, boolean[] used) {
        if (curList.size() == nums.length) {
            list.add(new ArrayList<>(curList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                curList.add(nums[i]);
                used[i] = true;
                helper(list, curList, nums, used);

                // 回退
                curList.remove(curList.size() - 1);
                used[i] = false;
            }
        }

    }
}
