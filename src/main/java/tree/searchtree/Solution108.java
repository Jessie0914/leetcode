package tree.searchtree;

/**
 * @ClassName Solution108
 * @Description 108.将有序数组转换为二叉搜索树
 * @Author shishi
 * @Date 2019/7/11 14:47
 **/

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 */
public class Solution108 {
    // 这题有个坑的点是：有很多不同的答案，运行测试用例的时候会得到和预期答案不同的结果，其实也是能通过的
    // 交给递归函数去处理
    public TreeNode sortedArrayToBST(int[] nums) {
        return generateArrayToBST(nums,0,nums.length-1);
    }

    // 递归函数需要的参数是数组、开始和结束的下标
    private TreeNode generateArrayToBST(int[] nums, int start, int end) {
        // 结束的标识
        if (start>end) return null;

        int length = end-start+1;
        int mid = start+length/2;
        // 取中间的结点为root
        TreeNode root = new TreeNode(nums[mid]);
        // 递归生成左子树和右子树，并与root拼接起来
        root.left = generateArrayToBST(nums, start, mid - 1);
        root.right = generateArrayToBST(nums, mid + 1, end);
        return root;
    }
}
