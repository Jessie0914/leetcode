package math;

/**
 * @ClassName Solution338
 * @Description 338.比特位计数
 * @Author shishi
 * @Date 2019/7/27 10:05
 **/

/**
 * 给定一个非负整数 num。
 * 对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目
 * 并将它们作为数组返回。
 */
public class Solution338 {
    public int[] countBits(int num) {
        int[] nums = new int[num+1];
        for (int i=0;i<=num;i++){
            nums[i] = caculateCountOfZero(i);
        }
        return nums;
    }

    private int caculateCountOfZero(int i) {
        int count = 0;
        while (i>0){
            if (i%2==1) count++;
            i/=2;
        }
        return count;
    }
}
