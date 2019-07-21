package tree.recursion;

/**
 * @ClassName Solution129_2
 * @Description 129.求根到叶子节点数字之和的另一种解法
 * @Author shishi
 * @Date 2019/7/11 21:40
 **/

/**
 * 其实和我的思路差不多，但我多用了很多空间，保存了每一条路径
 * 这里要计算一个总的结果就不需要浪费这么多空间
 */
public class Solution129_2 {
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }

    private int sum(TreeNode root, int sum) {
        if (root==null) return 0;
        if (root.left==null && root.right==null){
            return sum*10+root.val;
        }
        else {
            return sum(root.left,sum*10+root.val)+ sum(root.right,sum*10+root.val);
        }
    }
}
