package tree.constructor;

/**
 * @ClassName Solution106
 * @Description 106.从后序和中序遍历构造二叉树
 * @Author shishi
 * @Date 2019/7/9 21:46
 **/

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 你可以假设树中没有重复的元素。
 */
public class Solution106 {
    // 和105题如法炮制即可
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTree(inorder,0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode constructTree(int[] inorder, int begin1, int end1, int[] postorder, int begin2, int end2) {
        if (begin1 == end1) return null;
        if (begin2 == end2) return null;
        TreeNode root = new TreeNode(postorder[end2-1]);

        int inorderPos = findPosInoder(inorder,begin1,end1,root.val);
        int leftSize = inorderPos - begin1;

        root.left = constructTree(inorder, begin1, inorderPos, postorder, begin2, begin2 + leftSize);
        root.right = constructTree(inorder, inorderPos + 1, end1, postorder, begin2 + leftSize, end2-1);
        return root;
    }

    private int findPosInoder(int[] array, int begin, int end, int val) {
        for (int i = begin;i<end;i++){
            if (array[i] == val){
                return i;
            }
        }
        return -1;
    }
}
