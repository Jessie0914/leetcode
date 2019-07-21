/**
 * @ClassName Solution400
 * @Description 400.第N个数字
 * @Author shishi
 * @Date 2019/7/19 16:01
 **/

/**
 * 题目要求：
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * 注意：是第n个数字，不是第n个数
 *
 * 示例：
 * 输入: 11
 * 输出: 0
 * 说明: 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 */
public class Solution400 {
    // 按照我这种做法，虽然简单粗暴，但是超时了。。。
    public int findNthDigit(int n) {
        int count = 0;
        int cur = 1;
        while (cur<=n){
            int temp = cur;
            int[] nums = intToArray(temp);
            for (int i=0;i<nums.length;i++){
                count++;
                if (count==n) return nums[i];
            }
            cur++;
        }
        return 0;
    }

    private int[] intToArray(int n){
        String s = Integer.toString(n);
        int[] nums = new int[s.length()];
        for (int i=0;i<s.length();i++){
            nums[i] = s.charAt(i)-'0';
        }
        return nums;
    }

    // 应该用这种方法，需要找一下规律
    // 参考网址：https://blog.csdn.net/qq_25481047/article/details/88631173
    public int findNthDigit2(int n) {
        // 都要设置成long，不然当n很大的时候会超出限制
        long len =1; // 初始长度
        long cnt = 9; // 初始乘数
        long start = 1; // 初始行的初始值
        // 这是为了找到在哪一行（len的值）
        while (cnt * len < n){
            n -= cnt * len;
            len++;
            cnt *= 10;
            start *= 10;
        }
        // 然后找到在第len行的第几个数字，然后加上初始值就是需要找到的数
        long curNum = start + (n-1)/len;
        String s = Long.toString(curNum);

        // index是指最终要找的那个数字是找到的数的第几个数字
        int index =(int) ((n-1)%len);
        return s.charAt(index)-'0';
    }

}
