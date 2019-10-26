package array;

/**
 * @ClassName Solution525
 * @Description 525. 连续数组
 * @Author shishi
 * @Date 2019/10/25 20:18
 **/
public class Solution525 {
    public int findMaxLength(int[] nums) {
        return dfs(0,nums.length-1,nums);
    }

    private int dfs(int i, int j, int[] nums) {
        int count_zero = 0;
        int count_one = 0;
        for (int k=i;k<=j;k++){
            if (nums[k]==0)
                count_zero++;
            else
                count_one++;
        }
        if (count_one==count_zero)
            return j-i+1;
        else {
            int len1 = Integer.MAX_VALUE;
            int len2 = Integer.MAX_VALUE;
            int i1 = i,j1= j;
            int i2 = i,j2 = j;
            if (i+1<nums.length){
                len1 = dfs(i1+1,j1,nums);
            }
            if (j-1>=0){
                len2 = dfs(i2,j2-1,nums);
            }

            if (len1==Integer.MAX_VALUE&&len2==Integer.MAX_VALUE)
                return 0;
            else
                return Math.min(len1,len2);
        }
    }
}
