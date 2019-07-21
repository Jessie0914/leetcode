package tree.recursion;

/**
 * @ClassName Solution113
 * @Description 113.路径总和2
 * @Author shishi
 * @Date 2019/7/11 19:33
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        pathCurSum(root,sum,cur,result);
        return result;
    }

    private void pathCurSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> result) {
        if (root==null) return;
        cur.add(root.val);
        if (root.left==null && root.right==null){
            // 这时候需要判断是否是合法路径
            if (sum==root.val) {
                // 把cur这个list加入到result
                result.add(new ArrayList<>(cur));
            }
        }else {
            pathCurSum(root.left,sum-root.val,cur,result);
            pathCurSum(root.right,sum-root.val,cur,result);
        }

        // 如果不符合或者当前节点的左右子树都已经遍历过了，就回退一步
        cur.remove(cur.size()-1);
    }
}
