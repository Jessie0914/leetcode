package violence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution47_2
 * @Description TODO
 * @Author shishi
 * @Date 2019/7/18 19:08
 **/
public class Solution47_2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,result,pre,used);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> pre, boolean[] used) {
        if (pre.size()==nums.length){
            result.add(new ArrayList<>(pre));
            return;
        }
        for (int i=0;i<nums.length;i++){
            // 如果是已经被使用过的元素，就跳过继续遍历
            if (used[i]==true)
                continue;

            // 如果出现了重复元素，并且跟它重复的上一个元素没有被使用过，那么它本身也不能使用
            if (i>0 && nums[i]==nums[i-1] && used[i-1]==false)
                continue;

            pre.add(nums[i]);
            used[i] = true;
            dfs(nums,result,pre,used);
            pre.remove(pre.size()-1);
            used[i] = false;
        }
    }
}
