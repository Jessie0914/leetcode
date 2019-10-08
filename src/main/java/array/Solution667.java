package array;

/**
 * @ClassName Solution667
 * @Description 667. 优美的排列 II
 * @Author shishi
 * @Date 2019/9/25 9:22
 **/

/**
 * 输入: n = 3, k = 1
 * 输出: [1, 2, 3]
 *
 * 输入: n = 3, k = 2
 * 输出: [1, 3, 2]
 */
public class Solution667 {
    // 看的题解，精准简明
    // 初始化数组从1-n，此时差值种类为1；然后翻转2-n，增加一种差值，差值种类就会+1;……
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        // 初始化数组，此时k=1
        for (int i=0;i<n;i++){
            result[i] = i+1;
        }
        if (k==1) return result;
        else {
            int reverseTime = k-1;
            while (reverseTime>0){
                reverse(result,n-1-reverseTime,n-1);
                reverseTime--;
            }
            return result;
        }
    }

    // 翻转数组中指定范围的数据
    private void reverse(int[] result, int start, int end) {
        while (start<end){
            int temp = result[start];
            result[start] = result[end];
            result[end] = temp;
            start++;
            end--;
        }
    }
}
