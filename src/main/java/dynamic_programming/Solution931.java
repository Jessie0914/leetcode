package dynamic_programming;

/**
 * @ClassName Solution931
 * @Description 931. 下降路径最小和
 * @Author shishi
 * @Date 2019/10/19 10:26
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 *
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：12
 */
public class Solution931 {
    // 动态规划
    public int minFallingPathSum(int[][] A) {
        // dp[r][c]代表的是从[r][c]这个点开始的下降路径最小和
        int[][] dp = new int[A.length][A[0].length];

        // 初始化dp数组为A数组最后一行的值
        // 代表从那一个点开始的最短下降子序列和
        for (int i=0;i<A[0].length;i++){
            dp[A.length-1][i] = A[A.length-1][i];
        }

        // 然后从下往上动态规划
        int row = A.length;
        int col = A[0].length;
        for (int i=row-2;i>=0;i--){
            // 更新dp[i][j]的值
            for (int j=0;j<col;j++){
                int sum1=0,sum2=0,sum3=0,sum = Integer.MAX_VALUE;
                if (i+1<row&&j<col){
                    sum1 = dp[i+1][j];
                    sum = Math.min(sum1,sum);
                }
                if (i+1<row&&j+1<col){
                    sum2 = dp[i+1][j+1];
                    sum = Math.min(sum2,sum);
                }
                if (i+1<row&&j-1>=0){
                    sum3 = dp[i+1][j-1];
                    sum = Math.min(sum3,sum);
                }

                dp[i][j] = sum + A[i][j];
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j=0;j<col;j++){
            if (dp[0][j]<res)
                res = dp[0][j];
        }
        return res;
    }

    // 本来想用dfs的，失败了。。
    public int minFallingPathSum2(int[][] A) {
        int depth = A.length;
        int row = A[0].length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur_list = new ArrayList<>();
        dfs(0,0,0,row,depth,cur_list,list,A);
        int res = Integer.MAX_VALUE;
        for (int i=0;i<list.size();i++){
            int count = 0;
            List<Integer> list1 = list.get(i);
            for (int j=0;j<list1.size();j++){
                count += list1.get(i);
            }
            if (count<res)
                res = count;
        }
        return res;
    }

    private void dfs(int i, int j, int cur_depth, int row, int depth, List<Integer> cur_list, List<List<Integer>> list, int[][] A) {
        cur_list.add(A[i][j]);
        cur_depth++;
        if (cur_depth==depth) {
            list.add(new ArrayList<>(cur_list));
            return;
        }

        // 往右下方走
        if (i+1<depth&&j+1<row){
            dfs(i+1,j+1,cur_depth,row,depth, cur_list, list,A);
        }
        // 回退
        cur_list.remove(cur_list.size()-1);
        // 往下方走
        if (i+1<depth&&j<row){
            dfs(i+1,j,cur_depth,row,depth, cur_list, list,A);
        }
        // 回退
        cur_list.remove(cur_list.size()-1);
        // 往左下方走
        if (i+1<depth&&j-1>=0){
            dfs(i+1,j-1,cur_depth,row,depth, cur_list, list,A);
        }
        // 回退
        cur_list.remove(cur_list.size()-1);

    }
}
