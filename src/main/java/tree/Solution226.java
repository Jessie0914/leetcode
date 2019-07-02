package tree;

/**
 * @ClassName Solution226
 * @Description 226.翻转二叉树
 * @Author shishi
 * @Date 2019/6/27 20:14
 **/

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

/**
 * 题目要求：
 * 翻转一棵二叉树。
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        // 如果是空的，直接返回null
        if (root == null) return null;

        // 然后处理根节点
        // 直接先交换左右结点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 然后再递归处理左右结点
        TreeNode inversedLeft = invertTree(root.left);
        TreeNode inversedRight = invertTree(root.right);

        // 把翻转过后的左右子树赋给根节点
        root.left = inversedLeft;
        root.right = inversedRight;
        return root;
    }

    // 和上面的思想都是一样的，不过就是顺序颠倒一下，比我的要简洁
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        // 直接先颠倒左右结点
        TreeNode inversedLeft = invertTree(root.left);
        TreeNode inversedRight = invertTree(root.right);

        // 然后交换以后，赋给根节点
        root.left = inversedRight;
        root.right = inversedLeft;

        return root;
    }
}
