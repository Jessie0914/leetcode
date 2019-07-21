package violence;

/**
 * @ClassName Solution47
 * @Description 47.全排列2
 * @Author shishi
 * @Date 2019/7/18 10:12
 **/

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Solution47 {
    // 比较粗笨的办法是，将result设置成Set集合，这样就会自动删掉那些重复的元素，但是效率不算高
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 设置成set集合，set的属性就是不重复
        Set<List<Integer>> res=new HashSet<>();
        List<Integer> tmp=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        dfs(res,tmp,used,nums);
        List<List<Integer>> result=new ArrayList<>(res);
        return result;
    }
    public  void dfs(Set<List<Integer>> res, List<Integer> tmp, boolean[] used, int[] nums) {
        if(tmp.size()==nums.length) {
            res.add(new ArrayList<>(tmp));
            return ;
        }
        for(int i=0;i<nums.length;i++) {
            if(used[i]!=true) {
                tmp.add(nums[i]);
                used[i]=true;
                dfs(res,tmp,used,nums);
                tmp.remove(tmp.size()-1);
                used[i]=false;
            }
        }
    }

}
