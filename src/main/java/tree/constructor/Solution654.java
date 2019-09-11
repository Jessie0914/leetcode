package tree.constructor;

/**
 * @program: leetcode
 * @description: 最大二叉树
 * @author: shishi
 * @create: 2019-09-11 11:58
 **/

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start>end) return null;

        int maxValue = findMaxValue(nums, start, end);
        int maxIndex = findMaxIndex(nums,maxValue,start,end);
        TreeNode root = new TreeNode(maxValue);

        root.left = construct(nums,start,maxIndex-1);
        root.right = construct(nums,maxIndex+1,end);
        return root;
    }

    private int findMaxIndex(int[] nums, int maxValue, int start, int end) {
        for (int i=start;i<=end;i++){
            if (nums[i]==maxValue)
                return i;
        }
        return -1;
    }

    private int findMaxValue(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i=start;i<=end;i++){
            if (nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }
}
