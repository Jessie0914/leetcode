package jianzhi;

/**
 * @Classname JZ26
 * @Description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * @Date 2020/7/23 3:20 下午
 * @Created by chiyue
 */

// JZ_MARK
public class JZ26 {
    private TreeNode realHead = null;
    private TreeNode curLastNode = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        helper(pRootOfTree);
        return realHead;
    }

    // 中序遍历并改变指针
    private void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);

        // 第一次遍历到最后
        if (curLastNode == null) {
            // 如果是null的话，代表是第一次遍历到最最左下角，这时候填充realHead的值
            realHead = root;
            curLastNode = root;
        } else {
            // 双向链表连接起来
            curLastNode.right = root;
            root.left = curLastNode;

            // 更新curLastNode
            curLastNode = root;
        }

        helper(root.right);
    }
}
