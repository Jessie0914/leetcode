package violence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution90
 * @Description 90.子集2
 * @Author shishi
 * @Date 2019/7/17 9:56
 **/

/**
 * 题目要求：
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 示例：
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Solution90 {
    // 参考网址https://www.jianshu.com/p/69a932587c07
    // 感觉还是不是很理解
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        List<Integer> pre = new ArrayList<>();
        dfs(nums,pre,0,result);
        return result;
    }

    private void dfs(int[] nums, List<Integer> pre, int begin, List<List<Integer>> result) {
        result.add(new ArrayList<>(pre));
        for (int i=begin;i<nums.length;i++){
            // 如果当前节点和前面的结点是一样的，就不要加入了
            if (i!=begin && nums[i]==nums[i-1]){
                continue;
            }
            pre.add(nums[i]);
            dfs(nums,pre,i+1,result);
            pre.remove(pre.size()-1);
        }
    }
}
