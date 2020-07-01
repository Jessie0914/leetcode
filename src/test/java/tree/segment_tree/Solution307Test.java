package tree.segment_tree;


public class Solution307Test {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        Solution307 solution307 = new Solution307(nums);
        System.out.println(solution307.sumRange(0,2));
        solution307.update(1,2);
        System.out.println(solution307.sumRange(0,2));

    }

}