package array;

/**
 * @ClassName Solution456
 * @Description 456. 132模式
 * @Author shishi
 * @Date 2019/9/13 12:35 第一版，超时
 **/
public class Solution456 {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if (len<3) return false;

        boolean flag = false;
        int i=0,j=1,k=2;
        while (i<len-2 && !flag){
            j = i+1;
            int firstNum = nums[i];
            while (j<len-1 && !flag){
                int secondNum = nums[j];
                k = j+1;
                while (k<len && !flag){
                    int thirdNum = nums[k];
                    if (firstNum<thirdNum && thirdNum<secondNum){
                        flag = true;
                        break;
                    }
                    k++;
                }
                j++;
            }
            i++;
        }
        return flag;
    }
}
