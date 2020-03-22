package violence;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution46
 * @Description 46.全排列
 * @Author shishi
 * @Date 2019/7/18 9:43
 **/

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution46 {
    // dfs比较好理解，参考网址：https://blog.csdn.net/zxzxzx0119/article/details/81452269
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(result,pre,nums,used);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> pre, int[] nums, boolean[] used) {
        if (pre.size()==nums.length){
            result.add(new ArrayList<>(pre));
            return;
        }
        for (int i=0;i<nums.length;i++){
            // 如果当前数字没有加入到pre中，就加入
            if (!used[i]){
                pre.add(nums[i]);
                used[i]=true;

                dfs(result,pre,nums,used);

                // 回退一步
                pre.remove(pre.size()-1);
                used[i]=false;
            }
        }
    }
}
