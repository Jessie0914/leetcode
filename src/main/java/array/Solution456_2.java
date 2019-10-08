package array;

import java.util.Stack;

/**
 * @ClassName Solution456_2
 * @Description 456. 132模式
 * @Author shishi
 * @Date 2019/9/14 9:45
 **/
public class Solution456_2 {
    // 说是用单调栈，单调递增栈
    public boolean find132pattern(int[] nums) {
        if (nums.length<3) return false;

        Stack<Integer> stack = new Stack<>();
        // 先将最后一个元素压入栈
        stack.add(nums[nums.length-1]);
        // 初始化次大值
        int second = Integer.MIN_VALUE;

        for (int i=nums.length-2;i>=0;i--){
            // 找到可行方案
            if (nums[i]<second) return true;
            else {
                // 更新second值（second一直都是次大的值，栈内一直保存着最大的元素）
                while (!stack.isEmpty() && nums[i]>stack.peek()){
                    int pop = stack.pop();
                    second = Math.max(second,pop);
                }
                stack.add(nums[i]);
            }
        }
        return false;
    }
}
