package tree.constructor;

/**
 * @ClassName Solution105
 * @Description 105.从前序和中序遍历序列构造二叉树
 * @Author shishi
 * @Date 2019/7/9 19:39
 **/

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 递归求解，先从先序遍历中找到第一个节点即为根节点，然后在中序遍历中找到对应的值
 * 那么找到的位置的左边全是左子树的，右边全是右子树的，继续递归
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructTree(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    private TreeNode constructTree(int[] preorder, int begin1, int end1, int[] inorder, int begin2, int end2) {
        if (begin1==end1) return null;
        if (begin2==end2) return null;

        TreeNode root = new TreeNode(preorder[begin1]);
        int inOderPos = findPosInoder(inorder,begin2,end2,root.val);
        int leftSize = inOderPos-begin2;

        root.left = constructTree(preorder, begin1 + 1, begin1 + 1 + leftSize, inorder, begin2, begin2 + leftSize);
        root.right = constructTree(preorder, begin1 + 1 + leftSize, end1, inorder, inOderPos + 1, end2);
        return root;
    }

    private int findPosInoder(int[] array, int begin, int end, int val) {
        for (int i=begin;i<end;i++){
            if (array[i]==val){
                return i;
            }
        }
        return -1;
    }
}
