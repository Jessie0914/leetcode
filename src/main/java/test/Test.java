package test;

/**
 * @ClassName Test
 * @Description 用来写代码过程中测试
 * @Author shishi
 * @Date 2019/6/26 10:39
 **/

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2};
    }

    public void reverse(int[] nums, int start, int end){
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
