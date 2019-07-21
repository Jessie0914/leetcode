package tree.searchtree;

/**
 * @ClassName Solution95
 * @Description 95.不同的二叉搜索树2
 * @Author shishi
 * @Date 2019/7/11 13:31
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 */
public class Solution95 {
    // 这题也是看PDF才写出来的，知道是用递归解决，但是写不出来（现在总结一下）
    // 当n为0的时候，直接返回空List即可
    // 否则交给递归函数
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<TreeNode>();
        return generate(1,n);
    }

    // 递归函数，参数其实就是从1到n
    private List<TreeNode> generate(int start, int end) {
        // 新建一个List，用来保存结果
        ArrayList<TreeNode> list = new ArrayList<>();
        // 递归结束的条件
        if (start>end){
            list.add(null);
        }
        // 以start-end之间的任何一个值为root
        for (int k=start; k<=end; k++){
            // 递归生成以k为结点的左子树和右子树
            List<TreeNode> leftList = generate(start, k - 1);
            List<TreeNode> rightList = generate(k + 1, end);

            // 最后将左子树、右子树还有root连接起来
            // 这里的leftNode、rightNode是所有以k为root的左子树和右子树结点的集合
            for (TreeNode leftNode : leftList){
                for (TreeNode rightNode : rightList){
                    TreeNode root = new TreeNode(k);
                    root.left = leftNode;
                    root.right = rightNode;
                    // 连接起来以后，将这个root结点加入list即可
                    list.add(root);
                }
            }
        }
        return list;
    }
}
