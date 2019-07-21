package tree.traversal;

/**
 * @ClassName Solution114
 * @Description 114.二叉树展开成链表
 * @Author shishi
 * @Date 2019/7/9 12:21
 **/

/**
 * 给定一个二叉树，原地将它展开为链表。
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) return; // 终止条件
        flatten(root.left);
        flatten(root.right);
        if (root.left == null) return;
        // 三方合并，将左子树所形成的链表插入到root和root->right之间
        TreeNode p = root.left;
        while(p.right != null) p = p.right; //寻找左链表最后一个节点
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    // 也是递归的解法
    public void flatten2(TreeNode root) {
        treeToList(root);
    }

    // 分别递归左子树和右子树，然后把根节点的左子树置null
    // 遍历之后的左子树先挂在root的右子树上，然后再顺着往下找到最后一个结点，再挂上遍历后的右子树
    private TreeNode treeToList(TreeNode root) {
        if (root==null) return null;
        TreeNode right = treeToList(root.right);
        TreeNode left = treeToList(root.left);
        root.right = left;
        root.left = null;
        TreeNode tmp = root;
        while (tmp.right!=null){
            tmp = tmp.right;
        }
        tmp.right = right;
        return root;
    }
}

