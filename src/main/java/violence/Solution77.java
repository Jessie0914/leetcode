package violence;

/**
 * @ClassName Solution77
 * @Description 77.组合
 * @Author shishi
 * @Date 2019/7/18 19:39
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> pre = new ArrayList<>();
        dfs(result,pre,1,0,n,k);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayList<Integer> pre, int start, int count, int n, int k) {
        // 如果计数已经达到了k值，就停止
        if (count==k){
            result.add(new ArrayList<>(pre));
        }
        // 从start开始添加
        for (int i=start;i<=n;i++){
            pre.add(i);
            dfs(result,pre,i+1,count+1,n,k);
            pre.remove(pre.size()-1);
        }
    }

}
