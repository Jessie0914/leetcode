package jianzhi;

/**
 * @ClassName JZ17
 * @Description 输入两棵二叉树A，B，判断B是不是A的子结构
 * ps：我们约定空树不是任意一个树的子结构
 * @Author shishi
 * @Date 2020/7/12 23:19
 **/

// JZ_MARK
public class JZ17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        boolean flag = false;
        if (root1.val == root2.val) {
            flag = judge(root1, root2);
        }

        if (!flag) {
            flag = judge(root1.left, root2);
        }

        if (!flag) {
            flag = judge(root1.right, root2);
        }

        return flag;
    }

    private boolean judge(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;

        if (root1.val == root2.val) {
            return judge(root1.left, root2.left) && judge(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
