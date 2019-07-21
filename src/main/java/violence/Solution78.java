package violence;

/**
 * @ClassName Solution78
 * @Description 子集
 * @Author shishi
 * @Date 2019/7/13 20:59
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例：
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Solution78 {
    // 递归法
    public List<List<Integer>> subsets(int[] nums) {
        // 因为结果要求有序，所以先排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // 当前的路径，每一次都加到result里面
        List<Integer> path = new ArrayList<>();
        traversePath(nums,path,0,result);
        return result;
    }

    private void traversePath(int[] nums, List<Integer> path, int step, List<List<Integer>> result) {
        if (step==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        // 不选nums[step]
        traversePath(nums,path,step+1,result);

        // 选nums[step]
        path.add(nums[step]);
        traversePath(nums,path,step+1,result);

        // 回退
        path.remove(path.size()-1);
    }

}
