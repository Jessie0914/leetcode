package jianzhi;

/**
 * @ClassName JZ4
 * @Description 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * @Author shishi
 * @Date 2020/7/12 16:30
 **/
public class JZ4 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0)
            return null;

        return constructTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode constructTree(int[] pre, int left1, int right1, int[] in, int left2, int right2) {
        if (left1 > right1 || left2 > right2)
            return null;

        TreeNode root = new TreeNode(pre[left1]);
        int index = findMiddleIndex(pre[left1], in, left2, right2);
        int leftLen = index - left2;
        if (index != -1) {
            root.left = constructTree(pre, left1 + 1, left1 + leftLen, in, left2, index - 1);
            root.right = constructTree(pre, left1 + 1 + leftLen, right1, in, index + 1, right2);
        }

        return root;
    }

    private int findMiddleIndex(int target, int[] in, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (in[i] == target)
                return i;
        }
        return -1;
    }
}
