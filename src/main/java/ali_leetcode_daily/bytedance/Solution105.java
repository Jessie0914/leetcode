package ali_leetcode_daily.bytedance;

/**
 * @ClassName Solution105
 * @Description
 * @Author shishi
 * @Date 2020/7/28 22:55
 **/
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1 || s2 > e2)
            return null;

        int val = preorder[s1];
        TreeNode root = new TreeNode(val);

        int index = findMiddleIndex(val, inorder, s2, e2);
        if (index != -1) {
            int numsOfLeft = index - s2;
            root.left = construct(preorder, s1 + 1, s1 + numsOfLeft, inorder, s2, index - 1);
            root.right = construct(preorder, s1 + 1 + numsOfLeft, e1, inorder, index + 1, e2);
        }
        return root;
    }

    private int findMiddleIndex(int val, int[] inorder, int i, int j) {
        if (i > j)
            return -1;

        for (int k = i; k <= j; k++) {
            if (inorder[k] == val)
                return k;
        }
        return -1;
    }
}
